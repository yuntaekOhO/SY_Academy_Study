package kr.s05.date;

import java.util.Scanner;
import java.util.Calendar;

public class CalendarMain02 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//현재 날짜와 시간을 구함
		Calendar cal = Calendar.getInstance();
		System.out.println("희망 연도와 월을 입력하세요(ex 연도:2022,월:4)");
		System.out.print("연도:");
		int year = input.nextInt();
		System.out.print("월:");
		int month = input.nextInt();
		
		System.out.println("   [ " + year +"년 "+ month +"월 ]");
		System.out.println("======================================");
		System.out.println("  일  월  화  수  목  금  토");
		
		//희망 연도,월,일 세팅(월의 범위는 0~11이기 때문에 입력 월 -1)		
		cal.set(year, month-1, 1);
		
		//달력은 1일부터 시작하기 때문에 1일의 요일을 구함
		int week  = cal.get(Calendar.DAY_OF_WEEK);//일(1) ~ 토(7)
		//마지막 날짜 구하기
		int lastOfDate = cal.getActualMaximum(Calendar.DATE);
		//1일전에 공백 만들기
		for(int i=1;i<week;i++) {
			System.out.printf("%3s", " ");
		}
		
		//1일부터 말일까지 반복하면서 숫자를 출력
		for(int i=1;i<=lastOfDate;i++) {
			System.out.printf("%3d", i);
			if(week%7==0) System.out.println();
			week++;
		}
		System.out.println("\n======================================");
		
		input.close();
	}

}
