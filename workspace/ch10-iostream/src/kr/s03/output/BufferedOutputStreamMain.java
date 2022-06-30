package kr.s03.output;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamMain {
	 public static void main(String[] args) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			//파일명을 지정하고 FileOutputStream 객체 생성
			fos = new FileOutputStream("bufferOut.txt");
			//파일 정보를 BufferedOutputStream 생성할때 제공함 
			bos = new BufferedOutputStream(fos);
			
			//저장할 문자열 지정
			String str = "BufferedOutputStream Test 입니다.";
			        //문자열 -> byte[] 변환
			bos.write(str.getBytes());//출력 버퍼에 데이터 저장
			bos.flush();//플러시하지 않으면 버퍼에 담겨있는 데이터를 파일에     
                        //저장하지 못 함
                        //플러시하면 버퍼에 담겨있는 데이터를 파일에 전송하고
                        //버퍼를 비움
			
			System.out.println("파일을 생성하고 파일에 내용을 명시했습니다.");
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//자원정리
			/*
			 * BufferedOutputStream의 close()메서드는 자원정릴하기 전에
			 * buffer를 체크해서 남아있는 데이터가 있으면 파일로 전송하고 버퍼를 비움
			 */
			if(bos!=null)try {bos.close();}catch(IOException e) {}
			if(fos!=null)try {fos.close();}catch(IOException e) {}
		}
		
	}
}


