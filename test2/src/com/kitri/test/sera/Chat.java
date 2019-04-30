package com.kitri.test.sera;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Chat extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat frame = new Chat();
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
	public Chat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 382);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221, 160, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(221, 160, 221));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(12, 10, 460, 326);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea area = new JTextArea();
		area.setBounds(12, 10, 301, 231);
		panel.add(area);
		
		JList list = new JList();
		list.setBounds(325, 10, 123, 191);
		panel.add(list);
		
		JButton rename = new JButton("\uB300\uD654\uBA85\uBCC0\uACBD");
		rename.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rename.setBounds(325, 211, 123, 30);
		panel.add(rename);
		
		JButton paper = new JButton("\uCABD\uC9C0\uBCF4\uB0B4\uAE30");
		paper.setBounds(325, 250, 123, 30);
		panel.add(paper);
		
		JButton close = new JButton("\uB098 \uAC00 \uAE30");
		close.setBounds(325, 290, 123, 30);
		panel.add(close);
		
		textField = new JTextField();
		textField.setBounds(12, 251, 301, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel whom = new JLabel("\uADD3\uC18D\uB9D0");
		whom.setHorizontalAlignment(SwingConstants.CENTER);
		whom.setBounds(12, 290, 57, 30);
		panel.add(whom);
		
		textField_1 = new JTextField();
		textField_1.setBounds(81, 290, 232, 30);
		panel.add(textField_1);
		textField_1.setColumns(10);
	}
}
