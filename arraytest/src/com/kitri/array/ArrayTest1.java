package com.kitri.array;

public class ArrayTest1 {

	public static void main(String[] args) {
		int x1 = 10;
		int x2 = 20;
		int x3 = 30;
		System.out.println("x1 = " + x1 + "\nx2 = " + x2 + "\nx3 = " + x3);
		System.out.println("------------------------------------");
		
		int x[];
		x = new int[3];
		x[0] = 10;
		x[1] = 20;
		x[2] = 30;
		System.out.println("x[0] = " + x[0] + "\nx[1] = " + x[1] + "\nx[2] = " + x[2]);
		System.out.println("------------------------------------");
		
		for(int i = 0; i<3; i++)
			System.out.println("x[" + i + "] = " + x[i]);
		System.out.println("------------------------------------");
		
		int len = x.length;
		System.out.println("�迭�� ����: " + len);
	}

}
