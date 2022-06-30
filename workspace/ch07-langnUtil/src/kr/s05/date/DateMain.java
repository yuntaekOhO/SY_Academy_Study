package kr.s05.date;

import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
public class DateMain {

	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		//deprecated 되어 사용하지 않음
		System.out.println(now.toLocaleString());
		System.out.println("------------------------------------");
		
		DateFormat df = DateFormat.getInstance();
		String today = df.format(now);
		System.out.println(today);
		System.out.println("------------------------------------");
		
		df = DateFormat.getDateTimeInstance();
		today = df.format(now);
		System.out.println(today);
		System.out.println("------------------------------------");
		
		df = DateFormat.getDateInstance();
		today = df.format(now);
		System.out.println(today);
		System.out.println("------------------------------------");
		
		df = DateFormat.getTimeInstance();
		today = df.format(now);
		System.out.println(today);
		System.out.println("------------------------------------");
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy년MM월dd일 (E) HH:mm:ss");
		today = sf.format(now);
		System.out.println(today);
		
	}

}
