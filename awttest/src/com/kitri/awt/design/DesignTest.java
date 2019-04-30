package com.kitri.awt.design;

import java.awt.*;

//1. Frame 상속
//2. 선언부에 필요한 객체 생성
//3. 배치부에서 design(component배치)
//** 작업은 소 >> 대

public class DesignTest extends Frame{
	//선언부
	Panel pN = new Panel(); //일반적으로 panel은 기본생성자로 만드는게 편하다
	Panel pS = new Panel();
	
	Label l = new Label("입력", Label.CENTER);
	TextField tf = new TextField();
	Button send = new Button("전송");
	
	TextArea ta = new TextArea();
	
	Choice ch = new Choice();
	Button exit = new Button("종료");
	
	
	public DesignTest() { //생성자
		super("Design Test !!!"); //제목달기
		//배치부
		//1.setText("입력");//라벨의 객체생성시 입력을 적어서 사용x
		
		//LayoutManager lm = new BorderLayout();
		pN.setLayout(new BorderLayout(10, 0));//hgap,vgap 컴포넌트와 컴포넌트의 갭
		l.setBackground(new Color(210,150,150));//0~255
		//l.setForeground(new Color(255, 0, 0));
		l.setForeground(Color.BLUE);
		Font f = new Font("굴림", Font.BOLD, 20); //여기저기 쓰고 싶으면 선언
		l.setFont(f);
		pN.add(l, "West"); 
		pN.add(tf, "Center");
		send.setFont(f);
		pN.add(send, "East");
		
		pS.setLayout(new GridLayout(1, 2, 10, 0));//간격조정도 가능
		ch.add("서울");
		ch.add("경기,인천");
		ch.add("강원");
		ch.add("충청");
		pS.add(ch);
		exit.setFont(f);
		pS.add(exit);
		
		setLayout(new BorderLayout(0, 10));//위아래 vgap조정하기
		add(pN, "North"); //프레임의 dl이 BorderLayout이어서 그냥add
		add(ta, "Center");
		add(pS, BorderLayout.SOUTH);//이렇게도 사용가능
		
	
		//setSize(300, 500); //프레임크기지정
		//setLocation(300, 200);//프레임 위치 조정
		setBounds(300, 200, 300, 500);//setSize + setLocation
		setResizable(false);//사이즈 못바꾸게 함
		setVisible(true);//프레임을 눈에 보이게하라 //항상 배치부에 마지막에 넣기(모든걸 지정하고 보이는게 좋음)
	}
	
	public static void main(String[] args) {
		//DesignTest dt = new DesignTest();
		new DesignTest(); //익명으로 객체생성 - 메소드를 호출할 일 없이 생성자만 호출할때 사용
	}
}
