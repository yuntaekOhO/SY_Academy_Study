package kr.s08.statictest;

public class StaticCount {
	//인스턴스 변수
	int c;
	//static(클래스) 변수
	static int count;
	
	//생성자
	public StaticCount() {
		c++;
		//StaticCount.count++;  <-표기 원칙
		count++;
	}
	
}
