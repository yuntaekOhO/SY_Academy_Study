package kr.s07.wrapper;

public class WrapperMain02 {

	public static void main(String[] args) {
		Integer i1 = 12;
		Integer i2 = 20;
		
		Integer result = i1 + i2;
		System.out.println("result = " + result);
		
		String s1 = "100";
		String s2 = "200";
		
		int result2 = Integer.parseInt(s1) + Integer.parseInt(s2);
		System.out.println("result2 = " + result2);
	}

}
