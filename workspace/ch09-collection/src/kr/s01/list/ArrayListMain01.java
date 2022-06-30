package kr.s01.list;

import java.util.ArrayList;

class A{
	//Object의 toString 재정의
	@Override
	public String toString() {
		return "A";
	}
}
class B{}

public class ArrayListMain01 {
	public static void main(String[] args) {
		
		Integer i = 100;//Integer 객체 생성
		
		ArrayList list = new ArrayList();
		//객체 저장
		list.add(new A());//A -> Object
		list.add(new B());//B -> Object
		list.add("손흥민");//String -> Object
		list.add(i);//Integer -> Object
		
		//ArrayList에 저장된 요소의 목록
		System.out.println(list);
	}
}





