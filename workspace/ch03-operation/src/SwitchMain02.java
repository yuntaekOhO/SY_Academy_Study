public class SwitchMain02 {
	public static void main(String[] args) {
		char ch = 'B';
		
		switch(ch) { //char -> int
		case 'A':
			System.out.println("A 출력");
			break;
		case 'B':
			System.out.println("B 출력");
			break;
		case 'C':
			System.out.println("C 출력"); break;
		default:
			System.out.println("A,B,C가 아닌 문자 출력");
		}
	}
}
