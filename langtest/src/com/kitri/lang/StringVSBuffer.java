package com.kitri.lang;

public class StringVSBuffer {

	public static void main(String[] args) {
		
		long st = System.nanoTime(); //속도뽑아내기
		
		String str = "hello";
		for(int i = 0; i<5000; i++) {
			str += i;
		}
		
//		StringBuffer sb = new StringBuffer("hello");
//		for(int i = 0; i<5000; i++) {
//			sb.append(i);
//		}
//		
		System.out.println(System.nanoTime() - st);
	}

}
//500
//string - 		 904801,  1143109, 926932,  929177 
//stringBuffer - 221630,  198215,  196292,  223554

//5000
//string - 		 41203895 41681153 41341813 42191768
//stringBuffer - 1128035, 1103659, 1226180, 1254405

//문자열을 더할때는 stringBuffer를 사용하라


