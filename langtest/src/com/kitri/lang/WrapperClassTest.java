package com.kitri.lang;


//Wrapper Class : �⺻DT�� Ŭ����ȭ
//�⺻DT		WrapperClass
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
			System.out.println("b2�� true��");
		if(b3)
			System.out.println("b2�� true��");
		
		
		String s = "123";
		System.out.println(s + 4); //1234
		//int x = (int) s;
		//Integer i = newInteger(s);
		//int x= intValue();
		int x =  Integer.parseInt(s); //�ſ� �߿� : ���ڿ��� ���ڷ� �ٲ��ش�. ���������ΰ͸� ����
		System.out.println(x + 4); //127
		
		s = "123.45";
		double d = Double.parseDouble(s);
		System.out.println( d + 4 ); //127.45
		
		//�⺻�� �⺻���� ���۷����� ���۷�������
		//���ڿ��� �⺻Ŭ������ �ٲܶ� ���۷���Ŭ�������
		
		//autoboxing(�� ������ ���۷���Ÿ�Կ��� ���� ���ǳ�����)
		Integer i2 = new Integer(3);
		//unboxing(�ڱ��� �� ������ int�� ����)
		int y = i2;
		//boxing(�ڵ����� ����)
		Integer i3= y;
		

		
	}
	
	
}
