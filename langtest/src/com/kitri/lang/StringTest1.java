package com.kitri.lang;

public class StringTest1 {

	public static void main(String[] args) {
		String s1 ="java"; //문자열저장소
		String s2 ="java";
		String s3 =new String("java"); //힙영역
		String s4 =new String("java");

		if(s1 == s2)
			System.out.println("s1 s2는 주소값이 같다"); //o
		if(s1 == s3)
			System.out.println("s1 s3는 주소값이 같다"); //x
		if(s1 == s4)
			System.out.println("s1 s4는 주소값이 같다"); //x
		if(s2 == s3)
			System.out.println("s2 s3는 주소값이 같다"); //x
		if(s2 == s4)
			System.out.println("s2 s4는 주소값이 같다"); //x
		if(s3 == s4)
			System.out.println("s3 s4는 주소값이 같다"); //x 
	
		//s1,s2는 리터럴방식으로 문자열저장소에 저장이 되고 s3,s4는 힙영역에 저장
		
		//1.리터럴방식과 new는 만들어지는 영역 자체가 다르다(비교의미가 없다.)
		//2.문자열저장소에 만들어질때에는 무조건 새로 만들어지는것이 아니라 같은 내용이면 주소값을 불러온다
		
		System.out.println("---------------------------------");
		
//		.equals()는 오브젝트에서는 주소값비교이지만
//		string에서는 .equals()를 오버라이딩해서 문자열비교이다.
//		자바는 대소문자 가린다
//		비교연산자와 이퀄스차이점

		System.out.println("---------------------------------");
		
		if(s1.equals(s2))
			System.out.println("s1 s2는 문자값이 같다"); //o
		if(s1.equals(s3))
			System.out.println("s1 s3는 문자값이 같다"); //o
		if(s1.equals(s4))
			System.out.println("s1 s4는 문자값이 같다"); //o
		if(s2.equals(s3))
			System.out.println("s2 s3는 문자값이 같다"); //o
		if(s2.equals(s4))
			System.out.println("s2 s4는 문자값이 같다"); //o
		if(s3.equals(s4))
			System.out.println("s3 s4는 문자값이 같다"); //o
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
