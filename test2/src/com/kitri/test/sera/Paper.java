package com.kitri.test.sera;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Paper extends JFrame {

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
					Paper frame = new Paper();
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
	public Paper() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 371, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(12, 10, 331, 242);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("From : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 14, 57, 42);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBackground(Color.ORANGE);
		textField.setBounds(207, 23, 88, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.ORANGE);
		textField_1.setColumns(10);
		textField_1.setBounds(62, 23, 88, 26);
		panel.add(textField_1);
		
		JLabel lblTo = new JLabel("To : ");
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo.setBounds(160, 14, 57, 42);
		panel.add(lblTo);
		
		JTextArea letter = new JTextArea();
		letter.setBounds(12, 59, 307, 138);
		panel.add(letter);
		
		JButton send = new JButton("\uBCF4\uB0B4\uAE30");
		send.setBounds(53, 207, 97, 23);
		panel.add(send);
		
		JButton cancel = new JButton("\uCDE8\uC18C");
		cancel.setBounds(166, 207, 97, 23);
		panel.add(cancel);
	}
}
