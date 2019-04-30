package com.kitri.awt.event;

import java.awt.*;
import java.awt.event.*;

public class ItemTest extends Frame {
	//선언부
	Panel pN = new Panel();
	Panel pS = new Panel();
	
	CheckboxGroup cg = new CheckboxGroup();	
	Checkbox mor = new Checkbox("아침", cg, true);
	Checkbox aft = new Checkbox("점심", cg, false);
	Checkbox eve = new Checkbox("저녁", cg, false);	
	Checkbox app = new Checkbox("사과", true);
	Checkbox banana = new Checkbox("바나나");
	Checkbox straw = new Checkbox("딸기");
	
	TextArea ta = new TextArea();
	
	Choice ch = new Choice();
	Button exit = new Button("종료");
	
	ItemLogic itemlogic;
	
	public ItemTest() {
		//배치부
		pN.setLayout(new GridLayout(2,3));
		pN.add(mor);
		pN.add(aft);
		pN.add(eve);
		pN.add(app);
		pN.add(banana);
		pN.add(straw);
		
		
		pS.setLayout(new BorderLayout(10, 0));
		ch.add("아침");
		ch.add("점심");
		ch.add("저녁");
		pS.add(ch, "Center");
		pS.add(exit, "East");
		
	
		setLayout(new BorderLayout(0,10));
		add(pN, "North");
		add(ta, "Center");
		add(pS, "South");
		
		
		
		setBounds(300, 200, 300, 300);
		setVisible(true);
		
		itemlogic = new ItemLogic(this);//객체생성
		exit.addActionListener(itemlogic);//itemlogic에 있다는걸 알려줌
									
		mor.addItemListener(itemlogic);
		aft.addItemListener(itemlogic);
		eve.addItemListener(itemlogic);
		app.addItemListener(itemlogic);
		banana.addItemListener(itemlogic);
		straw.addItemListener(itemlogic);
		ch.addItemListener(itemlogic);
	}
	
	public static void main(String[] args) {
		new ItemTest();
	}
}
