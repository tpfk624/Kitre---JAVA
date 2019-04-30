package com.kitri.lang;

public class StringTest5 {

	public static void main(String[] args) {
		
		//indexOf()
		String str = "hello java!!!";
		int x = str.indexOf('a');
		System.out.println(str + "에서 a는 " + (x+1) + "번째있다");
		
		x = str.indexOf('a', 8);
		System.out.println(str + "에서 8번째부터 a는 " + (x+1) + "번째있다");
		
		x = str.indexOf("java");//문자열의 시작점
		System.out.println(str + "에서 java는 " + (x+1) + "번째있다");
		System.out.println("---------------------------");
		
		//lastIndexOf() - 마지막에 나오는 ''가 어디에 있냐
		x = str.lastIndexOf("a");
		System.out.println(str + "에서 java는 " + (x+1) + "번째있다");
		System.out.println("---------------------------");
		
		//isEmpty()
		String str2 = "";
		System.out.println(str2 + "의 길이 : " + str2.length());
		if(str2.isEmpty()) //비어있다면
			System.out.println("빈문자열이다");
		else
			System.out.println("str == " + str2);
		System.out.println("---------------------------");
		
		
		//trim() - 앞 뒤 공백제거(문자열과 문자열사이 공백제거는 x)
		String str3 = "  hello   .    ";
		System.out.println(str3 + "의 길이 : " + str3.length());
		
		System.out.println(str3.trim() + "의 공백 제거 후 길이 : " + str3.trim().length());
		System.out.println("---------------------------");
		
		
		//replace() - 문자를 바꿔라(1.4이상 버전만 문자열변경 가능)
		String str4 = "jaba";
		System.out.println(str4 + ":::: " + str4.replace('b', 'v' ));
		System.out.println(str4 + ":::: " + str4.replace("jaba", "java"));
		System.out.println(str4 + ":::: " + str4.replaceAll("jaba", "java"));
		System.out.println("---------------------------");
		
		//split()
		String str5 = "hello java !!!";
		String s[] = str5.split(" ");
		int len = s.length;
		for (int i = 0; i < len; i++) {
			System.out.println("s[" + i + "]" + s[i]);
		}
		System.out.println("---------------------------");
		
		
		//substring()
		System.out.println(str5.substring(6));
		//오라클은 6부터 9개 //자바는 6부터 9전까지
		System.out.println(str5.substring(6, 9));
		System.out.println("---------------------------");
		
		//숫자 >>>> 문자열 3가지방법
		int num = 100;
		String sn1 = num + "";
		System.out.println(sn1 + 100);
		
		String sn2 = String.valueOf(num);
		System.out.println(sn2 + 100);
		
		String sn3 = Integer.toString(num);
		System.out.println(sn3 + 100);
		System.out.println("---------------------------");
		
		//문자열 >> 숫자 (한가지)
		String ns = "100";
		num = Integer.parseInt(ns);
		System.out.println(num + 200);
		
		
		
		
		
		
	}

}
