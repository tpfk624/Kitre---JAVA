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

  setSize(400, 400); // �������� ũ�⸦ 400,400���� ����

  setVisible(true);

  this.addWindowListener(new WindowAdapter() { // �ݱ�â Ȱ��ȭ

   public void windowClosing(WindowEvent e) { // �ݱ�â�� Ŭ���ϸ�

    System.exit(0); // ����

   }

  });




 }




 public static void main(String[] args) {

  new graph("�׷���");

 }




 class XCanvas extends Canvas {

  int y;




  public void paint(Graphics g) {




   g.drawLine(0, 300, 500, 300); // x�� ���(0,300���� 500,300���� �׸���.)

   g.setColor(Color.blue);  //���� ������ blue�� ����

   for (int x = 0; x <= 360; x++) {  //y = x-5�׷����� �׸�

    y = x - 5;

    g.drawLine(x, y, x, y); //���

   }




  }

 }

}
