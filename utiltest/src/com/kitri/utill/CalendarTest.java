package com.kitri.utill;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarTest {

	public static void main(String[] args) {
		//����Ŭ��������
		//Calendar cal = new GregorianCalendar();
		
		//�ڽ��� ��ü�� �����ϴ� �޼ҵ�
		Calendar cal = Calendar.getInstance();
		
		//2019�� 03�� 26�� ���� 1�� 07�� 05��
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH) + 1;
		int d = cal.get(Calendar.DATE);
		int apm = cal.get(Calendar.AM_PM);
		int h = cal.get(Calendar.HOUR);
		int mi = cal.get(Calendar.MINUTE);
		int s = cal.get(Calendar.SECOND);
		System.out.println(y  + "�� " + zeroPlus(m) + "�� " + zeroPlus(d) + "�� " + (apm == 0 ? "���� " : "���� ") 
					+ zeroPlus(h) + "�� " + zeroPlus(mi) + "�� " + zeroPlus(s) + "�� ");
		
		//Class Date
		Date date = new Date();
		System.out.println(date.toString());
		
	}
		//main�� static�̱� ������ static-static���� ȣ�Ⱑ��?
		//��, �ڱⰡ ������ �ڱⰡ �޴°�� static��밡��
		private static String zeroPlus(int num){ 
			return num < 10 ? "0" + num : "" + num;
		}		
}
