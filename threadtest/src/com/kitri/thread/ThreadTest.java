package com.kitri.thread;

public class ThreadTest {
	
	public static void main(String[] args) {
		Thread t1 = new ThreadExt("��");
		Thread t2 = new ThreadExt("��");
		Thread t3 = new ThreadExt("!!!");
				
//		t1.run();//������� 500���� �����
//		t2.run();//������� 500���� �����
//		t3.run();//������� 500���� �����
		
		t1.start(); //������ �޶���(�����忡 ���� ���ôٹ������� ���)
		t2.start();
		t3.start();
		
		System.out.println("���α׷� ����!!!");
	}
}
