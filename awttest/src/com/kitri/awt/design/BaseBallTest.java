package com.kitri.awt.design;

import java.awt.*;

public class BaseBallTest extends Frame {
	//생성부
	
	//패널3개
	Panel pC = new Panel();
	Panel pCS = new Panel();
	Panel pE = new Panel();

	TextArea ta = new TextArea();
	Label l = new Label("숫자");
	TextField tf = new TextField();
	
	Button newG = new Button("새게임");
	Button clear = new Button("지우기");
	Button dap = new Button("정답");
	Button fontC = new Button("글자색");
	Button exit = new Button("종료");
	
	

	
	public BaseBallTest() {
		super("숫자야구게임");
		//배치부
	
		//왼쪽 아래
		pCS.setLayout(new BorderLayout(10, 0));
		pCS.add(l, "West");
		pCS.add(tf, "Center");

		
		//왼쪽 합치기
		pC.setLayout(new BorderLayout(0, 10));
		pC.add(ta, "Center");
		pC.add(pCS, "South");
		
		//오른쪽 설정
		pE.setLayout(new GridLayout(5,1));
		pE.add(newG);
		pE.add(clear);
		pE.add(dap);
		pE.add(fontC);
		pE.add(exit);
		
		//최종 합치기
		setLayout(new BorderLayout(10,10));
		add(pC,"Center");
		add(pE, "East");
		
		setBounds(300, 200, 300, 500);
		setVisible(true);	
	}
	
	public static void main(String[] args) {
		new BaseBallTest();

	}

}
