package kr.s02.input;

import java.io.IOException;

public class StandardInputMain01 {

	public static void main(String[] args) {
		//자바 기본 입력
		System.out.print("영문자 1개 입력:");
		try {
			//문자 하나 입력받아서 아스키코드로 반환
			int a = System.in.read();
			System.out.println(a + ", " + (char)a);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
