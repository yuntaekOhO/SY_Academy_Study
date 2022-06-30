package kr.s07.serial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream; // <- 직렬화하는 클래스

public class CustomerMain01 {

	public static void main(String[] args) {
		System.out.println("===객체 직렬화하기===");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		//직렬화할 객체 생성
		Customer c = new Customer("홍길동");
		
		try {
			fos = new FileOutputStream("object.ser");
			oos = new ObjectOutputStream(fos);
			//객체 직렬화 수행
			oos.writeObject(c);
			
			System.out.println("객체 직렬화가 완료되었습니다.");
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//자원정리
			if(oos!=null)try {oos.close();}catch(IOException e) {}
			if(fos!=null)try {fos.close();}catch(IOException e) {}
		}
	}

}
