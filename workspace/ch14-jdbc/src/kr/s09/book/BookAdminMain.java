package kr.s09.book;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BookAdminMain {

	private BufferedReader br;
	private BookDAO dao;
	
	public BookAdminMain() {
		dao = new BookDAO();
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			callMenu();
		}catch(IOException e){
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(br!=null)try {br.close();}catch(IOException e) {}
		}
	}
	
	//menu
	public void callMenu() throws IOException{
		
		while (true) {
			// 1.도서등록,2.도서목록,3.대출목록,4.회원목록,5.종료
			System.out.print("1.도서등록,2.도서목록,3.대출목록,4.회원목록,5.종료>");
			try {
				int no = Integer.parseInt(br.readLine());

				if (no == 1) {// 도서등록
					System.out.print("책 이름:");
					String bk_name = br.readLine();
					System.out.print("카테고리:");
					String bk_category = br.readLine();
					
					dao.insertBook(bk_name, bk_category);
				} else if (no == 2) {// 도서목록
					dao.selectListBook();
				} else if (no == 3) {// 대출목록
					dao.selectListReservation();
				} else if (no == 4) {// 회원목록
					dao.selectListMember();
				} else if (no == 5) {// 종료
					System.out.println("프로그램을 종료합니다.");
					break;
				} else {// 오입력
					System.out.println("메뉴에 있는 번호를 선택하세요.");
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력하세요.");
			}
		}
	}
	public static void main(String[] args) {
		new BookAdminMain();
	}

}
