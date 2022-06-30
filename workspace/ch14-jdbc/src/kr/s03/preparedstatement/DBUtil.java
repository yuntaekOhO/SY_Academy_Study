package kr.s03.preparedstatement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class DBUtil {
	private static final String db_driver = "oracle.jdbc.OracleDriver";
	private static final String db_url = "jdbc:oracle:thin:@192.168.219.100:1521:xe";
	private static final String db_id = "c##user01";
	private static final String db_password = "1234";
	
	//Connection 객체 생성 및 반환
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		//JDBC 수행 1단계 : 드라이버 로드
		Class.forName(db_driver);
		//JDBC 수행 2단계 : Connection 객체 생성
		return DriverManager.getConnection(db_url,db_id,db_password);
	}
	
	//자원정리
	public static void executeClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs!=null)try {rs.close();}catch(SQLException e){}
		if(pstmt!=null)try {pstmt.close();}catch(SQLException e){}
		if(conn!=null)try {conn.close();}catch(SQLException e){}
	}
	
}
