package com.kitri.awt.design;

import java.awt.*;

//1. Frame ���
//2. ����ο� �ʿ��� ��ü ����
//3. ��ġ�ο��� design(component��ġ)
//** �۾��� �� >> ��

public class DesignTest extends Frame{
	//�����
	Panel pN = new Panel(); //�Ϲ������� panel�� �⺻�����ڷ� ����°� ���ϴ�
	Panel pS = new Panel();
	
	Label l = new Label("�Է�", Label.CENTER);
	TextField tf = new TextField();
	Button send = new Button("����");
	
	TextArea ta = new TextArea();
	
	Choice ch = new Choice();
	Button exit = new Button("����");
	
	
	public DesignTest() { //������
		super("Design Test !!!"); //����ޱ�
		//��ġ��
		//1.setText("�Է�");//���� ��ü������ �Է��� ��� ���x
		
		//LayoutManager lm = new BorderLayout();
		pN.setLayout(new BorderLayout(10, 0));//hgap,vgap ������Ʈ�� ������Ʈ�� ��
		l.setBackground(new Color(210,150,150));//0~255
		//l.setForeground(new Color(255, 0, 0));
		l.setForeground(Color.BLUE);
		Font f = new Font("����", Font.BOLD, 20); //�������� ���� ������ ����
		l.setFont(f);
		pN.add(l, "West"); 
		pN.add(tf, "Center");
		send.setFont(f);
		pN.add(send, "East");
		
		pS.setLayout(new GridLayout(1, 2, 10, 0));//���������� ����
		ch.add("����");
		ch.add("���,��õ");
		ch.add("����");
		ch.add("��û");
		pS.add(ch);
		exit.setFont(f);
		pS.add(exit);
		
		setLayout(new BorderLayout(0, 10));//���Ʒ� vgap�����ϱ�
		add(pN, "North"); //�������� dl�� BorderLayout�̾ �׳�add
		add(ta, "Center");
		add(pS, BorderLayout.SOUTH);//�̷��Ե� ��밡��
		
	
		//setSize(300, 500); //������ũ������
		//setLocation(300, 200);//������ ��ġ ����
		setBounds(300, 200, 300, 500);//setSize + setLocation
		setResizable(false);//������ ���ٲٰ� ��
		setVisible(true);//�������� ���� ���̰��϶� //�׻� ��ġ�ο� �������� �ֱ�(���� �����ϰ� ���̴°� ����)
	}
	
	public static void main(String[] args) {
		//DesignTest dt = new DesignTest();
		new DesignTest(); //�͸����� ��ü���� - �޼ҵ带 ȣ���� �� ���� �����ڸ� ȣ���Ҷ� ���
	}
}
