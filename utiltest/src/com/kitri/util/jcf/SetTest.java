package com.kitri.util.jcf;

import java.util.*;

public class SetTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("황선혜");
		set.add("박미래");
		set.add("이혜린");
		set.add("조윤영");
		set.add("박미래");
		System.out.println("set의 크기 : " + set.size());
		
//		방법1		
//		Object ob[] = set.toArray();
//		int len = ob.length;
//		for (int i = 0; i < len; i++) {
//			System.out.println((String) ob[i]);
//		}
		
		//방법2
		String str[] = set.toArray(new String[0]);//크기는 사이즈가지고 되니까 스트링의배열인지만 알려줘라
		int len = str.length;
		for (int i = 0; i < len; i++) {
			System.out.println(str[i]);
		}
		
		//방법3
		System.out.println("--------------------");
		Iterator<String> iterate = set.iterator();
		while(iterate.hasNext()) {
			System.out.println(iterate.next());  //StringTokenizerTest 소스 비슷
		}
	}
}
