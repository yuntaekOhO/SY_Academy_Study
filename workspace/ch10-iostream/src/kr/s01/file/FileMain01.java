package kr.s01.file;

import java.io.File;

public class FileMain01 {

	public static void main(String[] args) {
		String path = "C:\\";
		
		File f = new File(path);
		
		//exists(): 파일 또는 디렉터리의 존재 여부 체크
		//isDirectory(): 디렉터리이면 true
		if(!f.exists() || !f.isDirectory()) {
			System.out.println("유효하지 않는 디렉터리입니다.");
			System.exit(0);// 프로그램 종료
		}
		//listFiles(): 지정한 경로의 하위 경로와 파일 정보를 File[]로 반환
		File[] files = f.listFiles();
		for(int i=0;i<files.length;i++) {
			File f2 = files[i];
			if(f2.isDirectory()) {// 디렉터리
				System.out.println("["+ f2.getName() + "]");
			} else {// 파일
				System.out.print(f2.getName());
				System.out.printf("(%,dbytes)%n", f2.length());
			}
		}
		
	}

}
