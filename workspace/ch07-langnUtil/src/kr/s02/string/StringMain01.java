package kr.s02.string;

public class StringMain01 {

	public static void main(String[] args) {
		// 암시적으로 문자열 생성 : 객체를 공유함
		String str1 = "abc";
		String str2 = "abc";

		// 객체 비교 String은 equals(), toString()이 재정의 되어있다
		// 그렇기 때문에 객체 비교할때 == 사용
		if (str1 == str2) {
			System.out.println("str1과 str2는 같은 객체");
		} else {
			System.out.println("str1과 str2는 다른 객체");
		}

		// 문자열(객체의 내용) 비교
		if (str1.equals(str2)) {
			System.out.println("str1과 str2의 내용(문자열)이 같다");
		} else {
			System.out.println("str1과 str2의 내용(문자열)이 다르다");
		}

		System.out.println("--------------------------------");

		// 명시적으로 문자열 생성
		String str3 = new String("Hello");
		String str4 = new String("Hello");

		if (str3 == str4) {
			System.out.println("str3과 str4는 같은 객체");
		} else {
			System.out.println("str3과 str4는 다른 객체");
		}

		// 문자열(객체의 내용) 비교
		if (str3.equals(str4)) {
			System.out.println("str3과 str4의 내용(문자열)이 같다");
		} else {
			System.out.println("str3과 str4의 내용(문자열)이 다르다");
		}
		System.out.println("--------------------------------");
		
		String str5 = "bus";
		String str6 = "BUS";
		
		//대소문자를 구분한다
		if(str5.equals(str6)) {
			System.out.println("str5와 str6의 문자열이 같다");
		}else {
			System.out.println("str5와 str6의 문자열이 다르다");
		}
		
		//equalsIgnoreCase() : 대소문자를 구분하지 않고 문자열 비교
		if(str5.equalsIgnoreCase(str6)) {
			System.out.println("[대소문자를 구분없이 비교]str5와 str6의 문자열이 같다");
		}else {
			System.out.println("[대소문자를 구분없이 비교]str5와 str6의 문자열이 다르다");
		}
	}

}
