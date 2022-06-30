package kr.s01.list;

import java.util.ArrayList;

public class ArrayListMain03 {

	/*
	 * 제네릭 표현 : 객체를 생성할 때 객체에 저장할 수 있는 요소의 타입을 지정,
	 * 				타입을 지정하면 다른 타입의 요소는 저장할 수 없음
	 */
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("서울"); // String
		list.add("부산"); // String
		list.add("광주"); // String
		//list.add(1000); // int -> Integer
		list.add("제주"); // String 
		
		//반복문을 이용한 요소 출력
		for(int i=0;i<list.size();i++) {
			String name = list.get(i);//String
			System.out.println(name);
		}
		System.out.println("-----------------------");
		
		//확장 for문을 이용한 요소 출력
		for(String name : list) {
			System.out.println(name);
		}
		
	}

}
