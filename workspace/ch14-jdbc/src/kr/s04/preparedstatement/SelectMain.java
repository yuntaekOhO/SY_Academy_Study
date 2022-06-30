package kr.s04.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.s03.preparedstatement.DBUtil;

public class SelectMain {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "select * from test2 order by num desc";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//JDBC 수행 4단계 : SQL문을 실행해서 테이블로부터 결과행들을 읽어들여 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();
			System.out.println("번호\t작성자\t제목\t날짜");
			while(rs.next()) {
				System.out.print(rs.getInt("num")+"\t");
				System.out.print(rs.getString("name")+"\t");
				System.out.print(rs.getString("title")+"\t");
				//연월일시분초 형식으로 데이터 반환
				//System.out.println(rs.getString("reg_date"));
				//연월일 형식으로 데이터 반환
				System.out.println(rs.getDate("reg_date"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}

}
