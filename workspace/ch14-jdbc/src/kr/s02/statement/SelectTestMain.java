package kr.s02.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTestMain {

	public static void main(String[] args) {
		String db_driver ="oracle.jdbc.OracleDriver";
		String db_url = "jdbc:oracle:thin:@192.168.219.100:1521:xe";//안되면 localhost
		String db_id = "c##user01";
		String db_password = "1234";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//JDBC 수행 1단계 : 드라이버 로드
			Class.forName(db_driver);
			//JDBC 수행 2단계 : connect 객체 생성 (url, id, pw)
			conn = DriverManager.getConnection(db_url,db_id,db_password);
			//SQL문 작성
			sql = "select * from test1";
			//JDBC 수행 3단계 : statement 객체 생성
			stmt = conn.createStatement();
			
			//JDBC 수행 4단계 : sql문 실행해서 테이블로부터 결과행들을 전달받아서
			//				  ResultSet 객체에 담아 반환
			rs = stmt.executeQuery(sql);
			
			//ResultSet에 보관된 결과집합에 접근해서 행 단위로 데이터를 추출
			while(rs.next()) {
				//컬럼명을 통해서 데이터를 반환
				/*
				System.out.print(rs.getString("id"));
				System.out.print("\t");
				System.out.print(rs.getInt("age"));// age는 number : Int type, String type 둘 다 가능
				System.out.print("\n");
				*/
				
				//컬럼 인덱스를 통해서 데이터를 반환 : 컬럼이 하나일 때
				System.out.print(rs.getString(1)); //테이블 인덱스 1부터 시작
				System.out.print("\t");
				System.out.print(rs.getInt(2));
				System.out.print("\n");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원정리
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			if(stmt!=null) try {stmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
	}

}
