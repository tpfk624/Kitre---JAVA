package com.kitri.test;

import java.awt.*;

public class ItemTest extends Frame {
	//�����
	Panel pN = new Panel();
	Panel pS = new Panel();
	
	CheckboxGroup cg = new CheckboxGroup();	
	Checkbox mor = new Checkbox("��ħ", cg, true);
	Checkbox aft = new Checkbox("����", cg, false);
	Checkbox eve = new Checkbox("����", cg, false);	
	Checkbox app = new Checkbox("���", true);
	Checkbox banana = new Checkbox("�ٳ���");
	Checkbox straw = new Checkbox("����");
	
	TextArea ta = new TextArea();
	
	Choice ch = new Choice();
	Button exit = new Button("����");
	
	public ItemTest() {
		//��ġ��
		pN.setLayout(new GridLayout(2,3));
		pN.add(mor);
		pN.add(aft);
		pN.add(eve);
		pN.add(app);
		pN.add(banana);
		pN.add(straw);
		
		
		pS.setLayout(new BorderLayout(10, 0));
		ch.add("��ħ");
		ch.add("����");
		ch.add("����");
		pS.add(ch, "Center");
		pS.add(exit, "East");
		
	
		setLayout(new BorderLayout(0,10));
		add(pN, "North");
		add(ta, "Center");
		add(pS, "South");
		
		
		
		setBounds(300, 200, 300, 300);
		setVisible(true);
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new ItemTest();
	}
}
