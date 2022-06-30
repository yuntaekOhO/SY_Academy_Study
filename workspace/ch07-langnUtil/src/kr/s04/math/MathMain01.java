package kr.s04.math;

public class MathMain01 {
	public static void main(String[] args) {
		int a = Math.abs(-10);//절대값
		System.out.println("절대값 : " + a);
		
		double b = Math.ceil(3.3);//올림
		System.out.println("올림 : " + b);
		
		double c = Math.floor(3.7);//절삭
		System.out.println("절삭 : " + c);
		
		int d = Math.round(3.7f);
		System.out.println("반올림 : " + d);
		
		int e = Math.max(3,5);
		System.out.println("최대값 : " + e);
		
		int f = Math.min(4, 7);
		System.out.println("최소값 : " + f);
		
	}
}
