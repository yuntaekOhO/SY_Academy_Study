package kr.s04.math;

import java.util.Scanner;

public class MathMain03 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 가위바위보게임
		 * 0:가위, 1:바위, 2:보
		 * 
		 * 난수 발생은 Math.random() 활용
		 * 
		 * [출력 예시]
		 * 메뉴>1.게임하기 | 2.종료하기
		 * 메뉴>1
		 * 가위바위보 입력(0:가위,1:바위,2:보):1
		 * 
		 * 무승부 -> 컴퓨터 : 바위, 사람 : 바위
		 * 사람 승 -> 컴퓨터 : 가위, 사람 : 바위
		 * 컴퓨터 승 -> 컴퓨터 : 보, 사람 : 바위
		 * 메일 : pinos71@daum.net
		 */
		
		String[] item = {"가위","바위","보"};
		
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("----------------------");
			System.out.println("메뉴>1.게임하기 | 2.종료하기");
			System.out.println("-----------------------");
			System.out.print("메뉴>");
			int num = input.nextInt();
			
			if(num == 1) {
				System.out.print("가위바위보 입력(0:가위,1:바위,2:보):");
				int user = input.nextInt();
				
				if(user<0 || user>2) {
					System.out.println("잘못 입력했습니다.");
					continue;
				}
				
				int computer = (int)(Math.random()*3);
				
				//조건을 단순화하기 위한 연산
				/*
				 * 컴퓨터   사용자   결과
				 *  0   -   0      0    무
				 *  0   -   1     -1    사용자 승    
				 *  0   -   2     -2    컴퓨터 승
				 *  ----------------------------
				 *  1   -   0      1    컴 승
				 *  1   -   1      0    무
				 *  1   -   2     -1    사 승
				 *  ----------------------------
				 *  2   -   0      2    사 승
				 *  2   -   1      1    컴 승
				 *  2   -   2      0    무
				 *  결과가 0이면 무
				 *  결과가 -1, 2이면 사용자 승
				 *  결과가 -2, 1이면 컴퓨터 승
				 */
				int result = computer - user;
				if(result == 0) {
					System.out.print("무승부");
				} else if(result==-1 || result==2) {
					System.out.print("사람 승");
				} else if(result==-2 || result==1) {
					System.out.print("컴퓨터 승");
				}
				System.out.println(" -> 컴퓨터:"+item[computer]+", 사람:"+item[user]);
				
			}else if(num == 2) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else {
				System.out.println("잘못 입력했습니다.");
			}
		}
		
		input.close();
	}
}
