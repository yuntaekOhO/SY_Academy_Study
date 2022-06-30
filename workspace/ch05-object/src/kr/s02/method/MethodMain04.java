package kr.s02.method;
public class MethodMain04 {
	/*
	 * [실습]
	 * 배열 a가 가진 모든 요소의 합을 구하는 sumOf() 메서드를 작성하시오
	 * 메서드명: sumOf() -> public int sumOf(int[] a)
	 */
	//메서드 정의
	public int sumOf(int[] a) {
		int sum = 0;
		for(int i=0;i<a.length;i++) {
			sum += a[i];
		}
		return sum;
	}
	//main 메서드
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.print("요소 수:");
		int num = input.nextInt();
		//배열 선언 및 생성
		int[] x = new int[num];//num개의 요소를 가지는 배열
		
		//반복문을 이용해서 배열에 저장할 데이터를 입력 받음
		for(int i=0;i<num;i++) {
			System.out.print("x["+i+"]:");
			x[i] = input.nextInt();
		}
		
		//객체 선언 및 생성
		MethodMain04 me = new MethodMain04();
		
		int sum = me.sumOf(x);
		System.out.println("입력한 수의 합은: "+ sum);
		
		
		input.close();
	}

}
