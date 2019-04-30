package com.kitri.awt.event;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController implements ActionListener {

	Calculator calculator;
	CalculatorService calculatorService;
	int len;


	public CalculatorController(Calculator calculator) {
		this.calculator = calculator;
		calculatorService = new CalculatorService(this);
        len = calculator.btn.length;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		if (ob == calculator.exit) {
			calculatorService.exit();
		} else {
			for (int i = 0; i < len; i++) {
				if (ob == calculator.btn[i]) {
					calculatorService.Calc(i);
				}
			}
			
		}

	}
}