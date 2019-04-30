package com.kitri.io.my;

import java.io.IOException;

public class StdInOutTest {
	
	public static void main(String[] args) {
		try {
			System.out.println("ют╥б2 : ");
			byte b[] = new byte[100];
			int x = System.in.read(b);
			System.out.println("2 x == " + x);
			int len = b.length;
			for (int i = 0; i < len; i++) {
				System.out.println(b[i]);
			}
			String s = new String(b, 0, x-2);
			System.out.println("s == " + s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
