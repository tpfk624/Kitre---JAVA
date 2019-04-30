package com.kitri.test.sera;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField ipTF;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 251);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setForeground(Color.BLACK);
		panel.setBounds(12, 10, 360, 193);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("I    P");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(26, 32, 93, 42);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("\uB300\uD654\uBA85");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(26, 84, 93, 27);
		panel.add(label);
		
		ipTF = new JTextField();
		ipTF.setBounds(131, 40, 192, 27);
		panel.add(ipTF);
		ipTF.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(131, 84, 192, 27);
		panel.add(textField);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setForeground(Color.BLACK);
		panel_1.setBounds(12, 141, 336, 42);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton ok = new JButton("\uD655\uC778");
		ok.setBounds(63, 10, 97, 23);
		panel_1.add(ok);
		
		JButton cancle = new JButton("\uCDE8\uC18C");
		cancle.setBounds(172, 10, 97, 23);
		panel_1.add(cancle);
	}
}
