package kr.s02.string;

import java.util.Scanner;

public class StringMain06 {

	public static void main(String[] args) {
		/*
		 * [실습] 입력한 데이터에 문자가 포함되어 있는지 판별하는 프로그램
		 * [출력예시] 
		 * 데이터입력:1234 숫자입니다.
		 * 
		 * 데이터입력:1b 문자가 포함되었습니다.
		 */
		Scanner input = new Scanner(System.in);
		System.out.print("데이터 입력:");
		String str = input.nextLine();
		System.out.println(str);
		String result = "숫자입니다.";
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			//양수(+), 음수(-) 체크
			if(c==43||c==45) {
				if(i==0 && str.length()>1) {
					continue;
				}
			}
			if (c < 48 || c > 57) {// 숫자가 아닌 경우
				result = "문자가 포함되었습니다.";
				break;
			}
		}
		System.out.println(result);
		input.close();
	}

}
