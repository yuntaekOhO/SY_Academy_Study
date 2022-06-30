public class ArrayMain06 {

	public static void main(String[] args) {
		//배열의 선언 및 생성, 초기화
		int[] array = {10,20,30,40,50};
		
		//반복문을 이용해서 배열의 요소를 출력
		for(int i=0;i<array.length;i++) {
			System.out.println("array["+i+"]:"+array[i]);
		}
		
		//개선된 루프(확장 for문)
		for(int num : array) {
			System.out.println(num);
		}
		
	}

}
