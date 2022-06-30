package kr.s05.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import kr.s03.preparedstatement.DBUtil;

public class CallableStatementMain {

	public static void main(String[] args) {
		Connection conn = null;
		CallableStatement cstmt = null;
		String sql = null;
		
		String name = "lee";
		float rate = 0.06f;
		
		try {
			//jdbc 수행 1,2단계
			conn = DBUtil.getConnection();
			
			//프로시저 호출
			sql = "{call adjust(?,?)}";
			
			//jdbc 수행 3단계
			cstmt = conn.prepareCall(sql);
			//?에 데이터바인딩
			cstmt.setString(1, name);
			cstmt.setFloat(2, rate);
			
			//jdbc 수행 4단계 : 프로시저를 호출해서 파라미터로 데이터 전달
			//프로시저가 호출되면 지정한 이름의 급여를 갱신
			int count = cstmt.executeUpdate();
			System.out.println(count +"개의 급여 정보를 수정했습니다.");
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(cstmt!=null)try {cstmt.close();}catch(SQLException e) {}
			DBUtil.executeClose(null, null, conn);
		}
		
	}

}
