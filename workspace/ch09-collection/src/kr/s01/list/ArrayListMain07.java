package kr.s01.list;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListMain07 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("머루");
		list.add("사과");
		list.add("앵두");
		list.add("자두");
		list.add("사과");
		System.out.println(list);
		
		int index1 = list.indexOf("사과");
		System.out.println("첫번째 사과 : " + index1);
		
		int index2 = list.lastIndexOf("사과");
		System.out.println("마지막 사과 : " + index2);
		
		int index3 = list.indexOf("망고");
		System.out.println("망고 : " + index3);
		System.out.println("---------------------");
		
		//정렬 (사전순)
		Collections.sort(list);
		System.out.println(list);
		System.out.println("---------------------");
		
		//역순으로 정렬
		Collections.reverse(list);
		System.out.println(list);
		System.out.println("---------------------");
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(10);
		list2.add(100);
		list2.add(15);
		list2.add(2);
		list2.add(40);
		System.out.println(list2);
		
		//정렬
		Collections.sort(list2);
		System.out.println(list2);
		System.out.println("---------------------");
		
		// 역순으로 정렬
		Collections.reverse(list2);
		System.out.println(list2);
		System.out.println("---------------------");

	}

}
