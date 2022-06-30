package kr.s05.map;

import java.util.Hashtable;
import java.util.Enumeration;

public class HashtableMain {

	public static void main(String[] args) {
		Hashtable<String,String> h = new Hashtable<String,String>();
		h.put("name", "홍길동");
		h.put("age", "27");
		h.put("tel", "010-1234-5678");
		h.put("hobby","음악감상");
		h.put("job", "경찰");
		//key가 중복되면 마지막에 입력한 값으로 value가 대체됨
		h.put("name", "홍길순");
		
		//value에 null 불인정, 실행시 예외 발생
		//h.put("address", null);
		//key에 null 불인정, 실행시 예외 발생
		//h.put(null, "서울고");
		
		//Hashtable에 저장된 key, value 목록
		System.out.println(h);
		
		String name = h.get("name");
		System.out.println("이름은 " + name);
		System.out.println("------------------------");
		
		//Hashtable에 저장된 key,value 출력
		Enumeration<String> en = h.keys();
		while(en.hasMoreElements()) {
			String key = en.nextElement(); // key 반환
							// key     :      value
			System.out.println(key + " : " + h.get(key));
		}
		
	}

}
