package com.kitri.lang;

import java.io.UnsupportedEncodingException;

public class StringTest4 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		//getBytes() : ����Ʈ �迭�� �ɰ���
		String str = "abcdef";
		byte b[] = str.getBytes();
		int len = b.length;
		for (int i = 0; i < len; i++) {
			System.out.println("b[" + i + "] == " + b[i]);
		}
		System.out.println("------------------------");
		
		
		String str2 = "�ȳ��ϼ���";
		//byte b2[] = str2.getBytes(); //default�� ������ ����(���缳�� - euc-kr)
		byte b2[] = str2.getBytes("utf-8"); //utf-8�� �ٲٸ� ���ڵ� ���Ѵ� 
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
