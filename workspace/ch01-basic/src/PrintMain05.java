public class PrintMain05 {

	public static void main(String[] args) {
		//System.out.printf(포맷문자, 데이터)를 이용한 출력(데이터의 종류를 표시할 수 있는 포맷 문자 지원)

		//문자
		System.out.printf("%c\n", 'A');
		System.out.printf("%6c\n", 'B');//6자리 확보, 숫자가 양수이면 오른쪽에 정렬
		System.out.printf("%-6c\n", 'C');//6자리 확보, 숫자가 음수이면 왼쪽에 정렬
		
		System.out.println("================");
		
		//정수
		System.out.printf("%d%n", 67);//%n : printf()에서만 사용하는 \n의 다른 표현 방식
		System.out.printf("%,d%n", 1000);//3자리 단위로 쉼표 표시
		System.out.printf("%5d%n", 20);
		System.out.printf("%-5d%n", 30);
		
		System.out.println("================");
		
		//실수
		System.out.printf("%f%n", 35.896);//기본값은 소수점 아래 6자리 확보
		System.out.printf("%.2f%n", 35.893);//반올림해서 소수점 둘째자리까지 표현
		System.out.printf("%10.2f%n", 35.896);//소수점을 포함하여 10자리 확보
		
		System.out.println("================");
		
		//문자열
		System.out.printf("%s%n", "우주");
		
		System.out.println("================");
		
		//논리값
		System.out.printf("%b%n", true);
		
		System.out.printf("%s는 %d입니다.", "점수", 98);
	}

}
