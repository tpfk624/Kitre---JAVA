package com.kitri.test;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class View1 extends JPanel {

	/**
	 * Create the panel.
	 */
	public View1() {
		setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel = new JPanel();
		add(panel);
		
		JButton btnNewButton_1 = new JButton("1\uBC88 \uC0C8\uC6B0\uAE61");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("2\uBC88 \uC591\uD30C\uB9C1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("3\uBC88 \uAF2C\uBD81\uCE69");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("4\uBC88 \uCD08\uCF54\uBE44");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_3);
		
	}

}

//패널은 단독적으로 보이지않아 메인이 없다
