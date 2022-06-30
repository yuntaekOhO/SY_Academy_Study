package kr.s01.inetaddress;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain02 {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("도메인명 입력:");
			String url = br.readLine();
			
			//해당 도메인과 매핑되어 있는 모든 주소를 알려줌
			InetAddress[] addr = InetAddress.getAllByName(url);
			for(int i=0;i<addr.length;i++) {
				System.out.println("호스트 이름 : " + addr[i].getHostName() + 
										", IP주소 : " + addr[i].getHostAddress());
				
			}
					
			
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(br!=null)try {br.close();}catch(IOException e) {}
		}
	}

}
