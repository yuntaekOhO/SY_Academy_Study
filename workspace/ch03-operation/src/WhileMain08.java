public class WhileMain08 {

	public static void main(String[] args) {
		/*
		 * [실습]
		 * 동전을 넣고 커피를 주문하면 커피를 판매하는 자판기 프로그램
		 * 자판기는 자판기 보유 동전(1000), 커피(10), 프림(10), 설탕(10) 보유
		 * 커피를 주문할 때마다 자판기 보유 동전 -거스름돈, 커피-5, 프림-3, 설탕-1
		 * 0이 되면 판매 중단됨
		 * [출력예시]
		 * 동전을 넣으세요(커피값:400): ~
		 * (커피가 부족하면) 커피가 부족합니다.
		 * (프림이 부족하면) 프림이 부족합니다.
		 * (설탕이 부족하면) 설탕이 부족합니다.
		 * (자판기 보유 동전이 부족하면) 거스름돈이 부족합니다.
		 * (고객이 투입한 동전이 커피값보다 작으면) 투입한 동전이 부족합니다.
		 * 
		 * (부족한 부분이 없으면)
		 * 거스름돈 : ~원
		 * 맛 좋은 커피가 준비되었습니다.
		 * pinos71@daum.net
		 */
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		//커피에 들어갈 재료의 현재 보유량
		int coffee = 10;
		int cream = 10;
		int sugar = 10;
		//자판기 보유 동전
		int coin = 1000;
		//커피 가격
		int price = 400;
		//커피 한 잔에 들어갈 양
		int content_coffee = 5;
		int content_cream = 3;
		int content_sugar = 1;
		//판매금액(자판기에 투입한 돈이 누적됨)
		int amount = 0;
		
		while(true) {
			System.out.print("1:커피마시기 | 2:종료>");
			int num = input.nextInt();
			
			if(num==1) {
				System.out.print("동전을 넣으세요(커피값:"+ price +"): ");
				int insertCoin = input.nextInt();//투입 금액
				int change = insertCoin-price;
				
				//판매 불가능한 경우
				if(insertCoin < price) {
					System.out.println("투입한 동전이 부족합니다.");
				}else if(coin < change) {
					System.out.println("거스름돈이 부족합니다.");
					break;
				}else if(coffee < content_coffee) {
					System.out.println("커피가 부족합니다.");
					break;
				}else if(cream<content_cream) {
					System.out.println("크림이 부족합니다.");
					break;
				}else if(sugar<content_sugar) {
					System.out.println("설탕이 부족합니다.");
					break;
				}else {//판매 가능한 경우
					amount += insertCoin;//판매금액 누적
					coin -= change;
					coffee -= content_coffee;
					cream -= content_cream;
					sugar -= content_sugar;
					
					System.out.printf("거스름돈 : %,d원%n", change);
					System.out.println("맛 좋은 커피가 준비되었습니다.");
					
					
					System.out.println("amount: " +amount+ ", coin: " +coin);
					System.out.println("coffee: " +coffee+ ", cream: " +cream+ ", sugar: " +sugar);
					
				}
				
			}else if(num==2) {
				System.out.println("자판기 프로그램 종료");
				break;
			}else {
				System.out.println("잘못 입력했습니다.");
			}
		}
		
		input.close();
		
	}

}
