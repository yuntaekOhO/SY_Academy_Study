package kr.s01.list;

import java.util.ArrayList;

public class ArrayListMain05 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);// int -> Integer
		list.add(2);
		list.add(3);
		list.add(40);
		
		System.out.println(list);
		
		for(int i=0;i<list.size();i++) {
			System.out.println(i + " : " + list.get(i));
		}
		System.out.println("--------------");
		//list.remove(2); 2번 인덱스
		
		//remove메서드에 요소를 전달해서 삭제
		//Integer s = 1; 요소
		//list.remove(s);
		
		list.remove((Integer)40);//요소
		
		for(int i=0;i<list.size();i++) {
			System.out.println(i + " : " + list.get(i));
		}
		System.out.println("--------------");
		
		//요소의 변경
			//인덱스,데이터
		list.set(1, 80);
		for(int i=0;i<list.size();i++) {
			System.out.println(i + " : " + list.get(i));
		}
		System.out.println("--------------");
		
	}

}
