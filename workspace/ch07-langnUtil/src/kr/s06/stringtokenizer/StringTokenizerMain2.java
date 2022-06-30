package kr.s06.stringtokenizer;

import java.util.StringTokenizer;

public class StringTokenizerMain2 {

	public static void main(String[] args) {
		String source = "2022-04-29 12:34:40";
												//문자열,여러개의 구분자
		StringTokenizer st = new StringTokenizer(source,"- :");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

}
