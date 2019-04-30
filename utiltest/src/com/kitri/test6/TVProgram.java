package com.kitri.test6;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class TVProgram {
	
	private String title;
	private String broadcast;
	
	
	public TVProgram(String title,String broadcast) {
		super();
		this.title = title;
		this.broadcast = broadcast;
	}


	@Override
	public String toString() {
		return title + " (" + broadcast; 
	}
	
	
}
