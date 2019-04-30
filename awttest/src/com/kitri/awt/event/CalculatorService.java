package com.kitri.awt.event;

import java.awt.event.ActionEvent;

public class CalculatorService {

	CalculatorController calculatorController;
	private Calculator cc;
	
	public CalculatorService(CalculatorController calculatorController) {
		this.calculatorController = calculatorController;
		cc = calculatorController.calculator;
	}

	// 숫자: 0 1 2 3 4 5 6 7 8 9 10 11 12
	// clear 13
	// enter 14
	// oper 3 7 11 15
	public void Calc(int i) {
		String str = cc.btn[i].getLabel();
		int check = cc.bstr[i].charAt(0) - 48;
		if (check >= 0 && check < 10) { //숫자이면
			cc.numL.setText(str);
		} else if (str == "C") {
			clear();
		}else { //연산자이면
			cc.operL.setText(str);
			Operator(str);
		}
	}

	public void Operator(String str) {
 		if (str.equals("+")) {
 			cc.op = 1;		
 		} else if (str.equals("-")) {
 			cc.op = 2;
 		} else if (str.equals("*")) {
 			cc.op = 3;
 		} else if (str.equals("/")) {
 			cc.op = 4;
 		} else {
 			result();
 			cc.op = 0;
 		}
 		cc.buffer = (new Double(cc.numL.getText())).doubleValue();
 	}

	
	//= 버튼을 누르면 호출되는 결과처리 메서드.
	 	public void result() {
	 		double result = 0;
	 		double in = (new Double(cc.numL.getText())).doubleValue();
	 		switch (cc.op) {
	 		case 1:
	 			result = cc.buffer + in;
	 			break;
	 		case 2:
	 			result = cc.buffer - in;
	 			break;
	 		case 3:
	 			result = cc.buffer * in;
	 			break;
	 		case 4:
	 			result = cc.buffer / in;
	 			break;
	 		}
	 		cc.numL.setText(result + "");
	 	}
	
	private void clear() {
		cc.numL.setText("");
		cc.operL.setText("");
	}

	public void exit() {
		System.exit(0);

	}
}