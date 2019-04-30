package com.kitri.thread;

public class RunnableTest {

	public static void main(String[] args) {
		
		//쓰레드를 상속받지는 않아서 new runnable는 안되고 러너블의 ??를 부름?
		Thread t1 = new Thread(new RunnableImpl("퐁")); 
		Thread t2 = new Thread(new RunnableImpl("당"));
		Thread t3 = new Thread(new RunnableImpl("!!!"));
		
		t1.start(); //순서가 달라짐(쓰레드에 의해 동시다발적으로 출력)
		t2.start();
		t3.start();
		
		System.out.println("프로그램 종료!!!");
		
	}
}
