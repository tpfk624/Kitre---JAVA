package com.kitri.test5;

public class Sonata extends Car{

	private String series;
	private String use;
	
	public Sonata(String color, int account,String use, String series) {
		super(color, account);
		this.use = use;
		this.series = series;
		
	}

	@Override
	public String toString() {
		return super.toString() + "[�뵵] " + use + "[�ø���] " + series;
	}
	
	
}
