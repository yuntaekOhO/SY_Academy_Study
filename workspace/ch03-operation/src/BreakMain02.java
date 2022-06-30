public class BreakMain02 {

	public static void main(String[] args) {
		//다중 반복문에서 break 사용
		for(int i=0;i<3;i++) {
			for(int j=0;j<5;j++) {
				
				if(j==3) {
					/*
					 * 다중 반복문일 때 전체 반복문을 빠져나가는 것이 아니라 break가 포함되어있는
					 * 반복문만 빠져나감
					 */
					break;
				}
				
				System.out.println("i값:"+i+", j값:"+j);
			}
		}
		
		System.out.println("-------------------");
		
		//break label
		exit_for: //레이블 지정
			for(int i=0;i<3;i++) {
				for(int j=0;j<5;j++) {
					if(j==3) {
						break exit_for;
					}
					System.out.println("i값:"+i+", j값:"+j);
				}
			}
		
	}

}
