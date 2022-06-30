package kr.s01.file;

import java.io.File;

public class FileMain03 {

	public static void main(String[] args) {
		//상대경로 지정
		//원래파일명
		String path = "sample.txt";
		//새파일명
		String new_path = "example.txt";
		
		//원래파일명을 지정한 File 객체 생성
		File f1 = new File(path);

		System.out.println("===파일명 변경===");
		//새파일명을 지정한 File 객체 생성
		File f2 = new File(new_path);
		//renameTo(): 파일명을 변경할 수 있으면 파일명을 변경하고 true 반환,
		//				변경을 못하면 false 반환
		System.out.println(f1.renameTo(f2));
	}

}
