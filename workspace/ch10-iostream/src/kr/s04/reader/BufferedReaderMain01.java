package kr.s04.reader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BufferedReaderMain01 {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			//(System.in)바이트스트림->(InputStreamReader)문자스트림으로 변환
			//->(BufferedReader)문자스트림으로 데이터를 입력 받음
			br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("당신의 이름:");
			String name = br.readLine();
			System.out.println(name);
			
			System.out.print("당신의 나이:");
			          //String -> int 변환
			int age = Integer.parseInt(br.readLine());
			System.out.println(age);			
		}catch(IOException e) {
			e.printStackTrace();
		}catch(NumberFormatException e) {
			//e.printStackTrace();
			System.out.println("숫자만 입력 가능!!");
		}finally {
			//자원정리
			if(br!=null)try {br.close();}catch(IOException e) {}
		}
	}
}




