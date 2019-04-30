package mygraphic;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GraphicExample2 {
	public static void main(String args[]) {
		JFrame frame = new JFrame("성적 그래프 프로그램");
		frame.setLocation(500, 200);
		frame.setPreferredSize(new Dimension(400, 350));
		Container contentPane = frame.getContentPane();

		DrawingPanel drawingPanel = new DrawingPanel();
		contentPane.add(drawingPanel, BorderLayout.CENTER);
		// 그래프를 그릴 패널

		JPanel controlPanel = new JPanel();
		JTextField text1 = new JTextField(3);
		JTextField text2 = new JTextField(3);
		JTextField text3 = new JTextField(3);
		JButton button = new JButton("그래프 그리기");
		controlPanel.add(new JLabel("국어"));
		controlPanel.add(text1);
		controlPanel.add(new JLabel("영어"));
		controlPanel.add(text2);
		controlPanel.add(new JLabel("수학"));
		controlPanel.add(text3);
		controlPanel.add(button);
		contentPane.add(controlPanel, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.addActionListener(new DrawActionListener(text1, text2, text3, drawingPanel));
		// "그래프 그리기" 버튼을 눌렀을때 작동 할 리스터등록
		frame.pack();
		frame.setVisible(true);
	}
}
