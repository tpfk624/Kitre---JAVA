package com.kitri.io;

import java.io.*;

public class ReaderTest {

	public static void main(String[] args) {
		Reader in = null;
		try {
			in = new InputStreamReader(System.in);//시스템이 가지고있는걸 가지고옴
			char c[] = new char[100];
			System.out.print("입력 : ");
			int x = in.read(c);
			System.out.println("x == " + x); //원칙적으로 엔터는 \n\r이어서 1234를 치면 6이 나옴
			
			int len = c.length;
			for (int i = 0; i < len; i++) {
				System.out.println(c[i]);
			}
			
			String str = new String(c, 0, x-2); //빈공간안생기게 (0, x-2)를 준다
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
