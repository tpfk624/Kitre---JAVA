package com.kitri.awt.event;

import java.awt.*;

public class BaseBall extends Frame {
	//생성부
	
	//패널3개
	Panel pC = new Panel();
	Panel pCS = new Panel();
	Panel pE = new Panel();

	TextArea ta = new TextArea();
	Label l = new Label("입력");
	TextField tf = new TextField();
	
	Button newG = new Button("새게임");
	Button clear = new Button("지우기");
	Button dap = new Button("정답");
	Button fontC = new Button("글자색");
	Button exit = new Button("종료");
	
	//베이스볼컨드롤러 호출, 폰트컬러호출
	BaseBallController baseballController;
	FontColorChooser fontColorChooser = new FontColorChooser(); //has a관계니까 생성이다 / is a = 상속

	
	public BaseBall() {
		super("숫자야구게임");
		//배치부
	
		//왼쪽 아래
		pCS.setLayout(new BorderLayout(10, 0));
		pCS.add(l, "West");
		pCS.add(tf, "Center");

		
		//왼쪽 합치기
		pC.setLayout(new BorderLayout(0, 10));
		pC.add(pCS, "South");
		ta.setEditable(false);
		//ta.setEnabled(false);
		//ta.setFont(f);
		pC.add(ta, "Center");
		
		
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
		
		setBounds(300, 200, 500, 400);
		setVisible(true);	
		
		baseballController = new BaseBallController(this); //자기자신의객체 던져주기
		
		//BaseBall창 이벤트 등록
		tf.addActionListener(baseballController); //연결해주기
		newG.addActionListener(baseballController);
		clear.addActionListener(baseballController);
		dap.addActionListener(baseballController);
		fontC.addActionListener(baseballController);
		exit.addActionListener(baseballController);
		
		//추가(x창누르면 닫기 프로그램종료)
		this.addWindowListener(baseballController);
		
		//FontColorChooser 이벤트 등록			
		fontColorChooser.sbR.addAdjustmentListener(baseballController);
		fontColorChooser.sbG.addAdjustmentListener(baseballController);
		fontColorChooser.sbB.addAdjustmentListener(baseballController);
		
		//FontColorChooser-버튼  이벤트등록
		fontColorChooser.ok.addActionListener(baseballController);
		
		//FontColorChooser x창누르면 닫기를 여기다가 하면 다 닫히니까 여기서 구현하지 xxx
		//fontColorChooser.addWindowListener(baseballController);//이걸하면 프로그램이 꺼져버림
		
	}
	
	public static void main(String[] args) {
		new BaseBall();

	}

}
