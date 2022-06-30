package kr.s01.list;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ArrayListMain10 {
	BufferedReader br;
	ArrayList<Score> mlist;

	public ArrayListMain10() {
		mlist = new ArrayList<Score>();
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			// 메뉴 호출
			callMenu();
		} catch (IOException e) {
			e.printStackTrace(); // 예외 문구 출력
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(br != null)
				try {br.close();} catch (IOException e) {}
		}
	}
	
	//메뉴 만들기
	public void callMenu() throws IOException {
		while(true) {
			System.out.println("1.성적입력, 2.성적출력, 3.종료");
			System.out.print("메뉴선택:");
			try {
				int num = Integer.parseInt(br.readLine());
				if(num==1) {// 성적입력
					inputScore();
				} else if(num==2){// 성적출력
					printScore();
				} else if(num==3) {// 종료
					System.out.println("성적관리를 종료합니다.");
					break;
				} else {
					System.out.println("잘못 입력했습니다.");
				}
					
			}catch(NumberFormatException e) {
				System.out.println("숫자만 입력하세요~");
			}
		}
	}
	
	//성적 입력
	public void inputScore() throws IOException {
		//Score 객체 생성
		Score score = new Score();
		//이름 입력
		System.out.print("이름 입력:");
		score.setName(br.readLine());
		//국어 입력
		score.setKorean(parseInputData("국어:"));
		//영어 입력
		score.setEnglish(parseInputData("영어:"));
		//수학 입력
		score.setMath(parseInputData("수학:"));
		//ArrayList에 Score 객체 저장
		mlist.add(score);
	}
	//성적 입력 조건 체크
	public int parseInputData(String course) throws IOException { 
		while(true) {
			System.out.print(course);
			try {
				int num = Integer.parseInt(br.readLine());
				
				//성적 유효 범위(0~100) 체크
				if(num<0 || num>100) {
					throw new ScoreValueException("0~100사이의 값만 인정");
				}
				
				return num;
			} catch(NumberFormatException e) {
				System.out.println("숫자만 입력하세요!");
			} catch(ScoreValueException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	//성적 출력
	public void printScore() {
		//이름 국어 영어 수학 총점 평균 등급 출력 CartItem 참고
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t등급");
		System.out.println("--------------------------------------------------------");
		
		for(Score score : mlist) {
			System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s%n",
								score.getName(),score.getKorean(),score.getEnglish(), score.getMath(),
								score.makeSum(),score.makeAvg(),score.makeGrade());
		}
	}
	
	
	public static void main(String[] args) {
		new ArrayListMain10();
	}

}
