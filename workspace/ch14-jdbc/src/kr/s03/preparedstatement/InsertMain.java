package kr.s03.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertMain {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "insert into test1 (id,age) values(?,?)";
			
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터를 바인딩
			pstmt.setString(1, "he's"); // 1번째 물음표에 "star" 넣음
			pstmt.setInt(2, 50);// 2번째 물음표에 정수형 50 넣음
			
			//JDBC 수행 4단계 
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행을 추가했습니다.");
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}

}
