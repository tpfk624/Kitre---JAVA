package com.kitri.awt.design;

import java.awt.*;

public class BaseBallTest extends Frame {
	//������
	
	//�г�3��
	Panel pC = new Panel();
	Panel pCS = new Panel();
	Panel pE = new Panel();

	TextArea ta = new TextArea();
	Label l = new Label("����");
	TextField tf = new TextField();
	
	Button newG = new Button("������");
	Button clear = new Button("�����");
	Button dap = new Button("����");
	Button fontC = new Button("���ڻ�");
	Button exit = new Button("����");
	
	

	
	public BaseBallTest() {
		super("���ھ߱�����");
		//��ġ��
	
		//���� �Ʒ�
		pCS.setLayout(new BorderLayout(10, 0));
		pCS.add(l, "West");
		pCS.add(tf, "Center");

		
		//���� ��ġ��
		pC.setLayout(new BorderLayout(0, 10));
		pC.add(ta, "Center");
		pC.add(pCS, "South");
		
		//������ ����
		pE.setLayout(new GridLayout(5,1));
		pE.add(newG);
		pE.add(clear);
		pE.add(dap);
		pE.add(fontC);
		pE.add(exit);
		
		//���� ��ġ��
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
