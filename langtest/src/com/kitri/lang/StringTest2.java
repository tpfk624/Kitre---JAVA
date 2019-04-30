package com.kitri.lang;

import java.io.UnsupportedEncodingException;

public class StringTest2 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		//String str = null; //����
		String str1 = new String(); //"" ����ִ� ���ڿ��� �����
		System.out.println("���ڿ� ���� : " + str1.length());
		
		//byte b[] = {97, 98, 99, 100}; //97 = a
		byte b[] = {-66, -56, -77, -25, -57, -49, -68, -68, -65, -28, 46};//�ѱ��� byte�迭�δ� ��ƴ�
		String str2 = new String(b); //�ƽ�Ű�ڵ尪�� ���
		//String str2 = new String(b, "euc-kr"); �⺻���� euc-kr�̴�.
		System.out.println("str2 == " + str2);
		
		
		byte b2[] = {-20, -107, -120, -21, -123, -107, -19, -107, -104, -20, -124, -72, -20, -102, -108, 46};
		String str3 = new String(b2, "utf-8"); //�ƽ�Ű�ڵ尪�� ��� 
		System.out.println("str3 == " + str3);		
		
		//String(byte[] bytes, int offset, int length)
		byte b3[] = {97, 98, 99, 100, 101, 102, 103, 104};
		String str4 = new String(b3, 2, 4); //��𼭺��� ��� �̾Ƽ� ����ڴ�
		System.out.println("str4 == " + str4);
		
		//char c[] = {'a', 'b', 'c', 'd', 'e', 'f'};
		char c[] = {'��', '��', '��', '��', '��', '.'};
		String str5 = new String(c); 
		System.out.println("str5 == " + str5);

		String str6 = new String(c, 2, 4); 
		System.out.println("str6 == " + str6);
		
		
	}

}
