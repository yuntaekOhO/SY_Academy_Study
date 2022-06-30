package kr.s05.overloading;

public class OverloadingMain02 {

	//메서드 오버로딩(중복 정의)
	//인자로 값이 전달되면 값을 모두 String으로 변환해서 문자열의 길이를 구하는 메서드
	
	public void getLength(int n) {
		String s = String.valueOf(n);//int -> String 변환
//		System.out.println(s+ "의 길이 : "+s.length()); 반복되는 부분 변경
		getLength(s);
	}
	
	public void getLength(float n) {
		String s = String.valueOf(n);//float -> String 변환
//		System.out.println(s+ "의 길이 : "+s.length());
		getLength(s);
	}
	
	public void getLength(String s) {
		System.out.println(s+ "의 길이 : "+s.length());
	}
	
	public static void main(String[] args) {
		OverloadingMain02 ov = new OverloadingMain02();
		ov.getLength(1000);//1000 -> "1000"
		ov.getLength(3.14f);//3.14 -> "3.14"
		ov.getLength("Hello");
	}

}
