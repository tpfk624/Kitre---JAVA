package com.kitri.awt.design;

import java.awt.*;

public class ListTest extends Frame {
	//선언부
	
	//패널3개
	Panel p1 = new Panel();
	Panel p2 = new Panel();
	Panel p3 = new Panel();
	//Panel p4 = new Panel();
	
	List listL = new List();
	List listR = new List();
	TextField tfL = new TextField();
	TextField tfR = new TextField();
	
	Button btR = new Button("▷");
	Button btRAll = new Button("▶");
	Button btL = new Button("◁");
	Button btLAll = new Button("◀");
	
	Font f = new Font("굴림", Font.BOLD, 20);
	

	public ListTest() {
		super("리스트테스트");
		//배치부
		p1.setLayout(new BorderLayout(0, 10));
		p1.add(listL, "Center");
		p1.add(tfL,"South");

		
		p2.setLayout(new GridLayout(6,1, 0, 20));
		p2.add(new Label(""));
		btR.setFont(f);
		btRAll.setFont(f);
		btL.setFont(f);
		btLAll.setFont(f);
		p2.add(btR);
		p2.add(btRAll);
		p2.add(btL);
		p2.add(btLAll);

		p3.setLayout(new BorderLayout(0, 10));
		p3.add(listR, "Center");
		p3.add(tfR,"South");
		
		setLayout(new GridLayout(1, 3, 10, 0));
		add(p1);
		add(p2);
		add(p3);
	
		
		setBounds(300, 200, 350, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ListTest();

	}

}
