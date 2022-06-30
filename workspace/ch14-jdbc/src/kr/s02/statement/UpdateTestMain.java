package kr.s02.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class UpdateTestMain {

	public static void main(String[] args) {
		String db_driver ="oracle.jdbc.OracleDriver";
		String db_url = "jdbc:oracle:thin:@192.168.219.100:1521:xe";//안되면 localhost
		String db_id = "c##user01";
		String db_password = "1234";
		
		Connection conn = null;
		Statement stmt = null;
		String sql = null;
		
		try {
			//JDBC 1단계 : 드라이버 로드
			Class.forName(db_driver);
			//JDBC 2단계 : 커넥션 객체 생성 계정인증
			conn = DriverManager.getConnection(db_url,db_id,db_password);
			//sql
			sql = "update test1 set age=80 where id='dragon'";
			//JDBC 3단계 : statement 객체 생성
			stmt = conn.createStatement();
			
			//JDBC 4단계 : SQL문 실행
			//update문을 실행해서 테이블의 행을 수정하고 수저한 행의 개수를 반환
			int count = stmt.executeUpdate(sql);
			System.out.println(count + "개 행의 정보를 수정했습니다.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(stmt!=null) try {stmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
	}

}
