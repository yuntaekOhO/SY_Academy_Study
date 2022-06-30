package kr.s01.exception;

public class ExceptionMain02 {
	public static void main(String[] args) {
		int[] array = {10,20,30};
		//예외를 발생시키기 위해 인덱스 3 호출
		for(int i=0;i<=array.length;i++) {
			//예외처리
			//예외가 발생해도 정상 종료될 수 있도록 프로그램적으로 처리하는 것을 말함
			try {
				//예외가 발생할 가능성이 있는 코드를 명시
				//만약 예외가 발생하면 예외가 발생한 코드의 실행을 멈추고 catch
				//블럭으로 이동
				System.out.println("array["+i+"]:" + array[i]);
			       //예외 발생시 생성되는 예외 객체의 타입
			}catch(ArrayIndexOutOfBoundsException e) {
				//예외가 발생하면 catch블럭으로 이동해서 예외가 발생한 이유를
				//출력하거나 대체코드를 실행
				System.out.println("없는 인덱스 호출");
			}
		}//end of for
		System.out.println("프로그램 끝!!");
	}
}





