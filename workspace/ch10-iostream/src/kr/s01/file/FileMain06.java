package kr.s01.file;

import java.io.File;

public class FileMain06 {

	public static void main(String[] args) {
		String path = "C:\\javaWork\\javaSample";
		
		File f1 = new File(path);
		
		System.out.println("===디렉터리 삭제===");
		
		if(f1.delete()) {// 삭제 후에 true 반환
			System.out.println(f1.getName() + " 디렉터리 삭제");
		} else { // 삭제 불가 false 반환
			System.out.println("디렉터리를 삭제할 수 없습니다.");
		}
	}

}
