package kr.s05.writer;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterMain {
	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			//파일 경로를 지정해서 FileWriter 객체 생성
			//문자 출력 스트림
			fw = new FileWriter("fileWriter.txt");
			
			//String message = "안녕하세요 FileWriter 테스트\n하하하";
			String message = "안녕하세요 FileWriter 테스트" 
			                  + System.getProperty("line.separator")
			                  +"하하하";
			
			fw.write(message);//버퍼 출력
			fw.flush();//버퍼의 데이터를 파일로 전송하고 버퍼 비움
			
			System.out.println("파일을 생성하고 내용을 기술");
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//자원정리
			if(fw!=null)try {fw.close();}catch(IOException e) {}
		}
	}
}
