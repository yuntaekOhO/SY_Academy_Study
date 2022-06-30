package kr.s01.exception;

public class ExceptionMain05 {
	public static void main(String[] args) {
		/*
		 * 멀티 catch
		 * JDk7.0이상부터 하나의 catch 블럭에서 여러 개의 예외를 처리할 수 있도록
		 * 멀티 catch 기능을 추가
		 */
		try {
			int value1 = Integer.parseInt(args[0]);
			int value2 = Integer.parseInt(args[1]);
			
			System.out.println(value1 + "+" + value2 + "=" 
			                          + (value1 + value2));
		//멀티 catch : 예외 타입을 | 로 연결	
		}catch(ArrayIndexOutOfBoundsException | NumberFormatException e){
			System.out.println("실행 매개값의 수가 부족하거나 숫자만 입력해야 합니다.");
		}catch(Exception e) {
			System.out.println("나머지 예외는 여기로~~");
		}
	}
}



