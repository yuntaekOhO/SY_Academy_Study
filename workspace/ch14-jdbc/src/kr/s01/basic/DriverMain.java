package kr.s01.basic;

public class DriverMain {

	public static void main(String[] args) {
		//드라이버 연동 테스트
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버가 정상적으로 설치되었습니다.");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
