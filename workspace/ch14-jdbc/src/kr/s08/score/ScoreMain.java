package kr.s08.score;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ScoreMain {

	private BufferedReader br;
	private ScoreDAO dao;
	
	public ScoreMain() {
		dao = new ScoreDAO();
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
	
	//menu
	public void callMenu() throws IOException{
		while(true) {
			System.out.print("1.입력,2.목록,3.상세정보,4.수정,5.삭제,6.종료>");
			try {
				int no = Integer.parseInt(br.readLine());
				if(no==1) {//입력
					//이름
					System.out.print("이름:");
					String name = br.readLine();
					//국어
					int korean = parseInputData("국어:");
					//영어
					int english = parseInputData("영어:");
					//수학
					int math = parseInputData("수학:");
					//총점
					int sum = makeSum(korean,english,math);
					//평균
					int avg = makeAvg(sum);
					//등급
					String grade = makeGrade(avg);
					//테이블에 데이터 입력
					dao.insertInfo(name, korean, english, math, sum, avg, grade);
					
				}else if(no==2) {//목록
					dao.selectInfo();
				}else if(no==3) {//상세
					dao.selectInfo();
					System.out.print("조회할 번호:");
					int num = Integer.parseInt(br.readLine());
					dao.selectDetailInfo(num);
				}else if(no==4) {//수정
					dao.selectInfo();
					System.out.print("수정할 번호:");
					int num = Integer.parseInt(br.readLine());
					
					System.out.print("이름:");
					String name = br.readLine();
					//국어
					int korean = parseInputData("국어:");
					//영어
					int english = parseInputData("영어:");
					//수학
					int math = parseInputData("수학:");
					//총점
					int sum = makeSum(korean,english,math);
					//평균
					int avg = makeAvg(sum);
					//등급
					String grade = makeGrade(avg);
					//테이블에 데이터 수정
					dao.updateInfo(num, name, korean, english, math, sum, avg, grade);
					
				}else if(no==5) {//삭제
					dao.selectInfo();

					System.out.print("삭제할 번호:");
					int num = Integer.parseInt(br.readLine());
					dao.deleteInfo(num);
					
				}else if(no==6) {//종료
					System.out.println("프로그램 종료");
					break;
				}else {
					System.out.println("잘못 입력했습니다.");
					
				}
			}catch(NumberFormatException e) {
				System.out.println("숫자만 입력 가능");
			}
		}
	}
	//총점구하기
	public int makeSum(int korean, int english, int math) {
		return korean + english + math;
	}
	//평균구하기
	public int makeAvg(int sum) {
		return sum/3;
	}
	//등급구하기
	public String makeGrade(int avg) {
		String grade;
		switch(avg/10) {
		case 10:
		case 9: grade = "A"; break;
		case 8: grade = "B"; break;
		case 7: grade = "C"; break;
		case 6: grade = "D"; break;
		default : grade = "F";
		}
		return grade;
	}
	//성적 범위 체크(0~100)
	public int parseInputData(String course)throws IOException{
		while(true) {
			System.out.print(course);
			try {
				int num = Integer.parseInt(br.readLine());
				
				if(num<0||num>100) {
					throw new ScoreValueException("0~100사이의 값만 인정!");
				}
				return num;
			}catch(NumberFormatException e) {
				System.out.println("숫자만 입력하세요");
			}catch(ScoreValueException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void main(String[] args) {
		new ScoreMain();
	}

}
