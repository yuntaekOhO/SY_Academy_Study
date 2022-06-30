package kr.s01.exception;

public class ExceptionMain04 {
	public static void main(String[] args) {
		int var = 50;
		try {
			int data = Integer.parseInt(args[0]);
			
			System.out.println(var/data);
			
		//단일catch블럭
		}catch(Exception e) {
			//예외객체          타입
			if(e instanceof NumberFormatException) {
				System.out.println("숫자가 아닙니다.");
			}else if(e instanceof ArrayIndexOutOfBoundsException) {
				System.out.println("입력한 데이터가 없습니다.");
			}else if(e instanceof ArithmeticException) {
				System.out.println("0으로 나눌 수 없습니다.");
			}else {
				System.out.println("나머지 예외는 여기로~~");
			}
		}
	}
}




