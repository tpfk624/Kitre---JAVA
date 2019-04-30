package com.kitri.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class BaseBall extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaseBall frame = new BaseBall();
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
	public BaseBall() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\uC785\uB825");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 365, 45, 27);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(58, 365, 313, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(383, 10, 95, 382);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(5, 1, 0, 10));
		
		JButton newG = new JButton("\uC0C8\uAC8C\uC784");
		newG.setBackground(Color.YELLOW);
		newG.setForeground(Color.BLACK);
		newG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(newG);
		
		JButton delete = new JButton("\uC9C0\uC6B0\uAE30");
		delete.setBackground(Color.PINK);
		panel.add(delete);
		
		JButton btnNewButton_3 = new JButton("\uC815\uB2F5");
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\uAE00\uC790\uC0C9");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_1 = new JButton("\uC885\uB8CC");
		panel.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(92, 77, 2, 2);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 10, 360, 346);
		contentPane.add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
	}
}
