package com.kitri.lang;

public class StringBufferTest1 {

	public static void main(String[] args) {
		
		//StringBuffer
		//16칸(여유공간)+6글자 = 22 //StringBuffer는 항상 16칸의 여유공간을 만들어놓는다.//문자열조작
		StringBuffer sb1 = new StringBuffer("hello ");
		System.out.println("1. sb1 == " + sb1);
		
		//capacity()
		int cap = sb1.capacity();
		System.out.println("초기 크기 : " + cap +  "\t문자열 수 : " + sb1.length());
		
		//append()
		sb1.append("java"); //임시저장공간이어서 결과값이 계속 반영됨
		System.out.println("2. sb1 == " + sb1);
		sb1.append("!!!!!!");
		System.out.println("3. sb1 == " + sb1);
		cap = sb1.capacity();
		System.out.println("크기 : " + cap +  "\t문자열 수 : " + sb1.length());
		
		sb1.append("!!!!!!!");//크기를 넘어서면 자동으로 크기가(여유공간) 배로 늘어난다
		System.out.println("4. sb1 == " + sb1);
		cap = sb1.capacity();
		System.out.println("크기 : " + cap +  "\t문자열 수 : " + sb1.length());
		System.out.println("----------------------------");
		
		//insert()
		sb1.insert(10, "@@@"); //10번째 자리에 @@@을 삽입하라
		System.out.println("5. sb1 == " + sb1);
		
		//delete()
		sb1.delete(10, 12); //a부터 b전까지 지워라
		System.out.println("6. sb1 == " + sb1);
		
		//deleteCharAt()
		sb1.deleteCharAt(10); //해당하는 문자 하나만 지워라
		System.out.println("7. sb1 == " + sb1);
		
		//replace()
		sb1.replace(6, 10, "자바"); //a부터 b전까지를 뒤 문자로 대체하라		
		System.out.println("8. sb1 == " + sb1);
		
		//reverse()
		sb1.reverse(); //문자 뒤집기	
		System.out.println("9. sb1 == " + sb1);
		sb1.reverse();
		
		//setCharAt()
		sb1.setCharAt(9, '@'); //하나의 문자만 바꿔라
		System.out.println("10. sb1 == " + sb1);
		
		//최종사용할때는 string로 바꿔줘야함
		//StringBuffer를 String로 바꾸기(2가지방법)
		String s1 = new String(sb1);
		String s2 = sb1.toString();
		
		System.out.println("--------------------------");
		
		
		//문제: hello java !!!로 바꾸기 or 오라클은 없습니다
		String str = "hello 자바!!!";
		String findStr = "자바"; 
		//String findStr = "오라클";
		String replaceStr = "java";
		
		int start = str.indexOf(findStr); //시작점
		System.out.println(start);
		
		if(start != -1) { //찾았을때 없으면 -1나옴
			StringBuffer sb = new StringBuffer(str);
			int end = start + findStr.length();
			sb.replace(start, end, replaceStr);
			System.out.println(sb.toString());
		}else { 
			System.out.println(findStr + "은 없습니다");
		}
		
		

		
		
		
		
		
		
		String s = "hello"; //string은 한번 저장되면 수정x
		s.concat("java");
		System.out.println("\n" + s);
	}
}
