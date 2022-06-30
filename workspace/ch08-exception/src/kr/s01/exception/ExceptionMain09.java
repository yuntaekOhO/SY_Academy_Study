package kr.s01.exception;

import java.util.Scanner;

//사용자 정의 예외클래스
class NegativeNumberException extends Exception{
	//생성자 정의                        예외 문구
	public NegativeNumberException(String str) {
		super(str);
	}
}

public class ExceptionMain09 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("0이상만 입력:");
		try {
			int a = input.nextInt();
			if(a >= 0) {
				System.out.println("입력한 숫자:" + a);
			}else {
				//사용자가 정의한 예외를 인위적으로 발생시킴
				throw new NegativeNumberException("음수를 사용할 수 없습니다.");
			}
		}catch(NegativeNumberException e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println("예외 발생");
		}finally {
			if(input != null) input.close();
		}
	}
}







