package com.kitri.thread;

public class RunnableTest {

	public static void main(String[] args) {
		
		//�����带 ��ӹ����� �ʾƼ� new runnable�� �ȵǰ� ���ʺ��� ??�� �θ�?
		Thread t1 = new Thread(new RunnableImpl("��")); 
		Thread t2 = new Thread(new RunnableImpl("��"));
		Thread t3 = new Thread(new RunnableImpl("!!!"));
		
		t1.start(); //������ �޶���(�����忡 ���� ���ôٹ������� ���)
		t2.start();
		t3.start();
		
		System.out.println("���α׷� ����!!!");
		
	}
}
