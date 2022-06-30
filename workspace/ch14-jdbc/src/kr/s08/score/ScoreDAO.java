package kr.s08.score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 

import kr.s03.preparedstatement.DBUtil;

public class ScoreDAO {
	
	//성적입력
	public void insertInfo(String name, int korean, int english, int math, int sum, int avg, String grade) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			//jdbc 1,2
			conn = DBUtil.getConnection();
			//sql
			sql = "insert into score values (score_seq.nextval,?,?,?,?,?,?,?,sysdate)";
			//jdbc 3
			pstmt = conn.prepareStatement(sql);
			//data binding
			pstmt.setString(1, name);
			pstmt.setInt(2, korean);
			pstmt.setInt(3, english);
			pstmt.setInt(4, math);
			pstmt.setInt(5, sum);
			pstmt.setInt(6, avg);
			pstmt.setString(7, grade);
			//jdbc 4
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행을 추가했습니다.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	//목록보기
	public void selectInfo() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			//jdbc 1,2
			conn = DBUtil.getConnection();
			//sql
			sql = "select * from score order by num desc";
			//jdbc 3
			pstmt = conn.prepareStatement(sql);
			//jdbc 4
			rs = pstmt.executeQuery();
			System.out.println("번호\t이름\t국어\t영어\t수학\t총합\t평균\t등급");
			System.out.println("---------------------------------------------------------------------");
			while(rs.next()) {
				System.out.print(rs.getInt("num")+"\t");
				System.out.print(rs.getString("name")+"\t");
				System.out.print(rs.getInt("korean")+"\t");
				System.out.print(rs.getInt("english")+"\t");
				System.out.print(rs.getInt("math")+"\t");
				System.out.print(rs.getInt("sum")+"\t");
				System.out.print(rs.getInt("avg")+"\t");
				System.out.println(rs.getString("grade"));
			}
			System.out.println("---------------------------------------------------------------------");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	//성적수정
	public void updateInfo(int num,String name, int korean, int english, int math, 
													int sum, int avg, String grade) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//jdbc 1,2
			conn = DBUtil.getConnection();
			//sql
			sql = "update score set name=?,korean=?,english=?,math=?,sum=?,avg=?,grade=? where num=?";
			//jdbc 3
			pstmt = conn.prepareStatement(sql);
			//? data binding
			pstmt.setString(1, name);
			pstmt.setInt(2, korean);
			pstmt.setInt(3, english);
			pstmt.setInt(4, math);
			pstmt.setInt(5, sum);
			pstmt.setInt(6, avg);
			pstmt.setString(7, grade);
			pstmt.setInt(8, num);
			
			//jdbc 4
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행이 수정되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	//성적삭제
	public void deleteInfo(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			//jdbc 1,2
			conn = DBUtil.getConnection();
			//sql
			sql = "delete from score where num=?";
			//jdbc 3
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			//jdbc 4
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행이 삭제되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}

	// 성적상세보기
	public void selectDetailInfo(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			//jdbc 1,2
			conn = DBUtil.getConnection();
			//sql
			sql = "select * from score where num=?";
			//jdbc 3
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,num);
			//jdbc 4
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("번호: " + rs.getInt("num"));
				System.out.println("이름: " + rs.getString("name"));
				System.out.println("국어: " + rs.getInt("korean"));
				System.out.println("영어: " + rs.getInt("english"));
				System.out.println("수학: " + rs.getInt("math"));
				System.out.println("총점: " + rs.getInt("sum"));
				System.out.println("평균: " + rs.getInt("avg"));
				System.out.println("등급: " + rs.getString("grade"));
				System.out.println("등록일: " + rs.getString("reg_date"));
			}else {
				System.out.println("없는 번호입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}

}
