package kr.s03.output;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamMain {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			//덮어쓰기
			//생성할 파일을 지정하고 FileOutputStream 객체 생성
			fos = new FileOutputStream("fileout.txt");
			
			//이어쓰기                      파일명,이어쓰기 여부(true->이어쓰기)
			//fos = new FileOutputStream("fileout.txt",true);
			
			//파일에 저장할 문자열
			String message = "Hello File! 파일에 내용을 명시합니다.";
			
			         //String -> byte[] 변환
			fos.write(message.getBytes());
			
			System.out.println("파일을 생성하고 내용을 명시했습니다.");
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//자원정리
			if(fos!=null)try {fos.close();}catch(IOException e) {}
		}
	}
}


