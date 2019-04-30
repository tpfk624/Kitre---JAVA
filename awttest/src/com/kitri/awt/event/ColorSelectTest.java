package com.kitri.awt.event;

import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class ColorSelectTest extends Frame implements AdjustmentListener{
	//�����
	
	//�г�6�� �ʿ�
	Panel p1 = new Panel();
	Panel p11 = new Panel();
	Panel p12 = new Panel();
	Panel p13 = new Panel();
	Panel p2 = new Panel();
	Panel p21 = new Panel();
	
	Label lR = new Label("����", Label.CENTER);
	Label lG = new Label("�ʷ�", Label.CENTER);
	Label lB = new Label("�Ķ�", Label.CENTER);
	
	Scrollbar sbR = new Scrollbar(Scrollbar.HORIZONTAL, 127, 10, 0, 265); //�ʱⰪ,�β�,�ּҰ�,�ִ밪
	Scrollbar sbG = new Scrollbar(Scrollbar.HORIZONTAL, 127, 10, 0, 265); //������ 255���� �ִ������� �� ���̰�10�̴� +10
	Scrollbar sbB = new Scrollbar(Scrollbar.HORIZONTAL, 127, 10, 0, 265);
	
	Panel colorP = new Panel();
	Label colorL = new Label();
	Button ok = new Button("Ȯ��");

	Color color = new Color(153, 56, 156);
	
	public ColorSelectTest() {
		super("����ǥ");
		//��ġ��
		p11.setLayout(new BorderLayout(10,0));
		lR.setBackground(color.red);
		p11.add(lR, "West");
		p11.add(sbR, "Center");
		
		p12.setLayout(new BorderLayout(10,0));
		lG.setBackground(color.green);
		p12.add(lG, "West");
		p12.add(sbG, "Center");
		
		p13.setLayout(new BorderLayout(10,0));
		lB.setBackground(color.blue);
		p13.add(lB, "West");
		p13.add(sbB, "Center");
		
		p1.setLayout(new GridLayout(6,1));
		p1.add(new Label(""));
		p1.add(p11);
		p1.add(p12);
		p1.add(p13);
		
		p21.setLayout(new BorderLayout());
		p21.add(colorL, "Center");
		p21.add(ok, "East");
		
		p2.setLayout(new BorderLayout());
		p2.add(colorP, "Center");
		p2.add(p21, "South");
		

		setLayout(new GridLayout(1,2, 10, 0));
		add(p1);
		add(p2);
		
		
		setBounds(300, 200, 500, 300);
		setVisible(true);
		
		//���
		sbR.addAdjustmentListener(this);
		sbG.addAdjustmentListener(this);
		sbB.addAdjustmentListener(this);
		
		changeColor();
		
	}
	
	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {	
		changeColor();
		
	}

	private void changeColor() {
		int r = sbR.getValue();
		int g = sbG.getValue();
		int b = sbB.getValue();
		colorP.setBackground(new Color(r, g, b));
		colorL.setText("r = " + r + "g = " + g + "b = " + b);
	}
	
	
	public static void main(String[] args) {
		new ColorSelectTest();

	}






}
