package kr.s09.finaltest;

//클래스에 final 명시하면 상속이 되지 않음
final class Me1{
	public void play() {
		System.out.println("부모클래스의 play");
	}
}
public class FinalMain03{
//public class FinalMain03 extends Me1{

	public static void main(String[] args) {
		FinalMain03 fm = new FinalMain03();
		//fm.play();
		
				
	}

}
