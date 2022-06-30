package kr.s01.list;

import java.util.ArrayList;

public class ArrayListMain06 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10); // int -> Integer
		list.add(20);
		list.add(15);
		list.add(16);
		
		System.out.println(list);
		System.out.println("------------------");
		
		//짝수만 삭제
		//아래와 같은 코드는 데이터를 삭제하면 인덱스 변경으로 
		//조건 체크를 하지 못하고 건너뛰는 데이터가 발생할 수 있다
		/*for(int i=0;i<list.size();i++) {
			if(list.get(i)%2==0) { //짝수인 경우
				list.remove(i);
			}
		}*/
		
		//반복문을 이용해서 조건 체크 후 데이터를 삭제할 때는
		//뒤에서부터 앞으로 이동하면서 조건 체크를 해야 조건 체크시
		//건너뛰는 데이터가 발생하지 않음
		for(int i=list.size()-1;i>=0;i--) {
			if(list.get(i)%2 == 0) { // 짝수인 경우
				list.remove(i);
			}
		}
		System.out.println(list);
		System.out.println("------------------");
	}

}
