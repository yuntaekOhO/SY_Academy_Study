package kr.s01.list;

import java.util.ArrayList;

public class ArrayListMain02 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		list.add("강호동");
		list.add("유재석");
		list.add("김준호");
		list.add("김구라");
		
		//ArrayList 저장된 요소의 목록 출력
		System.out.println(list);
		 
		 for(int i=0;i<list.size();i++){
			 String name = (String)list.get(i);
			 System.out.println(name);
		 }
			 
	}

}
