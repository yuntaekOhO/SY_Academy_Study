package kr.s02.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class DeleteTestMain {

	public static void main(String[] args) {
		String db_driver ="oracle.jdbc.OracleDriver";
		String db_url = "jdbc:oracle:thin:@192.168.219.100:1521:xe";//안되면 localhost
		String db_id = "c##user01";
		String db_password = "1234";
		
		Connection conn = null;
		Statement stmt = null;
		String sql = null;
		try {
			//JDBC 수행 1단계 : 드라이버 로드
			Class.forName(db_driver);
			//JDBC 수행 2단계 : connection 객체 생성 (url,id,pw 인증)
			conn = DriverManager.getConnection(db_url,db_id,db_password);
			//sql문 작성
			sql = "delete from test1 where id='sky'";
			//JDBC 수행 3단계 : Statement 객체 생성
			stmt = conn.createStatement();
			//JDBC 수행 4단계 : SQL문을 실행해서 테이블에서 행을 삭제한 후
			//삭제한 행의 개수를 반환
			int count = stmt.executeUpdate(sql);
			System.out.println(count + "개의 행을 삭제했습니다.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(stmt!=null) try {stmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
	}

}
