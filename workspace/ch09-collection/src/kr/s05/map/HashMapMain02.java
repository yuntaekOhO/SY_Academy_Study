package kr.s05.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapMain02 {

	public static void main(String[] args) {
		String[] msg = {"Berlin","Paris","Seoul","New York","London"};
		
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		
		//반복문을 이용해서 key와 value 저장
		for(int i=0;i<msg.length;i++) {
			map.put(i,msg[i]);
		}
		
		//HashMap에 저장된 key와 value 목록
		System.out.println(map);
		System.out.println("-----------------------------------");
		
		//HashMap에는 value를 구하는 메서드만 있고 key를 구하는 방법은 없다. 
		//HashMap에 key가 Set으로 집합을 구성하고있다
		//그러나 Set도 직접 구할 수 없어서 Iterator를 이용해야 한다
		//Set<Integer> s = map.keySet();  key를 집합으로 구성
		//Iterator<Integer> keys = s.iterator();
		//      <간략화 - Set s가 한번만 쓰이기 때문에 생략> 
		Iterator<Integer> keys = map.keySet().iterator();
		while(keys.hasNext()) {
			Integer key = keys.next();
			System.out.println(key + ", " + map.get(key));
		}
	}

}
