package kr.s03.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteMain {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//sql문 작성
			sql = "delete from test1 where id=?";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, "star");
			//JDBC 수행 4단계
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행을 삭제했습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원정리
							  // rs, stmt, conn
			DBUtil.executeClose(null,pstmt,conn);
		}
	}

}
