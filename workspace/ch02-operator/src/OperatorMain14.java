public class OperatorMain14 {

	public static void main(String[] args) {
		/*
		 * [실습]
		 * A전자 대리점에서는 그날 물건 판매액의 15%를 할인해 주기로 했습니다.
		 * 수량을 키보드로부터 입력받아, 지불 금액을 출력하는 프로그램을 작성하시오.
		 * (단, 출력 시에는 소수점 이하는 절삭, 즉 정수 값으로 출력)
		 * [출력 예시]
		 * 상품명 입력:냉장고
		 * 단가 입력:500000
		 * 판매 수량 입력:3
		 * 냉장고 3대의 가격:1,275,000원
		 * pinos71@daum.net
		 */
		java.util.Scanner input = new java.util.Scanner(System.in);
		String name;
		int price, quantity, sum;
		int result = 0;
		
		System.out.print("상품명 입력:");
		name = input.next();
		System.out.print("단가 입력:");
		price = input.nextInt();
		System.out.print("판매 수량 입력:");
		quantity = input.nextInt();
		
		sum = price * quantity;
		result = (int)(sum * 0.85);
		
		System.out.printf("%s %d대의 가격:%,d원", name, quantity, result);
		
		input.close();
	}

}
