package com.kitri.test;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton b1;
	private JButton b2;
	JPanel panel = new JPanel();
	
	View1 v1 = new View1();
	View2 v2 = new View2();
	
	CardLayout card = new CardLayout();//카드레이아웃객체 바깥에 만들기

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//JPanel panel = new JPanel(); 전역변수로 꺼내기
		panel.setLayout(card);
		panel.add("view1", v1);
		panel.add("view2", v2);
		card.show(panel, "view2");//시작하자마자 보여라 
		panel.setBounds(12, 55, 412, 367);
		contentPane.add(panel);
		
		b1 = new JButton("\uD654\uBA741");
		b1.setBounds(12, 10, 78, 35);
		contentPane.add(b1);
		
		b2 = new JButton("\uD654\uBA742");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b2.setBounds(102, 10, 85, 35);
		contentPane.add(b2);
		
		//이벤트등록
		b1.addActionListener(this);
		b2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == b1) {
			card.show(panel, "view1");
		}else if(ob == b2) {
			card.show(panel, "view2");
		}
		
	}

}
