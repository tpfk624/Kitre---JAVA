package com.kitri.io;

import java.io.*;

public class ReaderTest {

	public static void main(String[] args) {
		Reader in = null;
		try {
			in = new InputStreamReader(System.in);//�ý����� �������ִ°� �������
			char c[] = new char[100];
			System.out.print("�Է� : ");
			int x = in.read(c);
			System.out.println("x == " + x); //��Ģ������ ���ʹ� \n\r�̾ 1234�� ġ�� 6�� ����
			
			int len = c.length;
			for (int i = 0; i < len; i++) {
				System.out.println(c[i]);
			}
			
			String str = new String(c, 0, x-2); //������Ȼ���� (0, x-2)�� �ش�
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
