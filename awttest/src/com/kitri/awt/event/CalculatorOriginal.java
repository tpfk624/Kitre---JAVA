package com.kitri.awt.event;

import java.awt.*;

public class CalculatorOriginal extends Frame {
	//������
	
	//�г� 2��
	Panel pN = new Panel();
	Panel pC = new Panel();
	
	Label numL = new Label();  			//���ڸ�
	Label operL = new Label("Click"); 	//�����ڸ�
	
	String[] bnstr = {"7", "8", "9", "+","4", "5", "6","-","1", "2" , "3", "*", "0", "c" , "=", "/"};
	Button b[] = new Button[16]; //����
	
	Button exit = new Button("����");
	
	Color color = new Color(153, 56, 156);
	
	public CalculatorOriginal() {
		//��ġ��
		
		//��
		pN.setLayout(new BorderLayout());
		pN.add(numL, "Center");
		numL.setBackground(color.yellow);
		operL.setBackground(color.GREEN);
		pN.add(operL, "East");
		
		//�߰� �迭 ���ںκ�
		pC.setLayout(new GridLayout(4,4));
		for (int i = 0; i < b.length; i++) {
			pC.add(b[i] = new Button(bnstr[i])); //����
		}
		
		
		//������ġ��
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
