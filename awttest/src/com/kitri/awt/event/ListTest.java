package com.kitri.awt.event;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListTest extends Frame implements ActionListener {
	//선언부
	
	//패널3개
	Panel p1 = new Panel();
	Panel p2 = new Panel();
	Panel p3 = new Panel();
	//Panel p4 = new Panel();
	
	List listL = new List();
	List listR = new List(10, true);
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
		p1.setLayout(new BorderLayout());
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
		
		//이벤트감시자등록
		tfL.addActionListener(this);
		tfR.addActionListener(this);
		btL.addActionListener(this);
		btLAll.addActionListener(this);
		btR.addActionListener(this);
		btRAll.addActionListener(this);
		
	}
	
	//----------------이벤트부분------------------
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == tfL) {
//			1.tfL의 값 get(유효성검사)
			String tmp = tfL.getText().trim();//+공백제거
			tfL.setText("");//전에 쳤던거 사라지게 빈것처럼 지정
			if(tmp.isEmpty())
				return;//다시 가서 감시하라
//			2.listL에 추가
			listL.add(tmp);
			
		}else if(ob == tfR) {
//			1.tfR의 값 get
			String tmp = tfR.getText().trim();
			tfR.setText("");
			if(tmp.isEmpty())
				return;
//			2.listR에 추가
			listR.add(tmp);
			
		}else if(ob == btL) {
//			1.listR에서 선택한 문자열get
			String tmp = listR.getSelectedItem();
			if(tmp == null)//유효성검사
				return;
//			2.1의 값을 listL에 추가
			listL.add(tmp);
//			3.1의 값을 listR에서 제거
			listR.remove(tmp);
			
		}else if(ob == btLAll) {
			//고른거 몇개만 이동하는걸로 소스만들어보기
//			1.listR의 값을 모두 get
			String tmp[] = listR.getSelectedItems();
//			2.1값을 listL에 모두 추가
			int len = tmp.length;
			for (int i = 0; i < len; i++) {
				listL.add(tmp[i]);
			}
//			3.1의 값을 listL에서 모두 제거
			for (int i = len-1; i >= 0; i--) { //나중에 짤 줄 알아야함
				listR.remove(tmp[i]);
			}

			
		}else if(ob == btR) {
//			1.listL에서 선택한 문자열get
			String tmp = listL.getSelectedItem();
			if(tmp == null)//유효성검사
				return;
//			2.1의 값을 listR에 추가
			listR.add(tmp);
//			3.1의 값을 listL에서 제거
			listL.remove(tmp);
			
		}else if(ob == btRAll) {
//			1.listL의 값을 모두 get
			String tmp[] = listL.getItems();
//			2.1값을 listR에 모두 추가
			int len = tmp.length;
			for (int i = 0; i < len; i++) {
				listR.add(tmp[i]);
			}
//			3.1의 값을 listL에서 모두 제거
//			for (int i = len-1; i >= 0; i--) { //나중에 짤 줄 알아야함
//				listL.remove(i);
//			}
			listL.removeAll();
		}
		
		
		
	}


	public static void main(String[] args) {
		new ListTest();
	}


}
