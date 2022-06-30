package kr.s01.exception;

public class ExceptionMain08 {
	
	public void methodA(String[] n)throws Exception{
		if(n.length>0) {
			//확장for문을 이용한 데이터 출력
			for(String str : n) {
				System.out.println(str);
			}
		}else {//length == 0
			throw new Exception("배열에 요소가 없습니다.");
		}
	}
	
	public static void main(String[] args) {
		ExceptionMain08 ex = new ExceptionMain08();
		try {
			ex.methodA(args);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}





