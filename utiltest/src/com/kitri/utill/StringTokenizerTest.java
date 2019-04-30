package com.kitri.utill;

import java.util.StringTokenizer;
import java.util.UUID;

public class StringTokenizerTest {

	public static void main(String[] args) {
		String str = "hello java !!!";
		StringTokenizer st = new StringTokenizer(str); //자를 준비가 됐다
		int cnt = st.countTokens();
		System.out.println("토큰 수 : " + cnt); //아무것도 지정안하면 공백을 기준으로 함
		
		while(st.hasMoreTokens()) { //토큰있냐
			System.out.println(st.nextToken());//있으면 얻어와라
		}
		
		str = "TO|안효인|안녕하세요 오늘 뭐해요???"; // | 기준으로 함
		StringTokenizer st2 = new StringTokenizer(str, "|"); 
		
		String protocol = st2.nextToken();
		String to =st2.nextToken();
		String msg = st2.nextToken();
		
		System.out.println("기능 : " + protocol);
		System.out.println("누구에게 : " + to);
		System.out.println("보내는 메세지 : " + msg);	
		
		System.out.println(UUID.randomUUID());
	}
}
