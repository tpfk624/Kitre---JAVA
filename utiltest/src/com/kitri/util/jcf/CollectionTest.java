package com.kitri.util.jcf;

import java.util.*;

public class CollectionTest {

	public static void main(String[] args) {
		
		//둘 다 컬렉션계열이나 순서유지의 차이이다.
		Collection coll = new ArrayList();	//들어온 순서 유지
//		Collection coll = new HashSet();	//들어온 순서 유지x
		
		System.out.println("초기크기 : " + coll.size());
		coll.add("홍길동");
		coll.add("이순신");
		coll.add("강감찬");
		coll.add("윤봉길");
		//coll.add(new Integer(10)); 인티저라 오류
		System.out.println( "마지막 크기 : " + coll.size());//배열은 .length를 쓰지만 coll은 .size를 쓴다
		
		//서로 다른 데이터타입은 같이 쓸 필요가없다.		
		Object ob[] = coll.toArray();
		int len = ob.length;
		for (int i = 0; i < len; i++) {
			System.out.println((String) ob[i]);
		}
	}
}
