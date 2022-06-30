package kr.s06.stringtokenizer;

import java.util.StringTokenizer;

public class StringTokenizerMain01 {

	public static void main(String[] args) {
		//쉼표를 구분자로 하는 문자열 생성
		String source = "100,200,300,400";
												//문자열,구분자
		StringTokenizer st = new StringTokenizer(source,",");
		while(st.hasMoreTokens()) {//구분자를 이용해서 잘라낸 문자열이 있는지 검증
			System.out.println(st.nextToken());//구분자를 이용해서 잘라낸 문자열 반환
		}
			
	}

}
