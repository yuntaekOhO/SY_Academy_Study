package kr.s01.list;

import java.util.ArrayList;

public class ArrayListMain04 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("한국");//0
		list.add("미국");//1
		list.add("중국");//2
		list.add("일본");//3
		list.add("한국");//4
		
		//ArrayList에 저장된 요소의 목록
		System.out.println(list);
		
		for(int i=0;i<list.size();i++) {
			String name = list.get(i);
			System.out.println(i + " : " + name);
		}
		System.out.println("--------------");
		
		//요소의 삭제
		//list.remove(2);//인덱스
		//중복된 요소는 동시에 삭제하지 않고 가장 앞에 있는 요소만 삭제
		list.remove("한국");//요소
		for(int i=0;i<list.size();i++) {
			String name = list.get(i);
			System.out.println(i + " : " + name);
		}
		System.out.println("--------------");
	}

}
