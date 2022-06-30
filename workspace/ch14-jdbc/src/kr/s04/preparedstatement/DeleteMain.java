package kr.s04.preparedstatement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.s03.preparedstatement.DBUtil;

public class DeleteMain {

	public static void main(String[] args) {
		BufferedReader br = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("삭제할 행의 번호:");
			int num = Integer.parseInt(br.readLine());
			
			//jdbc 수행 1,2 단계
			conn = DBUtil.getConnection();
			sql = "delete from test2 where num=?";
			//jdbc 수행 3단계
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행을 삭제했습니다.");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(br!=null)try {br.close();}catch(IOException e) {}
			DBUtil.executeClose(null, pstmt, conn);
		}
	}

}
