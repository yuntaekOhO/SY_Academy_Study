public class ForMain02 {

	public static void main(String[] args) {
		for(int i=5;i>=1;i--) {
			System.out.print(i + "\t");
		}
		System.out.println("\n--------------------------");
		
		for(int i=0;i<=10;i+=2) { // i가 2씩 증가
			System.out.print(i + "\t");
		}
		System.out.println("\n--------------------------");
		
		for(int i=0;i<=10;i++) { // i가 1씩 증가하지만 조건문으로 출력 선별
			if(i%2==0) {// 짝수
				System.out.print(i + "\t");
			}
		}
	}

}
