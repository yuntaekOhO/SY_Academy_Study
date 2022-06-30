package kr.s04.preparedstatement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.s03.preparedstatement.DBUtil;

public class SelectDetailMain {

	public static void main(String[] args) {
		BufferedReader br = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("번호:");
			int num = Integer.parseInt(br.readLine());
			
			//JDBC 수행 1,2단계 : 드라이버 로드, Connection 객체 생성
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "select * from test2 where num=?";
			
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setInt(1, num);
			
			//JDBC 수행 4단계 : SQL문을 테이블에 반영하고 (하나의)결과행을 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();
			if(rs.next()) {//하나의 행 존재
				System.out.println("번호 : " + rs.getInt("num"));
				System.out.println("제목 : " + rs.getString("title"));
				System.out.println("작성자 : " + rs.getString("name"));
				System.out.println("내용 : " + rs.getString("memo"));
				System.out.println("이메일 : " + rs.getString("email"));
				System.out.println("작성일 : " + rs.getDate("reg_date"));
			}else {//행 미존재
				System.out.println("검색된 데이터가 없습니다.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(br!=null)try {br.close();}catch(IOException e) {}
			DBUtil.executeClose(rs,pstmt,conn);
		}
	}

}
