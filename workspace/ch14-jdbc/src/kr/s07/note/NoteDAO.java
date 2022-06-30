package kr.s07.note;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import kr.s03.preparedstatement.DBUtil;

/*
 * DAO : Date Access Object
 * 		 데이터베이스의 데이터를 전문적으로 호출하고 제어하는 객체
 */
public class NoteDAO {
	
	//글쓰기
	public void insertInfo(String name,String passwd, String subject, 
						   String content, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2 단계
			conn = DBUtil.getConnection();
			//sql문 작성
			sql = "insert into note values(note_seq.nextval, ?,?,?,?,?,sysdate)";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, passwd);
			pstmt.setString(3, subject);
			pstmt.setString(4, content);
			pstmt.setString(5, email);
			//JDBC 수행 4단계 : SQL문을 실행해서 테이블에 행을 추가
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행이 추가되었습니다.");
			
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
			//jdbc 수행 1,2단계
			conn = DBUtil.getConnection();
			//sql문 작성
			sql = "select * from note order by num desc";
			//jdbc 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//jdbc 수행 4단계
			rs = pstmt.executeQuery();
			System.out.println("----------------------------------------");
			System.out.println("글번호\t이름\t작성일\t\t제목");
			while(rs.next()) {
				System.out.print(rs.getInt("num")+"\t");
				System.out.print(rs.getString("name")+"\t");
				System.out.print(rs.getDate("reg_date")+"\t");
				System.out.println(rs.getString("subject"));
			}
			System.out.println("----------------------------------------");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs,pstmt,conn);
		}
	}
	
	//상세글보기
	public void selectDetailInfo(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//jdbc 수행 1,2 단계
			conn = DBUtil.getConnection();
			//sql문 작성
			sql = "select * from note where num=?";
			//jdbc 수행 3단계
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,num);
			
			//jdbc 수행 4단계
			rs = pstmt.executeQuery();
			
			//반환되는 행이 하나이기 떄문에 while문 쓰지 않음
			if(rs.next()) {
				System.out.println("글번호 : "+ rs.getInt("num"));
				System.out.println("이름 : "+ rs.getString("name"));
				System.out.println("비밀번호 : "+ rs.getString("passwd"));
				System.out.println("제목 : "+ rs.getString("subject"));
				System.out.println("내용 : "+ rs.getString("content"));
				System.out.println("이메일 : "+ rs.getString("email"));
				System.out.println("작성일 : "+ rs.getDate("reg_date"));
			}else {
				System.out.println("검색된 정보가 없습니다.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	
	//글수정
	public void updateInfo(int num, String name, String passwd, 
							String subject, String content, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//jdbc 1,2
			conn = DBUtil.getConnection();
			
			sql = "update note set name=?,passwd=?,subject=?,content=?,email=? where num=?";
			//jdbc 3
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, passwd);
			pstmt.setString(3, subject);
			pstmt.setString(4, content);
			pstmt.setString(5, email);
			pstmt.setInt(6, num);
			
			//jdbc 4
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행을 수정했습니다.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	//글삭제
	public void deleteInfo(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//jdbc 1,2
			conn = DBUtil.getConnection();
			sql = "delete from note where num=?";
			//jdbc 3
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			//jdbc 4
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행을 삭제했습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
}
