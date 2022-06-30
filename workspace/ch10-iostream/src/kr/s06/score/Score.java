package kr.s06.score;

public class Score {
	/*
	 * [실습]
	 * 멤버변수 : private 이름(name), 국어(korean), 영어(english), 수학(math)
	 * 멤버메서드 : public 이름,국어,영어,수학 getter,setter
	 *  		int 총점구하기(makeSum), double 평균구하기(makeAvg),
	 *  		String 등급구하기(makeGrade)
	 */
	private String name;
	private int korean;
	private int english;
	private int math;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int makeSum() {
		return korean + english + math;
	}
	public double makeAvg() {
		return makeSum() / 3.0;
	}
	public String makeGrade() {
		String result = "";
		
		switch((int)makeAvg() / 10) {
		case 10:
		case 9: result = "A"; break;
		case 8: result = "B"; break;
		case 7: result = "C"; break;
		case 6: result = "D"; break;
		default: result = "F";
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		return String.format("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n", 
			name, korean, english, math, makeSum(), makeAvg(), makeGrade());
	}
	
}
