public class ForMain05 {

	public static void main(String[] args) {
		//구구단 2~9단까지 출력
		for(int dan=2;dan<10;dan++) {
			System.out.println("**" + dan + "단**");
			for(int i=1;i<10;i++) {
				System.out.println(dan + " * " + i + " = " + dan*i);
			}
		}
	}

}
