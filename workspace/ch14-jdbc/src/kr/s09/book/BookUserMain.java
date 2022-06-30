package kr.s09.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookUserMain {
	
	private BufferedReader br;
	private BookDAO dao;
	//로그인시 회원번호 저장
	private int me_num;
	//로그인시 회원 메뉴가 노출
	private boolean flag;
	
	public BookUserMain() {
		dao = new BookDAO();
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			callMenu();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(br!=null)try {br.close();}catch(IOException e) {}
		}
	}
	
	/*
	 * menu
	 * 로그인에 성공하면
	 * 1.도서목록,2.My대출목록,3.종료 으로 바뀜
	*/
	public void callMenu() throws IOException {
		while (true) {
			// 1.로그인,2.회원가입,3.종료
			System.out.print("1.로그인,2.회원가입,3.종료>");
			try {
				int no = Integer.parseInt(br.readLine());
				if (no == 1) {// 로그인
					//로그인이 성공하면
					//me_num에 회원번호를 저장하고 flag에 true저장하고 break해서 while문 빠져나감
					System.out.print("ID:");
					String me_id = br.readLine();
					System.out.print("password:");
					String me_pw = br.readLine();
					//id,pw 검증
					me_num = dao.loginCheck(me_id, me_pw);
					if (me_num > 0) {
						System.out.println("로그인 성공!!"+ me_id+"님 환영합니다");
						flag = true;
						break;
					}
					System.out.println("아이디 또는 비밀번호가 불일치합니다.");
				} else if (no == 2) {// 회원가입
					System.out.print("id:");
					String me_id = br.readLine();
					int duplicate_check = dao.checkId(me_id);
					if(duplicate_check==0) {
						System.out.print("password:");
						String me_passwd = br.readLine();
						System.out.print("이름:");
						String me_name = br.readLine();
						System.out.print("휴대폰:");
						String me_phone = br.readLine();

						dao.insertMember(me_id, me_passwd, me_name, me_phone);
					} else {
						continue;
					}
				} else if (no == 3) {// 종료
					System.out.println("프로그램 종료");
					break;
				} else {//범위 밖 입력
					System.out.println("메뉴 번호에 맞게 입력하세요.");
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력하세요.");
			}
		}
		
		//로그인시 호출되는 메뉴
		while(flag) {
			//1.도서목록,2.My대출목록,3.종료
			System.out.print("1.도서목록(대출),2.MY대출목록(반납),3.종료:");
			try {
				int no = Integer.parseInt(br.readLine());
				if(no==1) {//도서목록(도서대출하기)
					dao.selectListBook();
					
					System.out.println("[도서대출하기]");
					//도서번호 입력
					System.out.print("도서번호(입력중지:0)>");
					int bk_num = Integer.parseInt(br.readLine());
					
					if(bk_num==0) continue;
					
					//도서 대출 여부 체크
					int status = dao.getStatusReservation(bk_num);
					
					//도서 대출 수행
					if(status==0) {
						dao.insertReservation(bk_num, me_num);
						System.out.println("대출이 완료되었습니다.");
					}else if(status==1) {
						System.out.println("이 책은 현재 대출 중 입니다.");
					}else if(status==-1) {
						System.out.println("없는 책을 입력했습니다.");
					}
				}else if(no==2) {//my대출목록
					dao.selectMyList(me_num);
					System.out.println("[도서 반납]");
					System.out.print("대출번호 입력(입력중지:0)>");
					//대출번호 입력
					int re_num = Integer.parseInt(br.readLine());
					
					if(re_num == 0) continue;
					
					//반납 가능 여부 체크
					int status = dao.getStatusBack(re_num, me_num);
					if(status==1) {
						//반납 수행
						dao.updateReservation(re_num);
						System.out.println("반납이 완료되었습니다.");
					}else if(status==0) {
						//반납 불가 - 대출 상태가 아님
						System.out.println("반납 불가 - 대출 상태가 아님");
					}else {
						//대출 번호 잘못입력 - 검색된 행 없음
						System.out.println("대출 번호 잘못입력 - 검색된 행 없음");
					}
				}else if(no==3) {//종료
					System.out.println("프로그램 종료.");
					break;
				}else {//범위 밖 입력
					System.out.println("메뉴 번호에 맞게 입력하세요.");
				}
			}catch(NumberFormatException e) {
				System.out.println("숫자만 입력하세요.");
			}
		}

	}
	public static void main(String[] args) {
		new BookUserMain();
	}

}
