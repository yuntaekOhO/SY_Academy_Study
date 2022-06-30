public class ArrayMain03 {

	public static void main(String[] args) {
		//배열의 선언, 생성(암시적 배열 생성), 초기화
		int[] array = {10,20,30,40,50};
		
		//반복문을 이용한 배열의 요소 출력
					 // 배열의 길이
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i] + "\t");
		}
		
		System.out.println("-----------------");
		//배열의 요소 변경
		//같은 자료형의 데이터로 요소를 변경해야 함
		array[4] = 100;
		
	}

}
