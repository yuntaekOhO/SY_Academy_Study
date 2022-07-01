package kr.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.member.vo.MemberVO;

//싱글턴 패턴 : 하나의 객체로만 사용
public class MemberDAO {
	/*
	 * 싱글턴 패턴은 생성자를 private으로 지정해서 외부에서 호출할 수 없도록 처리하고
	 * static 메서드를 호출해서 객체가 한 번만 생성되고 
	 * 생성된 객체를 공유할 수 있도록 처리하는 방식을 의미함
	 * 생성된 객체를 외부에서 사용하려면 MemberDAO.getInstance() static 메서드를 이용한다.
	 */
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	//생성자를 내부에서 호출 : 외부에서 생성 못함
	private MemberDAO() {}
	
	//context.xml 에서 설정 정보를 읽어들여 커넥션 풀로부터 커넥션을 할당 받음
	//할당받은 커넥션은 DataSource에 저장됨
	//DataSource는 설정파일을 읽고 오라클과의 연동을 담당
	private Connection getConnection()throws Exception{
		//JDBC 수행 1,2 단계와 같음
		Context initCtx = new InitialContext();
												 //	앞은	그냥	대분류 /context 식별자
		DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/xe");
		return ds.getConnection();
	}
	
	//자원정리
	private void executeClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs!=null)try {rs.close();}catch(SQLException e) {};
		if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {};
		if(conn!=null)try {conn.close();}catch(SQLException e) {};
	}
	
	//회원가입
	public void insertMember(MemberVO member)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2 단계 : 커넥션풀로부터 커넥션을 할당
			conn = getConnection();
			
			//SQL문 작성
			sql = "INSERT INTO smember (num,id,name,passwd,email,phone,reg_date) VALUES "
					+ "(smember_seq.nextval,?,?,?,?,?,SYSDATE)";
			
			//JDBC 수행 3 단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			//?에 데이터 바인딩
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPasswd());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getPhone());
			
			//JDBC 수행 4단계 : SQL 실행
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null,pstmt,conn);
		}
	}
	
	//회원상세정보
	public MemberVO getMember(int num)throws Exception{
		MemberVO member = null;
		
		
		
		return member;
	}
	
	//아이디 중복체크, 로그인 체크
	public MemberVO checkMember(String id)throws Exception{
		MemberVO member = null;
		
		
		
		return member;
	}
	
	//회원정보 수정
	public void updateMember(MemberVO member)throws Exception{
		
	}
	
	//회원탈퇴(회원정보 삭제)
	public void deleteMember(int num)throws Exception{
		
	}
	
}
