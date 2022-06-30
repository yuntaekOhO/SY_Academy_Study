package kr.s02.string;

public class StringMain05 {
	public static void main(String[] args) {
		String str = "abcMDye-4W?EWzz";
		String result = "";
		/*
		 * [실습]
		 * 위 문자열에서 소문자->대문자, 대문자->소문자 변경해서 출력
		 * [출력 예시]
		 * ABCmdYE-4w?ewZZ
		 */
		
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if(c>=65 && c<=90) {//대문자
				          //문자 -> 문자열
				result += String.valueOf(c).toLowerCase();
			}else if(c>=97 && c<=122) {//소문자
				result += String.valueOf(c).toUpperCase();
			}else {
				result += c;
			}
		}
		//출력
		System.out.println(result);
		
		System.out.println("------------------------");
		
		String result2 = "";
		             //문자열 -> 문자형 배열
		for(char c : str.toCharArray()) {
			if(Character.isUpperCase(c)) {//대문자
				           //대문자 -> 소문자 변환
				result2 += Character.toLowerCase(c);
			}else if(Character.isLowerCase(c)) {//소문자
				           //소문자 -> 대문자 변환
				result2 += Character.toUpperCase(c);
			}else {
				result2 += c;
			}
		}
		
		System.out.println(result2);
		
		
		
	}
}






