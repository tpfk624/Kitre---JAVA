package mygraphic;

import java.awt.Canvas;

import java.awt.Color;

import java.awt.Frame;

import java.awt.Graphics;

import java.awt.event.WindowAdapter;

import java.awt.event.WindowEvent;




class graph extends Frame {

 public graph(String title) {

  super(title);

  add(new XCanvas());

  setSize(400, 400); // 윈도우의 크기를 400,400으로 지정

  setVisible(true);

  this.addWindowListener(new WindowAdapter() { // 닫기창 활성화

   public void windowClosing(WindowEvent e) { // 닫기창을 클릭하면

    System.exit(0); // 종료

   }

  });




 }




 public static void main(String[] args) {

  new graph("그래프");

 }




 class XCanvas extends Canvas {

  int y;




  public void paint(Graphics g) {




   g.drawLine(0, 300, 500, 300); // x축 출력(0,300부터 500,300까지 그린다.)

   g.setColor(Color.blue);  //선의 색깔을 blue로 변경

   for (int x = 0; x <= 360; x++) {  //y = x-5그래프를 그림

    y = x - 5;

    g.drawLine(x, y, x, y); //출력

   }




  }

 }

}
