package kr.s04.math;

import java.util.Random;

public class MathMain02 {
	public static void main(String[] args) {
		String[] gift = {"스마트폰","TV","냉장고","꽝!"};
		               //    0      1    2     3 
		
		double ran = Math.random();//0~1.0미만의 난수를 double형 데이터로 반환
		System.out.println("발생한 난수 : " + ran);
		int index = (int)(ran*4);
		System.out.println("발생한 난수 : " + index);
		System.out.println("오늘의 선물 : " + gift[index]);
		
		System.out.println("--------------------------");
		
		String[] luck = {"귀인을 만남","달콤한 프로포즈","로또당첨","피곤해~"};
		                //    0           1           2       3
		
		Random r1 = new Random();
		
		index = r1.nextInt(4);//0부터 인자로 전달된 값의 전까지의 범위로 난수 발생
		                      //0~3
		System.out.println("발생한 난수 : " + index);
		System.out.println("오늘의 운세 : " + luck[index]);
		
	}
}
