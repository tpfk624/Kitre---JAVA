package com.kitri.lang;


//Wrapper Class : 기본DT을 클래스화
//기본DT		WrapperClass
//boolean		Boolean
//char			Character
//byte			Byte
//short			Short
//int			Integer
//long			Long
//float			Float
//double		Double


public class WrapperClassTest {
	
	public static void main(String[] args) {
		Boolean b1 = new Boolean(true);
		boolean b2 = b1.booleanValue();
		
		boolean b3 = Boolean.parseBoolean("true");
		
		if(b2)
			System.out.println("b2는 true다");
		if(b3)
			System.out.println("b2는 true다");
		
		
		String s = "123";
		System.out.println(s + 4); //1234
		//int x = (int) s;
		//Integer i = newInteger(s);
		//int x= intValue();
		int x =  Integer.parseInt(s); //매우 중요 : 문자열을 숫자로 바꿔준다. 숫자형식인것만 가능
		System.out.println(x + 4); //127
		
		s = "123.45";
		double d = Double.parseDouble(s);
		System.out.println( d + 4 ); //127.45
		
		//기본은 기본끼리 래퍼런스는 래퍼런스끼리
		//문자열을 기본클래스로 바꿀때 래퍼런스클래스사용
		
		//autoboxing(단 조건은 레퍼런스타입에서 같은 조건끼리만)
		Integer i2 = new Integer(3);
		//unboxing(자기기능 다 버리고 int로 간다)
		int y = i2;
		//boxing(자동으로 포장)
		Integer i3= y;
		

		
	}
	
	
}
