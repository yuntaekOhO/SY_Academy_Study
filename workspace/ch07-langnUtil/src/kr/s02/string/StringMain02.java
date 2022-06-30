package kr.s02.string;

public class StringMain02 {
	//[이건 외워라!!]
	public static void main(String[] args) {
		String s1 = "Kwon Sun Ae";
			// index=012345678910, 문자열의 길이 =11
		
		//indexOf : 문자 또는 문자열의 index 반환
		int index = s1.indexOf('n');
		System.out.println("맨 처음 문자 n의 위치 : " + index);
		
		index = s1.indexOf("Sun");
		//문자열의 첫번째 위치 반환
		System.out.println("문자열 Sun의 위치 : " + index);
		
		//charAt : 인덱스를 이용해서 문자를 추출
		char c = s1.charAt(index);
		System.out.println("추출한 문자 : " + c);
		
		index = s1.indexOf('S');
		//substring : 인덱스를 지정하면 지정한 인덱스부터 마지막 인덱스까지 문자열 추출
		String str = s1.substring(index);
		System.out.println("대문자 S부터 끝까지 문자열 추출 : " + str);
		
		//substring(int, int) : 시작 인덱스부터 끝 인덱스전까지 문자열 추출
		str = s1.substring(index, index+3);
		System.out.println("대문자 S부터 3자까지 문자열 추출 : " + str);
		
		//문자열의 길이
		int length = s1.length();
		System.out.println("s1의 길이 : " + length);
		
		//구분자(공백)를 이용해서 문자열을 잘라내기
		//" " : 공백, 공백을 기준으로 저장
		//"" : 빈 문자열, 한 글자씩 저장
		String[] array = s1.split(" ");
		for(int i=0;i<array.length;i++) {
			System.out.println("array[" + i + "]:" + array[i]);
		}
	}

}
