package kr.s02.string;

public class StringMain03 {
	public static void main(String[] args) {
		String s1 = "  aBa  ";
		String s2 = "abc";
		int a = 100;
		String msg = null;
		
		//소문자를 대문자로 변경
		msg = s1.toUpperCase();
		System.out.println("msg:" + msg);
		
		//대문자를 소문자 변경
		msg = s1.toLowerCase();
		System.out.println("msg:" + msg);
		
		//특정 문자를 원하는 문자를 변경
		msg = s1.replace("aB","b");
		System.out.println("msg:" + msg);
		
		//앞뒤 공백 제거
		msg = s1.trim();
		System.out.println("msg:" + msg);
		
		//문자열에서 특정 문자열이 포함되어 있는지 여부 확인
		boolean f = s1.contains("aB");
		System.out.println("f:" + f);
		System.out.println("--------------------");
		
		//문자열이 특정 문자열로 시작하는지 여부 확인
		f = s2.startsWith("ab");
		System.out.println(f);
		
		//문자열이 특정 문자열로 끝나는지 여부 확인
		f = s2.endsWith("bc");
		System.out.println(f);
		System.out.println("--------------------");
		
		//int -> String
		msg = String.valueOf(a); //100 -> "100"
		msg = a + "";//""는 빈문자열, 100 -> "100"
		
		
	}
}



