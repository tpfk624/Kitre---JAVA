package com.kitri.awt.event;
import java.awt.*;
public class Calculator extends Frame {
     //������
     
	//����
	int op;// ������ ���� ��ȣ�� +��1, -�� 2, *�� 3, /�� 4
	double buffer;// ���� �����
	
     //�г� 2��
     Panel p1 = new Panel();
     Panel p2 = new Panel();
     
     Label numL = new Label();  //���ڸ� �߰� �����
     Label operL = new Label(); //�����ڸ� �߰� �����
     
     String[] bstr = {"7", "8", "9", "+","4", "5", "6","-","1",  "2" , "3", "*", "0", "C" , "=", "/"};
     Button btn[] = new Button[16]; //����
     
     Button exit = new Button("����");
     
     Color color = new Color(255, 178, 217);
     Color color2 = new Color(250, 224, 212);
     Font f = new Font("����", Font.BOLD, 20);
     
     //������Ʈ�ѷ� ȣ��
     CalculatorController calculatorController;

     
     public Calculator() {
           //��ġ��
           
           //��
           p1.setLayout(new BorderLayout());
           p1.add(numL, "Center");
           p1.add(operL, "East");
           
           numL.setFont(f);
           operL.setFont(f);
           numL.setBackground(color.white);
           operL.setBackground(color.yellow);
      
          
           
           //�߰� �迭 ���ںκ�
           p2.setLayout(new GridLayout(4,4));
           for (int i = 0; i < btn.length; i++) {
                p2.add(btn[i] = new Button(bstr[i])); //����
                btn[i].setFont(f);
                btn[i].setBackground(color2);
           }
           

           
           //������ġ��
           setLayout(new BorderLayout(0,5));
           add(p1, "North");
           add(p2, "Center");
           add(exit, "South");
           
           exit.setFont(f);
           exit.setBackground(color);
           
           setBounds(300, 200, 300, 300);
           setVisible(true);
           
           calculatorController = new CalculatorController(this);
           
           exit.addActionListener(calculatorController);
           for (int i = 0; i < 16; i++) {
                btn[i].addActionListener(calculatorController);
           }
           
           
     }
     
     
     
     public static void main(String[] args) {
           new Calculator();
     }
}