package kr.s07.serial;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;// <- 역직렬화하는 클래스

public class CustomerMain02 {

	public static void main(String[] args) {
		System.out.println("===객체 역직렬화하기===");
		//역직렬화 : 직렬화된 파일 정보를 읽어들여 객체를 생성
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("object.ser");//FileNotFoundException
			ois = new ObjectInputStream(fis);//IOException
			
			//역직렬화 수행
			//파일에 직렬화되어있던 정보를 읽어온다
			Customer m = (Customer)ois.readObject();//ClassNotFoundException
			System.out.println(m);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally {
			//자원정리
			if(ois!=null)try {ois.close();}catch(IOException e) {}
			if(fis!=null)try {fis.close();}catch(IOException e) {}
		}
	}

}
