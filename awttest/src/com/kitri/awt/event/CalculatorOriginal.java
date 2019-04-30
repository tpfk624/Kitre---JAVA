package com.kitri.awt.event;

import java.awt.*;

public class CalculatorOriginal extends Frame {
	//생성부
	
	//패널 2개
	Panel pN = new Panel();
	Panel pC = new Panel();
	
	Label numL = new Label();  			//숫자만
	Label operL = new Label("Click"); 	//연산자만
	
	String[] bnstr = {"7", "8", "9", "+","4", "5", "6","-","1", "2" , "3", "*", "0", "c" , "=", "/"};
	Button b[] = new Button[16]; //선언
	
	Button exit = new Button("종료");
	
	Color color = new Color(153, 56, 156);
	
	public CalculatorOriginal() {
		//배치부
		
		//위
		pN.setLayout(new BorderLayout());
		pN.add(numL, "Center");
		numL.setBackground(color.yellow);
		operL.setBackground(color.GREEN);
		pN.add(operL, "East");
		
		//중간 배열 숫자부분
		pC.setLayout(new GridLayout(4,4));
		for (int i = 0; i < b.length; i++) {
			pC.add(b[i] = new Button(bnstr[i])); //생성
		}
		
		
		//최종합치기
		setLayout(new BorderLayout(10,5));
		add(pN, "North");
		add(pC, "Center");
		add(exit, "South");
		
		
		setBounds(300, 200, 300, 300);
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new CalculatorOriginal();
	}
}
