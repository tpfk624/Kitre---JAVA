package com.kitri.test;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JTable;

public class View2 extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public View2() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(24, 24, 164, 23);
		add(btnNewButton);
		
		JList list = new JList();
		list.setBounds(87, 115, 1, 1);
		add(list);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(24, 57, 164, 202);
		add(textArea);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(224, 24, 121, 23);
		add(rdbtnNewRadioButton);
		
		table = new JTable();
		table.setBounds(248, 87, 1, 1);
		add(table);

	}
}
