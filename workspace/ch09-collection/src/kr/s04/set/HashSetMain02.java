package kr.s04.set;

import java.util.HashSet;
import java.util.Collections;
import java.util.ArrayList;

public class HashSetMain02 {

	public static void main(String[] args) {
		/*
		 * [실습] 로또프로그램 작성
		 * 1~45 6개
		 * (int)(Math.random()*45)+1  , 1~45
		 * size()<6
		 */
		HashSet<Integer> hs = new HashSet<Integer>();
		
		while(hs.size()<6) {
			hs.add((int)(Math.random()*45)+1);
		}
		
		//HashSet -> Set -> Collection 
		ArrayList<Integer> list = new ArrayList<Integer>(hs);
		Collections.sort(list);
		
		for(Integer num : list) {
			System.out.print(num + "\t");
		}
		
	}

}
