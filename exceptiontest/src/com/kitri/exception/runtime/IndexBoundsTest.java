package com.kitri.exception.runtime;

public class IndexBoundsTest {
	
	public static void main(String[] args) {
		String s[] = {"1", "2", "3", "4"};
		
//		에러남(배열이 3까지밖에 없는데 왜 4를뽑으라하냐)
//		for (int i = 0; i <= 4; i++) {
//			System.out.println(s[i]);
//		}
		
		int len = s.length;
		for (int i = 0; i < len; i++) {
			System.out.println(s[i]);
		}
		
		//문자가 바뀌면 에러가 난다
		String str = "hello";
//		for (int i = 0; i < 5; i++) {
//			System.out.println(str.charAt(i));
//		}
		
		//문자가 바뀌어도 에러가 나지 않는다
		len = str.length();
		for (int i = 0; i < len; i++) {
			System.out.println(str.charAt(i));
		}
	}
}
