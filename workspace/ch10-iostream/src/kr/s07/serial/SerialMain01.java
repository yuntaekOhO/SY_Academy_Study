package kr.s07.serial;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class SerialMain01 {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		//직렬화할 객체 생성
		UserInfo u1 = new UserInfo("홍길동",20,"서울시");
		UserInfo u2 = new UserInfo("박문수",18,"부산시");
		ArrayList<UserInfo> list = new ArrayList<UserInfo>();
		
		list.add(u1);
		list.add(u2);
		
		try {
			fos = new FileOutputStream("userInfo.ser");
			oos = new ObjectOutputStream(fos);
			//객체 직렬화
			oos.writeObject(list);
			System.out.println("직렬화가 성공적으로 완료되었습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}finally{
			if(oos!=null)try {oos.close();}catch(IOException e) {}
			if(fos!=null)try {fos.close();}catch(IOException e) {}
		}
	}

}
