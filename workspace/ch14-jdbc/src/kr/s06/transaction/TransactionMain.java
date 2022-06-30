package kr.s06.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.s03.preparedstatement.DBUtil;

public class TransactionMain {

	public static void main(String[] args) {
		Connection conn = null;
		//여러개의 SQL문을 실행할 경우 하나의 SQL문에 하나의 PreparedStatement를 생성해야한다.	
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			
			//트랜잭션 처리를 위해서 auto commit 해제
			//두개 이상의 SQL문을 실행할 경우 auto commit을 해제해야한다
			conn.setAutoCommit(false);
			
			sql = "insert into test1 values ('Korea',500)";
			pstmt1 = conn.prepareStatement(sql);
			pstmt1.executeUpdate();
			
			sql = "insert into test1 values ('England',400)";
			pstmt2 = conn.prepareStatement(sql);
			pstmt2.executeUpdate();
			
			//테스트용으로 오류가 있는 sql문 작성
			sql = "insert into test1 values ('China',300";
			pstmt3 = conn.prepareStatement(sql);
			pstmt3.executeUpdate();
			
			//정상적으로 작업이 완료되면 commit
			//3개의 sql문이 모두 정상적으로 실행되어야만 커밋한다 = 하나라도 잘못되면 모두 반영되지 않음.
			conn.commit();
			
			System.out.println("작업 완료!!");
			
		}catch(Exception e) {
			e.printStackTrace();
			//예외가 발생했을 경우 rollback
			try {
				conn.rollback();
			}catch(SQLException el) {
				el.printStackTrace();
			}
		}finally {
			//pstmt는 1,2,3 순서 상관없지만 conn은 마지막에 해야함
			DBUtil.executeClose(null, pstmt3, null);
			DBUtil.executeClose(null, pstmt2, null);
			DBUtil.executeClose(null, pstmt1, conn);
		}
	}

}
