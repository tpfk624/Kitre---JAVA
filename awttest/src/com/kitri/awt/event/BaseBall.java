package com.kitri.awt.event;

import java.awt.*;

public class BaseBall extends Frame {
	//������
	
	//�г�3��
	Panel pC = new Panel();
	Panel pCS = new Panel();
	Panel pE = new Panel();

	TextArea ta = new TextArea();
	Label l = new Label("�Է�");
	TextField tf = new TextField();
	
	Button newG = new Button("������");
	Button clear = new Button("�����");
	Button dap = new Button("����");
	Button fontC = new Button("���ڻ�");
	Button exit = new Button("����");
	
	//���̽�������ѷ� ȣ��, ��Ʈ�÷�ȣ��
	BaseBallController baseballController;
	FontColorChooser fontColorChooser = new FontColorChooser(); //has a����ϱ� �����̴� / is a = ���

	
	public BaseBall() {
		super("���ھ߱�����");
		//��ġ��
	
		//���� �Ʒ�
		pCS.setLayout(new BorderLayout(10, 0));
		pCS.add(l, "West");
		pCS.add(tf, "Center");

		
		//���� ��ġ��
		pC.setLayout(new BorderLayout(0, 10));
		pC.add(pCS, "South");
		ta.setEditable(false);
		//ta.setEnabled(false);
		//ta.setFont(f);
		pC.add(ta, "Center");
		
		
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
		
		setBounds(300, 200, 500, 400);
		setVisible(true);	
		
		baseballController = new BaseBallController(this); //�ڱ��ڽ��ǰ�ü �����ֱ�
		
		//BaseBallâ �̺�Ʈ ���
		tf.addActionListener(baseballController); //�������ֱ�
		newG.addActionListener(baseballController);
		clear.addActionListener(baseballController);
		dap.addActionListener(baseballController);
		fontC.addActionListener(baseballController);
		exit.addActionListener(baseballController);
		
		//�߰�(xâ������ �ݱ� ���α׷�����)
		this.addWindowListener(baseballController);
		
		//FontColorChooser �̺�Ʈ ���			
		fontColorChooser.sbR.addAdjustmentListener(baseballController);
		fontColorChooser.sbG.addAdjustmentListener(baseballController);
		fontColorChooser.sbB.addAdjustmentListener(baseballController);
		
		//FontColorChooser-��ư  �̺�Ʈ���
		fontColorChooser.ok.addActionListener(baseballController);
		
		//FontColorChooser xâ������ �ݱ⸦ ����ٰ� �ϸ� �� �����ϱ� ���⼭ �������� xxx
		//fontColorChooser.addWindowListener(baseballController);//�̰��ϸ� ���α׷��� ��������
		
	}
	
	public static void main(String[] args) {
		new BaseBall();

	}

}
