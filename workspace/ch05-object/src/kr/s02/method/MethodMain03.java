package kr.s02.method;
public class MethodMain03 {
	/*
	 * [실습]
	 * 입력한 int형 정수값이 음수이면 -1을, 0이면 0을, 양수이면 1을 반환하는 메서드를 정의하시오
	 * 메서드명 : signOf -> public int signOf(int n)
	 */
	//메서드 정의
	public int signOf(int n) {
		int sign = 0;//0인 경우 if문을 수행하지 않기 때문에 그대로 0이 return 됨
		if(n>0) {//양수
			sign = 1;
		} else if(n<0) {//음수
			sign = -1;
		}
		return sign;
	}

	//main메서드
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		//정수 입력 받음
		System.out.print("숫자 입력:");
		int num = input.nextInt();
		//MethodMain03 객체 생성
		MethodMain03 me = new MethodMain03();
		//signOf 메서드를 호출해서 입력받은 정수를 전달
		int s = me.signOf(num);
		//메서드 호출 결과 반환되는 데이터 출력
		System.out.println("sign = "+ s);
		
		input.close();
	}
}
