public class OperatorMain01 {

	public static void main(String[] args) {
		System.out.println("====증감연산자====");
		//증가연산자
		int i = 5;
		//변수 앞에 ++, 증가시키고 출력함
		System.out.println(++i);
		//변수 뒤에 ++, 출력하고 증가함 즉, 출력된 값은 증가하기 전의 값
		System.out.println(i++);
		//증가된 값을 보기위해선 새로 불러와야함
		System.out.println(i);
		
		System.out.println("----------------");
		
		//감소연산자
		int j = 10;
		//변수 앞에 --, 감소시키고 출력함
		System.out.println(--j);
		//변수 뒤에 --, 출력하고 감소함 즉, 출력된 값은 감소하기 전의 값
		System.out.println(j--);
		//감소된 값을 보기위해선 새로 불러와야함
		System.out.println(j);
	}

}
