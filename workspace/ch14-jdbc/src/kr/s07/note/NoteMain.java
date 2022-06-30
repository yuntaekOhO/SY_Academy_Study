package kr.s07.note;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class NoteMain {

	private BufferedReader br;
	private NoteDAO note;
	
	public NoteMain() {
		note = new NoteDAO();
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
	
	//메뉴
	public void callMenu()throws IOException{
		while(true) {
			System.out.print("1.글쓰기, 2.목록보기, 3.상세글보기, 4.글수정, 5.글삭제, 6.종료>");
			try {
				int no = Integer.parseInt(br.readLine());
				if(no==1) {//1.글쓰기
					System.out.print("이름:");
					String name = br.readLine();
					System.out.print("비밀번호:");
					String passwd = br.readLine();
					System.out.print("제목:");
					String subject = br.readLine();
					System.out.print("내용:");
					String content = br.readLine();
					System.out.print("이메일:");
					String email = br.readLine();
					
					//NoteDAO의 insertInfo 메서드를 호출해서
					//입력받은 데이터 전달
					note.insertInfo(name, passwd, subject, content, email);
				}else if(no==2) {//2.목록보기
					note.selectInfo();
				}else if(no==3) {//3.상세글보기
					note.selectInfo();
					System.out.println("선택한 글의 번호:");
					int num = Integer.parseInt(br.readLine());
					
					note.selectDetailInfo(num);
				}else if(no==4) {//4.글수정
					note.selectInfo();
					System.out.print("수정할 글의 번호:");
					int num = Integer.parseInt(br.readLine());
					
					System.out.print("이름:");
					String name = br.readLine();
					System.out.print("비밀번호:");
					String passwd = br.readLine();
					System.out.print("제목:");
					String subject = br.readLine();
					System.out.print("내용:");
					String content = br.readLine();
					System.out.print("이메일:");
					String email = br.readLine();
					
					note.updateInfo(num, name, passwd, subject, content, email);
					
				}else if(no==5) {//5.글삭제
					note.selectInfo();
					System.out.print("삭제할 글의 번호:");
					int del_num = Integer.parseInt(br.readLine());
					
					note.deleteInfo(del_num);
					
				}else if(no==6) {//6.종료
					System.out.println("프로그램을 종료합니다.");
					break;
				}else {
					System.out.println("잘못 입력했습니다.");
				}
			}catch(NumberFormatException e) {
				System.out.println("숫자만 입력 가능!!");
			}
		}
	}
	
	public static void main(String[] args) {
		new NoteMain();
	}

}
