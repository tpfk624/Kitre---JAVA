package com.kitri.test6;

public class Drama extends TVProgram{
	
	private String director;
	private String actor;
	private String actress;
	

	public Drama(String title, String broadcast, String director) {
		super(title, broadcast);
		this.director = director;
	}



	public Drama(String title, String broadcast, String director, String actor, String actress) {
		super(title, broadcast);
		this.director = director;
		this.actor = actor;
		this.actress = actress;
	}


	@Override
	public String toString() {
		String str = super.toString() + ")" + director;
		if(actor != null) 
			str += "\t" + actor;
		else 
			str += "\t";
		if(actress != null)
			str += "\t" + actress;
		return str;
	}



	
	


	
	
	
}
