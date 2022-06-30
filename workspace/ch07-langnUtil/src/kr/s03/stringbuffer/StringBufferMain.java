package kr.s03.stringbuffer;

public class StringBufferMain {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("여름 덥다!!");
		System.out.println("1:" + sb);
		
		//문자를 지정한 인덱스 삽입
		sb.insert(2, '이');
		System.out.println("2:" + sb);
		
		//문자열 뒤에 지정한 문자열을 연결(저장)
		sb.append("가을은 ");
		System.out.println("3:" + sb);
		
		sb.append("시원하다");
		System.out.println("4:" + sb);
		
		//지정한 인덱스 범위(시작 인덱스부터 끝 인덱스전까지)의 문자열을 지정한 문자열로 대체
		sb.replace(0,3, "여행가자!!");
		System.out.println("5:" + sb);
		
		//인덱스를 지정해서 문자 삭제
		sb.deleteCharAt(0);
		System.out.println("6:" + sb);
		
		//시작 인덱스부터 끝 인덱스전까지의 문자열 삭제
		sb.delete(0, 3);
		System.out.println("7:" + sb);
		             //StringBuffer-> String
		String str = sb.toString();
		System.out.println("str:" + str);
		
	}
}






