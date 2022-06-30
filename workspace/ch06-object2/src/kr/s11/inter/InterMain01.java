package kr.s11.inter;

interface A1{
	//상수
	public static final int W = 10; // 원형
	int X = 20;
	static int Y = 30;
	final int Z = 30;
}
public class InterMain01 {

	public static void main(String[] args) {
		//interface는 객체 생성이 불가능
		//A1 ap = new A1();
		
		//상수는 변경 불가능
		//A1.X = 200;
		
		System.out.println("W = " + A1.W);
		System.out.println("X = " + A1.X);
		System.out.println("Y = " + A1.Y);
		System.out.println("Z = " + A1.Z);
		
	}

}
