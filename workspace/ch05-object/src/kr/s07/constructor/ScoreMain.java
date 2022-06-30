package kr.s07.constructor;

import java.util.Scanner;

class Score{
	/*
	 * [실습]
	 * 멤버변수: private 이름(name),국어(korean),영어(english),수학(math)
	 * 멤버메서드: 총점(makeSum()), 평균(makeAverage()), 등급(makeGrade())
	 * 			getName,setName ...
	 * 
	 *  main -
	 *  Scanner 객체 생성
	 *  Score 객체 생성
	 *  이름, 국어, 수학, 영어 입력 받음
	 *  이름, 국어, 수학, 영어, 총점, 평균, 등급 출력
	 */
	private String name;
	private int korean, english, math;
	
	public int makeSum() {
		return korean + math + english;
	}
	public double makeAverage() {
		return makeSum() / 3.0;
	}
	public String makeGrade() {
		String grade = "";
		switch((int)makeAverage()/10) {
		case 10:
		case 9:grade = "A"; break;
		case 8: grade = "B"; break;
		case 7: grade = "C"; break;
		case 6: grade = "D"; break;
		default: grade = "F";
		}
		return grade;
	}
	
	//성적 정보 출력하기
	public void printScore() {
		System.out.println("이름 : "+ name);
		System.out.printf("국어 : %d%n", korean);
		System.out.printf("수학 : %d%n", math);
		System.out.printf("영어 : %d%n", english);
		System.out.printf("총점 : %d%n", makeSum());
		System.out.printf("평균 : %.2f%n", makeAverage());
		System.out.println("등급 : "+ makeGrade());
	}
	
	public String getName() {
		return name;
	}
	public void setName(String n) {
		name = n;
	}
	public int getKorean() {
		return korean;
	}
	public void setKorean(int k) {
		korean = k;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int e) {
		english = e;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int m) {
		math = m;
	}
}
public class ScoreMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Score score = new Score();
		
		System.out.print("이름 입력>");
		score.setName(input.next());

		do {
		System.out.print("국어 점수>");
		score.setKorean(input.nextInt());
		} while(score.getKorean()<0 || score.getKorean()>100);
		
		do {
		System.out.print("수학 점수>");
		score.setMath(input.nextInt());
		} while(score.getMath()<0 || score.getMath()>100);
		
		do {
		System.out.print("영어 점수>");
		score.setEnglish(input.nextInt());
		}while(score.getEnglish()<0 || score.getEnglish()>100);
		
		score.printScore();
		
		input.close();
	}

}
