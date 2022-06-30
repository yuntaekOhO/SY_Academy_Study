package kr.s03.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class SelectMain {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "select * from test1";
			//JDBC 수행 3단계 : PrepareStatement 객체 생성
			//Statement와는 다르게 PrepareStatement는 sql문을 초기화할 때[3단계] sql을 넣는다
			//Statement는 execute~()[4단계]에 넣었음
			pstmt = conn.prepareStatement(sql);
			//JDBC 수행 4단계 : SQL문을 실행해서 테이블로부터 결과행들을 읽어들여 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();
			System.out.println("ID\t나이");
			
			while(rs.next()) {
				System.out.print(rs.getString("id"));
				System.out.print("\t");
				System.out.print(rs.getString("age"));
				System.out.print("\n");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원정리
			DBUtil.executeClose(rs,pstmt,conn);
		}
	}

}
