package kr.s10.array;

public class BookMain {

	public static void main(String[] args) {
		//배열 선언 및 생성
		Book[] bookArray = new Book[3];
		int total = 0;
		
		//Book 객체를 3개 생성하여 배열에 저장
		//배열에 저장되는건 만들어진 객체의 주소
		bookArray[0] = new Book("IT", "Java", 50000, 0.05);
		bookArray[1] = new Book("IT", "JSP", 40000, 0.03);
		bookArray[2] = new Book("미술", "반 고흐", 60000, 0.06);
		
		//반복문을 이용한 배열의 요소를 출력
		for(int i=0;i<bookArray.length;i++) {
			System.out.print(bookArray[i].getCategory()+"\t");
			System.out.print(bookArray[i].getName()+"\t");
			System.out.printf("%,d원\t",bookArray[i].getPrice());
			System.out.printf("%.2f\n",bookArray[i].getDiscount());
			//합계
			total += bookArray[i].getPrice();
		}
		//합계 출력
		System.out.printf("책 가격의 합: %,d%n", total);
		System.out.println("-------------------------------");
		
		//확장for문을 사용한 배열의 요소 출력
		for(Book book : bookArray) {
			System.out.print(book.getCategory()+"\t");
			System.out.print(book.getName()+"\t");
			System.out.printf("%,d원\t",book.getPrice());
			System.out.printf("%.2f\n",book.getDiscount());
			
		}
	}

}
