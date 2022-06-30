package kr.s04.preparedstatement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.s03.preparedstatement.DBUtil;

public class UpdateMain {

	public static void main(String[] args) {
		BufferedReader br = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("번호:");
			int num = Integer.parseInt(br.readLine());
			System.out.print("제목:");
			String title = br.readLine();
			System.out.print("이름:");
			String name = br.readLine();
			System.out.print("내용:");
			String memo = br.readLine();
			System.out.print("이메일:");
			String email = br.readLine();
			
			//jdbc 수행 1,2단계
			conn = DBUtil.getConnection();
			sql = "update test2 set title=?, name=?, memo=?, email=? where num=?";
			
			//jdbc 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터바인딩
			pstmt.setString(1, title);
			pstmt.setString(2, name);
			pstmt.setString(3, memo);
			pstmt.setString(4, email);
			pstmt.setInt(5, num);
			
			//jdbc 수행 4단계 : sql문을 실행해서 테이블에서 하나의 행을 수정
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행의 정보를 수정했습니다.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(br!=null)try {br.close();}catch(IOException e) {}
			DBUtil.executeClose(null, pstmt, conn);
		}
	}

}
