package kr.s04.reader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BufferedReaderMain02 {
	public static void main(String[] args) {
		BufferedReader br = null;
		String line = "";
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			
			do {
				System.out.print("문장을 입력하세요.마치시려면 q를 입력하세요:");
				line = br.readLine();
				System.out.println("입력하신 문장 : " + line);
			}while(!line.equalsIgnoreCase("q"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//자원정리
			if(br!=null)try {br.close();}catch(IOException e) {}
		}
	}
}
