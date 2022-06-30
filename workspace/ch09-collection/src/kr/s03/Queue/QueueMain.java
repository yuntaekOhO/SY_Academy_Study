package kr.s03.Queue;

import java.util.LinkedList;

public class QueueMain {

	public static void main(String[] args) {
		//Queue : 선입선출 FIFO (First-in First-out)의 자료구조
		String[] array = {"서울","대구","부산","광주","인천"};
		
		LinkedList<String> k = new LinkedList<String>();
		
		//반복문 이용 LinkedList에 객체 저장
		for(int i=0;i<array.length;i++) {
			k.offer(array[i]);//객체 저장
		}
		//LinkedList 목록 출력
		System.out.println(k);
		
		while(k.peek() != null) { //LinkedList에 저장된 첫번째 요소를 검색
			System.out.print(k.poll() + "\t"); // 첫번쨰 요소를 반환하고 제거
		}
		System.out.println();
		System.out.println(k);
	}

}
