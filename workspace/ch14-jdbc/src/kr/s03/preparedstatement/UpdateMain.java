package kr.s03.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateMain {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//sql 작성
			sql = "update test1 set age=? where id=? ";
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setInt(1, 28);//첫 번째 물음표
			pstmt.setString(2, "blue");//두 번째 물음표
			
			//JDBC 수행 4단계 : sql문을 실행해서 테이블에 데이터를 수정
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행의 정보를 수정했습니다.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원정리
			DBUtil.executeClose(null,pstmt,conn);
		}
	}

}
