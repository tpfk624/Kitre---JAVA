package com.kitri.exception.runtime;

import java.util.Random;

public class ArithmeticTest {
	
	public static void main(String[] args) {
		Random random = new Random();
		int x  = 30;	
		
		//������ �� ������ �ذ�
//		RuntimeException�� logic���� ó��		
//		try {
//			int z = x / y;
//			System.out.println(x + "/" + y + " = " + z);
//		}catch(ArithmeticException e) {
//			System.out.println(e.getMessage());//������ �ֳ������� ����
//			System.out.println("0���� ���� �� �����ϴ�");
//		}
		
		
		//1.������ �� ���� ���� ó��
		int y = random.nextInt(5);
		if(y != 0 ) {
			int z = x / y;
			System.out.println(x + "/" + y + " = " + z);
		}else {
			System.out.println("0���� ���� �� �����ϴ�");
		}
	
//		//2. 0�� ���� ���� ���� �������
//		int y = random.nextInt(4) + 1; 
//		int z = x / y;
//		System.out.println(x + "/" + y + " = " + z);
//		
		
		
	}
}
