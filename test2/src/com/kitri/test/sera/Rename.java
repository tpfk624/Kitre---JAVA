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
import javax.swing.JButton;

public class Rename extends JFrame {

	private JPanel contentPane;
	private JTextField newname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rename frame = new Rename();
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
	public Rename() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 379, 205);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel oldname = new JPanel();
		oldname.setBackground(new Color(204, 204, 255));
		oldname.setBorder(new LineBorder(new Color(0, 0, 0)));
		oldname.setBounds(12, 10, 339, 147);
		contentPane.add(oldname);
		oldname.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Old Name :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(24, 20, 92, 25);
		oldname.add(lblNewLabel);
		
		JLabel lblName = new JLabel("New Name :");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(24, 65, 92, 25);
		oldname.add(lblName);
		
		newname = new JTextField();
		newname.setBounds(119, 62, 184, 31);
		oldname.add(newname);
		newname.setColumns(10);
		
		JButton ok = new JButton("\uBCC0 \uACBD");
		ok.setBounds(64, 114, 97, 23);
		oldname.add(ok);
		
		JButton cancel = new JButton("\uCDE8 \uC18C");
		cancel.setBounds(173, 114, 97, 23);
		oldname.add(cancel);
	}

}
