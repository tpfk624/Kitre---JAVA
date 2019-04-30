package com.kitri.thread;

public class RunnableImpl implements Runnable{ //뭔가를 상속받아 Thread를 상속못받는 상황에 사용

	String msg;

	public RunnableImpl(String msg) {
		this.msg = msg;
	}

	@Override
	public void run() { 
		for (int i = 0; i < 500; i++) {
			System.out.println(msg);
		}
	}

}
