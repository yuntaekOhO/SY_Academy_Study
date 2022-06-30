package kr.s02.stack;

import java.util.Stack;

public class StackMain {

	public static void main(String[] args) {
		//Stack : 후입선출 LIFO(Last-in First-out) 방식
		String[] array = {"진달래","백합","개나리","벚꽃","장미"};
		
		Stack<String> st = new Stack<String>();
		
		//반복문 이용 Stack에 데이터 저장
		for(int i=0;i<array.length;i++) {
			st.push(array[i]);
		}
		
		//Stack에 저장된 요소 목록
		System.out.println(st);
		System.out.println("---------------");
		
		while(!st.isEmpty()) {
			//스택의 가장 위에 있는 객체를 스택에서 삭제하고 해당 객체를 반환
			System.out.println(st.pop() + "\t");
		}
		System.out.println(st);
	}

}
