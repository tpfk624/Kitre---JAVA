package com.kitri.lang;

import java.io.UnsupportedEncodingException;

public class StringTest4 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		//getBytes() : 바이트 배열로 쪼개기
		String str = "abcdef";
		byte b[] = str.getBytes();
		int len = b.length;
		for (int i = 0; i < len; i++) {
			System.out.println("b[" + i + "] == " + b[i]);
		}
		System.out.println("------------------------");
		
		
		String str2 = "안녕하세요";
		//byte b2[] = str2.getBytes(); //default는 설정에 따라서(현재설정 - euc-kr)
		byte b2[] = str2.getBytes("utf-8"); //utf-8로 바꾸면 숫자도 변한다 
		int len2 = b.length;
		for (int i = 0; i < len2; i++) {
			System.out.println("b2[" + i + "] == " + b2[i]);
		}
		
		//toCharArray()
		char c[] = str2.toCharArray();
		len = c.length;
		for (int i = 0; i < len; i++) {
			System.out.println("c[" + i + "] == " + c[i]);
		}
	}
}
