package kr.s02.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTestMain {

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
			
			//JDBC 수행 2단계 : Connection 객체 생성
			conn = DriverManager.getConnection(db_url,db_id,db_password);
			
			//sql문 작성
			//데이터에 ' 넣으려면 '' 두번쓴다 -> 불편, 개선 -> PreparedStatement
			sql = "insert into test1 (id, age) values ('she''s', 20)";
			
			//JDBC 수행 3단계 : Statement 객체 생성
			stmt = conn.createStatement();
			
			//JDBC 수행 4단계 : sql문 실행해서 하나의 행을 삽입
			//삽입 작업 후 삽입한 행의 갯수를 반환
			//(Connection이 지원) SQL문이 하나일 경우 정상적으로 실행되면 자동 커밋됨
			//					 실행되지 않으면 자동 롤백
			int count = stmt.executeUpdate(sql);
			
			System.out.println(count + "개의 행을 추가했습니다.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원정리
			if(stmt!=null) try {stmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
	}

}
