package kr.s02.input;

import java.io.IOException;

public class StandardInputMain02 {
	public static void main(String[] args) {
		int input = 0;
		try {
			//명시적으로 -1을 만들려면 ctrl + z
			while((input=System.in.read())!=-1) {
				System.out.println("input : " + input 
						       + ", (char)input : " + (char)input);
			}
			System.out.println("프로그램 종료!!");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
