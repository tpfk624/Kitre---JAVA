package com.kitri.thread;

public class ThreadTest {
	
	public static void main(String[] args) {
		Thread t1 = new ThreadExt("퐁");
		Thread t2 = new ThreadExt("당");
		Thread t3 = new ThreadExt("!!!");
				
//		t1.run();//순서대로 500번씩 실행됨
//		t2.run();//순서대로 500번씩 실행됨
//		t3.run();//순서대로 500번씩 실행됨
		
		t1.start(); //순서가 달라짐(쓰레드에 의해 동시다발적으로 출력)
		t2.start();
		t3.start();
		
		System.out.println("프로그램 종료!!!");
	}
}
