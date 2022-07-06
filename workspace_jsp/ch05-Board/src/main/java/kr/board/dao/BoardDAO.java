package kr.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.board.vo.BoardVO;

public class BoardDAO {
	//싱글턴 패턴
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	private BoardDAO() {}
	
	//context.xml에서 설정정보를 읽어들여 커넥션풀로부터 커넥션을 할당받음
	private Connection getConnection()throws Exception{
		Context initCtx = new InitialContext();
		DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/xe");
		return ds.getConnection();
	}
	
	//자원정리
	private void executeClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs!=null)try {rs.close();}catch(SQLException e) {}
		if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
		if(conn!=null)try {conn.close();}catch(SQLException e) {}
	}
	
	//글 저장
	public void insert(BoardVO boardVO)throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2 단계 : 커넥션풀로부터 커넥션 할당
			conn = getConnection();
			//SQL문 작성 num,title,name,passwd,content,ip,reg_date
			sql = "INSERT INTO mboard (num,title,name,passwd,content,ip,reg_date) "
					+ "VALUES (mboard_seq.nextval,?,?,?,?,?,SYSDATE)";
			
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터바인딩
			pstmt.setString(1, boardVO.getTitle());
			pstmt.setString(2, boardVO.getName());
			pstmt.setString(3, boardVO.getPasswd());
			pstmt.setString(4, boardVO.getContent());
			pstmt.setString(5, boardVO.getIp());
			
			//JDBC 수행 4단계 : SQL문 실행
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null,pstmt,conn);
		}
	}
	
	//글의 총개수
	public int getCount()throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;
		
		try {
			//JDBC 수행 1,2단계 : 커넥션풀로부터 커넥션을 할당
			conn = getConnection();
			//SQL문 작성
			sql = "SELECT COUNT(*) FROM mboard";
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//JDBC 수행 4단계 : SQL문 실행해 테이블에 반영하고 결과행을 rs에 담음
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1); //컬럼 인덱스
			}
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(rs, pstmt, conn);
		}
		
		return count;
	}
	
	//목록
	public List<BoardVO> getList(int startRow, int endRow)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> list = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계 : 커넥션풀로부터 커넥션 할당
			conn = getConnection();
			//sql문 작성
			sql = "SELECT * FROM (SELECT a.*, rownum rnum "
							   + "FROM (SELECT * FROM mboard ORDER BY num DESC) a) "
					+ "WHERE rnum>=? AND rnum<=?";
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터바인딩
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			//JDBC 수행 4단계 : SQL문을 테이블에 반영하고 결과행들을 rs에 담음
			rs = pstmt.executeQuery();
			
			//ArrayList 객체 생성
			list = new ArrayList<BoardVO>();
			while(rs.next()) {
				//자바빈 객체 생성, rs에 저장된 데이터를 자바빈 set메서드로 자바빈에 저장
				BoardVO boardVO = new BoardVO();
				boardVO.setNum(rs.getInt("num"));
				boardVO.setName(rs.getString("name"));
				boardVO.setTitle(rs.getString("title"));
				boardVO.setReg_date(rs.getDate("reg_date"));
				
				//자바빈을 ArrayList에 저장
				list.add(boardVO);
			}
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(rs,pstmt,conn);
		}
		
		return list;
	}
	
	//글 상세
	public BoardVO getBoard(int num)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO board = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계 : 커넥션풀로부터 커넥션 할당
			conn = getConnection();
			//SQL문 작성
			sql = "SELECT * FROM mboard WHERE num=?";
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터바인딩
			pstmt.setInt(1, num);
			//JDBC 수행 4단계 : SQL문을 테이블에 반영하고 결과행을 rs에 담음
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//자바빈 객체 생성. 자바빈의 set메서드를 이용해 데이터 저장
				board = new BoardVO();
				board.setNum(rs.getInt("num"));
				board.setTitle(rs.getString("title"));
				board.setName(rs.getString("name"));
				board.setPasswd(rs.getString("passwd"));
				board.setContent(rs.getString("content"));
				board.setIp(rs.getString("ip"));
				board.setReg_date(rs.getDate("reg_date"));
			}
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(rs, pstmt, conn);
		}
		
		return board;
	}
	
	//글 수정 (제목,이름,내용)
	public void update(BoardVO boardVO)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계 : 커넥션풀로부터 커넥션 할당
			conn = getConnection();
			//SQL문 작성 : 변경 가능한 내용 title,name,content,ip
			sql = "UPDATE mboard SET title=?,name=?,content=?,ip=? WHERE num=?";
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터바인딩
			pstmt.setString(1, boardVO.getTitle());
			pstmt.setString(2, boardVO.getName());
			pstmt.setString(3, boardVO.getContent());
			pstmt.setString(4, boardVO.getIp());
			pstmt.setInt(5, boardVO.getNum());
			//JDBC 수행 4단계 : SQL문 실행
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null,pstmt,conn);
		}
	}
	
	//글 삭제
	public void delete(int num)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계 : 커넥션풀로부터 커넥션을 할당
			conn = getConnection();
			//SQL문 작성
			sql = "DELETE FROM mboard WHERE num=?";
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터바인딩
			pstmt.setInt(1, num);
			//SQL문 실행
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, getConnection());
		}
	}
}
