package com.kitri.utill;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarTest {

	public static void main(String[] args) {
		//하위클래스참조
		//Calendar cal = new GregorianCalendar();
		
		//자신의 객체를 리턴하는 메소드
		Calendar cal = Calendar.getInstance();
		
		//2019년 03월 26일 오후 1시 07분 05초
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH) + 1;
		int d = cal.get(Calendar.DATE);
		int apm = cal.get(Calendar.AM_PM);
		int h = cal.get(Calendar.HOUR);
		int mi = cal.get(Calendar.MINUTE);
		int s = cal.get(Calendar.SECOND);
		System.out.println(y  + "년 " + zeroPlus(m) + "월 " + zeroPlus(d) + "일 " + (apm == 0 ? "오전 " : "오후 ") 
					+ zeroPlus(h) + "시 " + zeroPlus(mi) + "분 " + zeroPlus(s) + "초 ");
		
		//Class Date
		Date date = new Date();
		System.out.println(date.toString());
		
	}
		//main이 static이기 때문에 static-static끼리 호출가능?
		//단, 자기가 보내서 자기가 받는경우 static사용가능
		private static String zeroPlus(int num){ 
			return num < 10 ? "0" + num : "" + num;
		}		
}
