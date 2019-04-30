package com.kitri.awt.design;

import java.awt.*;

public class Calculator extends Frame {
	//생성부
	
	//패널 2개
	Panel p1 = new Panel();
	Panel p2 = new Panel();
	
	Label numL = new Label();
	Label operL = new Label("Click");
	
	String[] bnstr = {"0", "c" , "=", "/", "1", "2" , "3", "*","4", "5", "6","-", "7", "8", "9", "+"};
	Button b[] = new Button[16]; //선언
	
	Button exit = new Button("종료");
	
	Color color = new Color(153, 56, 156);
	
	public Calculator() {
		//배치부
		
		//위
		p1.setLayout(new BorderLayout());
		p1.add(numL, "Center");
		numL.setBackground(color.yellow);
		operL.setBackground(color.GREEN);
		p1.add(operL, "East");
		
		//중간 배열 숫자부분
		p2.setLayout(new GridLayout(4,4));
		for (int i = 0; i < b.length; i++) {
			p2.add(b[i] = new Button(bnstr[i])); //생성
		}
		
		
		//최종합치기
		setLayout(new BorderLayout(10,5));
		add(p1, "North");
		add(p2, "Center");
		add(exit, "South");
		
		
		setBounds(300, 200, 300, 300);
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new Calculator();
	}
}
