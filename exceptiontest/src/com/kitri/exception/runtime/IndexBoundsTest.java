package com.kitri.exception.runtime;

public class IndexBoundsTest {
	
	public static void main(String[] args) {
		String s[] = {"1", "2", "3", "4"};
		
//		������(�迭�� 3�����ۿ� ���µ� �� 4���������ϳ�)
//		for (int i = 0; i <= 4; i++) {
//			System.out.println(s[i]);
//		}
		
		int len = s.length;
		for (int i = 0; i < len; i++) {
			System.out.println(s[i]);
		}
		
		//���ڰ� �ٲ�� ������ ����
		String str = "hello";
//		for (int i = 0; i < 5; i++) {
//			System.out.println(str.charAt(i));
//		}
		
		//���ڰ� �ٲ� ������ ���� �ʴ´�
		len = str.length();
		for (int i = 0; i < len; i++) {
			System.out.println(str.charAt(i));
		}
	}
}
