public class ForMain01 {

	public static void main(String[] args) {
		//     초기식;조건식;증감식
		for(int i=1;i<=5;i++) {
			System.out.println(i);
		}
		System.out.println("--------------------");
		
		//수행만이 한 줄일 경우 { }를 생략 가능
		for(int i=1;i<=5;i++)
			System.out.println(i);
		
		System.out.println("프로그램 끝");
	}

}
