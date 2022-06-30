package kr.s05.map;

import java.util.HashMap;

public class HashMapMain01 {

	public static void main(String[] args) {
		/*
		 * Map 구조 : key와 value 쌍으로 저장
		 */
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("김신", 95);
		map.put("지은탁", 100);
		map.put("저승사자", 85);
		map.put("써니", 93);
		map.put("유덕화", 70);
		//key가 중복되면 마지막에 입력 값으로 값이 대체  
		//map.put("지은탁", 0);
		
		//value에 null 인정
		map.put("강호동", null);
		//key에 null 인정
		map.put(null, 100);
		
		//HashMap에 저장된 key와 value 목록
		System.out.println(map);
		System.out.println("-------------------------------------------");
		
		//key를 이용해서 value 구하기
		Integer num = map.get("지은탁");
		System.out.println("지은탁의 성적은 " + num);
		
	}

}
