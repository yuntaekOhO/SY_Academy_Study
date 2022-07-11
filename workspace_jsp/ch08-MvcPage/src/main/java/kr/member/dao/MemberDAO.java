package kr.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.member.vo.MemberVO;
import kr.util.DBUtil;

public class MemberDAO {
	//싱글턴 패턴
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	private MemberDAO() {}
	
	//회원가입
	public void insertMember(MemberVO member)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		String sql = null;
		int num = 0; //시퀀스 번호 저장용
		
		try {
			//JDBC 수행 1,2단계 : 커넥션풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			//오토커밋 해제 : sql문(동작)이 여러개인 경우 커밋을 수동으로 해야함
			conn.setAutoCommit(false);
			
			//SQL문 작성, 시퀀스 구하기
			//회원번호(mem_num) 생성 : 두 테이블(zmember, zmember_detail)에 insert할 때 
			//각각 시퀀스하면 서로 다른 값이 들어가기 때문에 먼저 시퀀스값을 구한다
			sql = "SELECT zmember_seq.nextval FROM dual";
			
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			//JDBC 수행 4단계 : SQL 실행 후 결과행을 rs에 담음
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1);
			}
			
			//zmember에 데이터 저장
			sql = "INSERT INTO zmember (mem_num,id) VALUES (?,?)";
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt2 = conn.prepareStatement(sql);
			//?에 데이터바인딩
			pstmt2.setInt(1, num);
			pstmt2.setString(2, member.getId());
			//JDBC 수행 4단계 : SQL문 실행
			pstmt2.executeUpdate();
			
			
			//zmember_detail에 데이터 저장
			sql = "INSERT INTO zmember_detail (mem_num,name,passwd,phone,email,zipcode,address1,address2) "
					+ "VALUES (?,?,?,?,?,?,?,?)";
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt3 = conn.prepareStatement(sql);
			//?에 데이터바인딩
			pstmt3.setInt(1, num);
			pstmt3.setString(2, member.getName());
			pstmt3.setString(3, member.getPasswd());
			pstmt3.setString(4, member.getPhone());
			pstmt3.setString(5, member.getEmail());
			pstmt3.setString(6, member.getZipcode());
			pstmt3.setString(7, member.getAddress1());
			pstmt3.setString(8, member.getAddress2());
			
			//JDBC 수행 4단계 : SQL 실행
			pstmt3.executeUpdate();
			
			//SQL 실행시 모두 성공하면 커밋
			conn.commit();
			
		}catch(Exception e) {
			//SQL문이 하나라도 실패하면 롤백
			conn.rollback();
			throw new Exception(e);
		}finally {
			DBUtil.executeClose(null,pstmt3,null);
			DBUtil.executeClose(null,pstmt2,null);
			DBUtil.executeClose(rs,pstmt,conn);
		}
	}
	//아이디 중복체크 및 로그인 처리
	
	//회원상세 정보
	
	//회원정보 수정
	
	//비밀번호 수정
	
	//프로필사진 수정
	
	//회원탈퇴(회원정보 삭제)
	
	//-------관리자---------
	//전체글 개수(검색글 개수)
	
	//목록(검색글 목록)
	
	//회원정보 수정
	
}
