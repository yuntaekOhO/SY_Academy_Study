package kr.s01.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ArrayListMain08 {

	public static void main(String[] args) {
		/*
		 * [실습] 로또 프로그램 작성 
		 * 1~45의 중복되지 않는 6개의 숫자 nextInt(45)+1 --> 1~45 
		 * ArrayList
		 * contains(생성한 난수) -> 중복값 체크 size()<6 정렬
		 */
		Random ran = new Random();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		while (list.size() < 6) {
			//난수 발생 1~45
			int num = ran.nextInt(45) + 1;
			//중복 체크
			if (!list.contains(num)) {
				list.add(num);
			}
			
		}
		//정렬
		Collections.sort(list);
		//출력
		System.out.println(list);

	}

}
