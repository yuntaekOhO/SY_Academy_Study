package kr.s01.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMain {

	public static void main(String[] args) {
		//오라클 연동 테스트
		String db_driver ="oracle.jdbc.OracleDriver";
		String db_url = "jdbc:oracle:thin:@192.168.219.100:1521:xe";//안되면 localhost
		String db_id = "c##user01";
		String db_password = "1234";
		
		try {
			Class.forName(db_driver);
			
			Connection conn = DriverManager.getConnection(db_url,db_id,db_password);
			
			System.out.println("Connection 객체가 생성되었습니다.");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
