package com.kitri.exception.runtime;

import java.util.Random;

public class ArithmeticTest {
	
	public static void main(String[] args) {
		Random random = new Random();
		int x  = 30;	
		
		//에러가 난 다음에 해결
//		RuntimeException은 logic으로 처리		
//		try {
//			int z = x / y;
//			System.out.println(x + "/" + y + " = " + z);
//		}catch(ArithmeticException e) {
//			System.out.println(e.getMessage());//에러가 왜났는지를 얻어옴
//			System.out.println("0으로 나눌 수 없습니다");
//		}
		
		
		//1.에러가 날 일이 없게 처리
		int y = random.nextInt(5);
		if(y != 0 ) {
			int z = x / y;
			System.out.println(x + "/" + y + " = " + z);
		}else {
			System.out.println("0으로 나눌 수 없습니다");
		}
	
//		//2. 0이 나올 일이 없게 만들어줌
//		int y = random.nextInt(4) + 1; 
//		int z = x / y;
//		System.out.println(x + "/" + y + " = " + z);
//		
		
		
	}
}
