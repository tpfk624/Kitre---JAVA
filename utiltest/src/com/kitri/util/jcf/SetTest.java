package com.kitri.util.jcf;

import java.util.*;

public class SetTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("Ȳ����");
		set.add("�ڹ̷�");
		set.add("������");
		set.add("������");
		set.add("�ڹ̷�");
		System.out.println("set�� ũ�� : " + set.size());
		
//		���1		
//		Object ob[] = set.toArray();
//		int len = ob.length;
//		for (int i = 0; i < len; i++) {
//			System.out.println((String) ob[i]);
//		}
		
		//���2
		String str[] = set.toArray(new String[0]);//ũ��� ��������� �Ǵϱ� ��Ʈ���ǹ迭������ �˷����
		int len = str.length;
		for (int i = 0; i < len; i++) {
			System.out.println(str[i]);
		}
		
		//���3
		System.out.println("--------------------");
		Iterator<String> iterate = set.iterator();
		while(iterate.hasNext()) {
			System.out.println(iterate.next());  //StringTokenizerTest �ҽ� ���
		}
	}
}
