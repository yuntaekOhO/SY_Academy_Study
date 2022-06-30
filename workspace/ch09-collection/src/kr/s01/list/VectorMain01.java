package kr.s01.list;

import java.util.Vector;

public class VectorMain01 {

	public static void main(String[] args) {
		Vector<Double> v = new Vector<Double>();
		//요소 추가
		v.add(100.3);
		v.add(3.14);
		v.add(1000.); // = 1000.0
		
		//Vector에 저장된 요소 목록
		System.out.println(v);
		
		//확장 for문 이용한 요소 출력
		for(Double n : v) {
			System.out.println(n);
		}
		
		//요소 검색
		double search = 1000.0;// 검색할 요소
		int index = v.indexOf(search); // 검색 , 요소가 없으면 -1 return
		if(index != -1) {
			System.out.println("검색 요소 " + search + "의 위치 : " + index);
		} else {
			System.out.println("검색 요소 " + search + "가 없습니다.");
		}
		
		//요소 삭제
		double del = 3.14; // 삭제할 요소
		if(v.contains(del)) {
			v.remove(del); // 삭제
			System.out.println(del + " 삭제 완료");
		}
		System.out.println(v);
		
	}

}
