package kr.s09.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.s03.preparedstatement.DBUtil;

public class BookDAO {

	//도서 등록
	public void insertBook(String bk_name, String bk_category) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			//JDBC step 1,2
			conn = DBUtil.getConnection();
			//sql
			sql = "INSERT INTO book (bk_num,bk_name,bk_category) VALUES (book_seq.nextval,?,?)";
			//JDBC step 3
			pstmt = conn.prepareStatement(sql);
			//? data binding
			pstmt.setString(1, bk_name);
			pstmt.setString(2, bk_category);
			//JDBC step 4
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행을 추가했습니다.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	//도서 목록 보기
	public void selectListBook() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//JDBC step 1,2
			conn = DBUtil.getConnection();
			//sql
			sql = "SELECT bk_num, bk_name, bk_category, bk_regdate, NVL(re_status,0) re_status, re_modifydate FROM book LEFT OUTER JOIN (SELECT * FROM reservation WHERE re_status=1) USING(bk_num) ORDER BY bk_num DESC";
			//JDBC step 3
			pstmt = conn.prepareStatement(sql);
			//JDBC step 4
			rs = pstmt.executeQuery();
			System.out.println("---------------------------------------------------------------");
			System.out.println("번호\t등록일\t\t카테고리\t대출여부\t도서명");
			System.out.println("---------------------------------------------------------------");
			while(rs.next()) {
				System.out.print(rs.getInt("bk_num")+"\t");
				System.out.print(rs.getDate("bk_regdate")+"\t");
				System.out.print(rs.getString("bk_category")+"\t");
				if(rs.getInt("re_status")==0) {
					System.out.print("대출가능"+"\t");
				}else {
					System.out.print("대출중"+"\t");
				}
				System.out.println(rs.getString("bk_name"));

			}
			System.out.println("---------------------------------------------------------------");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	
	
	
	//아이디 중복 체크
	public int checkId(String me_id) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			//JDBC step 1,2
			conn = DBUtil.getConnection();
			//sql
			sql = "SELECT me_id FROM member WHERE me_id=?";
			//JDBC step 3
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, me_id);
			//JDBC step 4
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//검색한 id가 존재하면 중복임 count = 1
				System.out.println("이미 있는 아이디입니다.");
				count = 1;
			}else {
				//검색한 id가 미존재하면 count = 0
				System.out.println("사용 가능한 아이디입니다.");
				count = 0;
			}
		
		
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
		
		return count;
	}
	
	//회원가입
	public void insertMember(String me_id, String me_passwd, String me_name, String me_phone) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC step 1,2
			conn = DBUtil.getConnection();
			//sql
			sql = "INSERT INTO member (me_num,me_id,me_passwd,me_name,me_phone) VALUES (member_seq.nextval,?,?,?,?)";
			//JDBC step 3
			pstmt = conn.prepareStatement(sql);
			//? data binding
			pstmt.setString(1, me_id);
			pstmt.setString(2, me_passwd);
			pstmt.setString(3, me_name);
			pstmt.setString(4, me_phone);
			//JDBC step 4 : execute~
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행을 추가했습니다.");
			System.out.println("회원가입 완료!!");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	//로그인 체크 me_num 반환
	public int loginCheck(String me_id, String me_passwd) {
		int me_num = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			//jdbc step 1,2
			conn = DBUtil.getConnection();
			//sql
			sql = "SELECT me_num FROM member WHERE me_id=? AND me_passwd=?";
			//jdbc step 3
			pstmt = conn.prepareStatement(sql);
			//? data binding
			pstmt.setString(1, me_id);
			pstmt.setString(2, me_passwd);
			//jdbc step 4
			rs = pstmt.executeQuery();
			if(rs.next()) {
				me_num = rs.getInt(1);
			}else {
				me_num = 0;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		
		return me_num;
	}
	//회원 목록 보기
	public void selectListMember() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//JDBC step 1,2
			conn = DBUtil.getConnection();
			//sql
			sql = "SELECT * FROM member ORDER BY me_num desc";
			//JDBC step 3
			pstmt = conn.prepareStatement(sql);
			//JDBC step 4
			rs = pstmt.executeQuery();
			System.out.println("-----------------------------------------------------------");
			System.out.println("번호\t아이디\t패스워드\t이름\t휴대폰\t\t등록일");
			System.out.println("-----------------------------------------------------------");
			while(rs.next()) {
				System.out.print(rs.getInt("me_num")+"\t");
				System.out.print(rs.getString("me_id")+"\t");
				System.out.print(rs.getString("me_passwd")+"\t");
				System.out.print(rs.getString("me_name")+"\t");
				System.out.print(rs.getString("me_phone")+"\t");
				System.out.print(rs.getDate("me_regdate")+"\n");
			}
			System.out.println("-----------------------------------------------------------");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	//대출 여부 확인
	public int getStatusReservation(int bk_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;
		//대출 행이 있으면 count=1

		try {
			conn = DBUtil.getConnection();
			sql = "select re_status from book left outer join (select * from reservation where re_status=1) using(bk_num) where bk_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bk_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}else {// 행이 없음!(bk_num이 없음, 잘못 입력함)
				count = -1;
			}
			//count가 1이면 대출 중, 0이면 대출 가능, -1이면 도서번호 잘못 됨
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		return count;
	}
	//대출 등록
	public void insertReservation(int bk_num, int me_num) {
		//re_num <- reservation_seq.nextval,
		//re_status <- 대출하면 1, 반납하면 0
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			sql = "insert into reservation (re_num,re_status,bk_num,me_num) values (reservation_seq.nextval,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			pstmt.setInt(2,bk_num);
			pstmt.setInt(3, me_num);
			int count = pstmt.executeUpdate();
			System.out.println(count+ "개의 책이 대출 완료되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	//대출 목록 보기
	public void selectListReservation() {
		//내림차순
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT re_num, me_id, me_name, bk_category, bk_name, re_status, re_regdate, re_modifydate FROM reservation JOIN book USING(bk_num) JOIN member USING(me_num) ORDER BY re_num DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("-----------------------------------------------------------");
			System.out.println("대출번호\t아이디\t대출인\t카테고리\t책이름\t\t대출여부\t대출일\t반납일");
			System.out.println("-----------------------------------------------------------");
			while(rs.next()) {
				System.out.print(rs.getInt("re_num")+"\t");
				System.out.print(rs.getString("me_id")+"\t");
				System.out.print(rs.getString("me_name")+"\t");
				System.out.print(rs.getString("bk_category")+"\t");
				System.out.print(rs.getString("bk_name")+"\t");
				if(rs.getInt("re_status")==1) {
					System.out.print("대출중\t");
				}else {
					System.out.print("반납\t");
				}
				System.out.print(rs.getDate("re_regdate")+"\t");
				if (rs.getDate("re_modifydate") == null) {
					System.out.println("");
				} else {
					System.out.println(rs.getDate("re_modifydate"));
				}

			}
			System.out.println("-----------------------------------------------------------");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	//My 대출 목록 보기 (일반 사용자)
	public void selectMyList(int me_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT re_num,me_id,bk_category,re_status,bk_name FROM reservation JOIN book USING(bk_num) JOIN member USING(me_num) WHERE me_num=? AND re_status=1 ORDER BY re_num DESC";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, me_num);
			rs = pstmt.executeQuery();
			System.out.println("-----------------------------------------------------------");
			
			if(rs.next()) { //행 있음
				System.out.println("대출번호\t분류\t대출여부\t책이름");
				System.out.println("-----------------------------------------------------------");
				do {
					System.out.print(rs.getInt("re_num")+"\t");
					System.out.print(rs.getString("bk_category")+"\t");
					System.out.print("대출중"+"\t");
					System.out.println(rs.getString("bk_name"));
				}while(rs.next());
			} else { //행이 없음
				System.out.println("대출한 도서가 없습니다.");
			}
			System.out.println("-----------------------------------------------------------");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}

	// 반납 가능 여부
	public int getStatusBack(int re_num, int me_num) {
		int count = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//jdbc step 1,2
			conn = DBUtil.getConnection();
			//sql
			// 대출번호(re_num)와 회원번호(me_num)을 통해서 re_status(대출여부)를 구해서 반환
			sql = "select re_status from reservation where re_num=? and me_num=?";
			//jdbc step 3
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, re_num);
			pstmt.setInt(2, me_num);
			//jdbc step 4
			rs = pstmt.executeQuery();
			// re_status가 1이면 반납가능, 0이면 반납 불가
			if(rs.next()) {
				count = rs.getInt(1);
			}else {
				// 행이 없으면 count = -1
				count = -1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return count;
	}

	// 반납 처리
	public void updateReservation(int re_num) {
		// re_status=0, re_modifydate=sysdate
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//jdbc step 1,2
			conn = DBUtil.getConnection();
			//sql
			sql = "update reservation set re_status=0, re_modifydate=sysdate where re_num=?";
			//jdbc 3
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, re_num);
			//jdbc 4
			int count = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
}
