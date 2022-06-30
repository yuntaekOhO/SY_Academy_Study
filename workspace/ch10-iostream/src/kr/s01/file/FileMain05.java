package kr.s01.file;

import java.io.File;

public class FileMain05 {

	public static void main(String[] args) {
		//절대경로 지정
		String path = "C:\\javaWork\\javaSample";
		
		File f1 = new File(path);
		
		System.out.println("===디렉터리 생성===");
		//mkdir(): 디렉터리 생성 가능하면 true 반환 , 불가능하면 false 반환
		System.out.println(f1.mkdir());
		
	}

}
