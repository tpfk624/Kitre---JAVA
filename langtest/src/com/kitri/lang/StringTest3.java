package com.kitri.lang;

public class StringTest3 {

	public static void main(String[] args) {
		
		//charAt()
		String str = "hello java!!";
		char c = str.charAt(4);
		System.out.println("c == " + c);
		
		str = "123";
		int x = str.charAt(0) - 48; //'1'을 char로 받으니 아스키코드값인 49가 나옴 -48해서 1로 만들기 
		System.out.println("x == " + x);
		
		str = "1a3";
		int len = str.length();
		System.out.println("length == " + len);
		
		
		//강사님버전
		String result = "숫자입니다";
		for (int i = 0; i < len; i++) {
			int num = str.charAt(i) - 48;
			if(num < 0 || num > 9) {
				result = " 숫자가 아닙니다";
				break;
			}
		}
		System.out.println(str + "은" + result);
		
		//내가 푼 거
		str = "1a3";
		String find = null;
		for(int i = 0; i < len ; i++) {
			if(str.charAt(i) > 65) {
				find = "문자";
			}
		}
		if(find != "문자") {
			System.out.println(str + "은 숫자입니다" );
		}else {
			System.out.println(str + "은 문자가 있습니다" );
		}
		System.out.println("-----------------------");
		
		//알아만 두기
		//concat(String str)
		String str1 = "hello ";
		String str2 = "java";
		System.out.println(str1 + str2);
		System.out.println(str1.concat(str2));
		System.out.println("-----------------------");
		
		
		//startsWith(), endsWith()
		str = "hello java!!";
		if(str.startsWith("h")) //시작
			System.out.println(str + "은 h로 시작한다");
		if(str.endsWith("!!")) //끝 //문자열도 가능
			System.out.println(str + "은 !!로 끝난다");
		System.out.println("-----------------------");
		
		
		//toUpperCase(), s2.toLowerCase() //string을 리턴
		String s1 = "jAva";
		String s2 = "JavA"; 
		System.out.println("s1.toUpperCase() == " + s1.toUpperCase()); //대문자
		System.out.println("s2.toLowerCase() == " + s1.toLowerCase()); //소문자
		if(s1.equals(s2))
			System.out.println(s1 + "과" + s2 + "는 같은 문자열이다");
		else
			System.out.println(s1 + "과" + s2 + "는 다른 문자열이다");
		System.out.println("-----------------------");
		
		
	
		
		//equalsIgnoreCase()
		if((s1.equalsIgnoreCase(s2)))//알파벳으로 비교
			System.out.println(s1 + "과" + s2 + "는 대소문자 구분없이 같은 문자열이다");
		else
			System.out.println(s1 + "과" + s2 + "는 대소문자 구분없이 다른 문자열이다");
		
		//두개 모두 같은 걸로 동일하기
		if((s1.toUpperCase().equals(s2.toUpperCase())))
			System.out.println(s1 + "과" + s2 + "는 대소문자 구분없이 같은 문자열이다");
		else
			System.out.println(s1 + "과" + s2 + "는 대소문자 구분없이 다른 문자열이다");
		System.out.println("-----------------------");
		
	}
}
