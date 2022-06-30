package kr.s04.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderMain03 {
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		String msg = "";
		try {
			//file.txt를 지정해서 FileReader 객체 생성
			fr = new FileReader("file.txt");
			//파일 정보를 BufferedReader 객체를 생성해서 전달함.
			br = new BufferedReader(fr);
			while((msg = br.readLine())!=null) {
				System.out.println(msg);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//자원정리
			if(br!=null)try {br.close();}catch(IOException e) {}
			if(fr!=null)try {fr.close();}catch(IOException e) {}
		}
	}
}





