package com.kitri.awt.event;
import java.awt.*;
public class Calculator extends Frame {
     //생성부
     
	//참고
	int op;// 연산자 구분 번호로 +는1, -는 2, *는 3, /는 4
	double buffer;// 숫자 저장소
	
     //패널 2개
     Panel p1 = new Panel();
     Panel p2 = new Panel();
     
     Label numL = new Label();  //숫자만 뜨게 만들기
     Label operL = new Label(); //연산자만 뜨게 만들기
     
     String[] bstr = {"7", "8", "9", "+","4", "5", "6","-","1",  "2" , "3", "*", "0", "C" , "=", "/"};
     Button btn[] = new Button[16]; //선언
     
     Button exit = new Button("종료");
     
     Color color = new Color(255, 178, 217);
     Color color2 = new Color(250, 224, 212);
     Font f = new Font("굴림", Font.BOLD, 20);
     
     //계산기컨트롤러 호출
     CalculatorController calculatorController;

     
     public Calculator() {
           //배치부
           
           //위
           p1.setLayout(new BorderLayout());
           p1.add(numL, "Center");
           p1.add(operL, "East");
           
           numL.setFont(f);
           operL.setFont(f);
           numL.setBackground(color.white);
           operL.setBackground(color.yellow);
      
          
           
           //중간 배열 숫자부분
           p2.setLayout(new GridLayout(4,4));
           for (int i = 0; i < btn.length; i++) {
                p2.add(btn[i] = new Button(bstr[i])); //생성
                btn[i].setFont(f);
                btn[i].setBackground(color2);
           }
           

           
           //최종합치기
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