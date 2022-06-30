public class VariableTypeMain02 {

	public static void main(String[] args) {
		//확장 특수 출력 문자 (escape sequence)
		char single = '\'';
		System.out.println(single);
		
		String str = "오늘은 \"금요일\"입니다.";
		System.out.println(str);
		
		//문자열에 '를 표시하면 자동으로 일반 문자로 변환됨
		String str2 = "오늘은 '서울'에 비가 와요!!";
		System.out.println(str2);
		
		//실제 경로는 C:\javaWork
		String str3 = "C:\\javaWork";
		System.out.println(str3);
		
		String str4 = "오늘은 금요일\n내일은 토요일";
		System.out.println(str4);
		
		String str5 = "이름\t나이\t취미";
		System.out.println(str5);
	}

}
