package com.kitri.io;

import java.io.IOException;

public class StdInOutTest {

	public static void main(String[] args) {
		
		try {
//			System.out.print("입력 : ");
//			int x = System.in.read();
//			System.out.println("x == " + x); //맨앞문자하나만 아스키코드값으로 표시
//			System.out.println("x == " + (char)x);
			
			System.out.print("입력2 : ");
			byte b[] = new byte[100];
			int x = System.in.read(b);
			System.out.println("2 x == " + x );
			int len = b.length;
			for (int i = 0; i < len; i++) {
				System.out.println(b[i]);
			}
			String s = new String(b, 0, x -2); 
			System.out.println("s == "+ s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//x : 읽어들인 바이트수: a는 1바이트 + 문자2바이트

	}
}
