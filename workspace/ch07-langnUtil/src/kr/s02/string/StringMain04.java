package kr.s02.string;

import java.util.Scanner;

public class StringMain04 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 입력받은 문자열을 한 문자씩 읽어서 역순으로 출력
		 */
		Scanner input = new Scanner(System.in);
		System.out.print("문자열:");
		String s = input.nextLine();
		
		//마지막 인덱스부터 인덱스0까지 문자를 읽어서 출력
		for(int i=s.length()-1;i>=0;i--) {
			System.out.print(s.charAt(i));
		}
		input.close();
		
	}
}
