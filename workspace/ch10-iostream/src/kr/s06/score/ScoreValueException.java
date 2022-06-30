package kr.s06.score;

//성적 범위가 0~100사이가 아니면 발생, 사용자 정의 예외 클래스
public class ScoreValueException extends Exception{
	public ScoreValueException(String message) {
		super(message);
	}
}
