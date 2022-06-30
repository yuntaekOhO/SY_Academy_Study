package kr.s05.date;

import java.util.Calendar;
public class CalendarMain01 {

	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		System.out.println(today);
		
		int year = today.get(Calendar.YEAR);//연도
		int month = today.get(Calendar.MONTH)+1;//월 0~11이라 +1 해줘야함
		int date = today.get(Calendar.DATE);//일
		System.out.printf("%d년%d월%d일 ",year, month, date);
		
		int day = today.get(Calendar.DAY_OF_WEEK);//요일 숫자로 반환(1~7)

		String nday = "";
		switch(day) {
		case 1: nday = "일";break;
		case 2: nday = "월";break;
		case 3: nday = "화";break;
		case 4: nday = "수";break;
		case 5: nday = "목";break;
		case 6: nday = "금";break;
		case 7: nday = "토";break;
		}
		System.out.print(nday + "요일 ");
		
		int amPm = today.get(Calendar.AM_PM);//오전0, 오후1
		int hour = today.get(Calendar.HOUR);//12시 표기법,  24시 표기법은 HOUR_OF_DAY
		int min = today.get(Calendar.MINUTE);//분
		int sec = today.get(Calendar.SECOND);//초
		
		String str = amPm == Calendar.AM ? "오전" : "오후";
		System.out.printf("%s %d시%d분%d초",str,hour,min,sec);
		
	}

}
