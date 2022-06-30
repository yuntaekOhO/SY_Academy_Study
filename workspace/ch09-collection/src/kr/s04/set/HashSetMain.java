package kr.s04.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Collections;

public class HashSetMain {

	public static void main(String[] args) {
		String[] array = {"Java","JSP","Java","Android"};
		
		HashSet<String> hs = new HashSet<String>();
		for(String s : array) {
			hs.add(s); // 중복값 제거
		}
		//HashSet에 저장된 요소의 목록
		System.out.println(hs);
		
		//Iterator를 이용한 요소의 출력
		Iterator<String> ir = hs.iterator();
		while(ir.hasNext()) { // 데이터가 있는지 검증 ; Iterator에 요소가 있는 동안
			System.out.println(ir.next());// 데이터 반환
		}
		System.out.println("------------------");
		
		for(String str : hs) {
			System.out.println(str);
		}
		
	}

}
