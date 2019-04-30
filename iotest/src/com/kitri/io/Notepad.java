package com.kitri.io;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class Notepad extends JFrame implements ActionListener{

	private JPanel contentPane;

//	FileDialog fd = new FileDialog();
	
	JMenuBar mb = new JMenuBar();
	JMenu file = new JMenu("\uD30C\uC77C");
	JMenuItem open = new JMenuItem("\uC5F4\uAE30");
	JMenuItem save = new JMenuItem("\uC800\uC7A5");
	JMenuItem exit = new JMenuItem("\uC885\uB8CC");
	JMenu help = new JMenu("\uB3C4\uC6C0\uB9D0");
	
	JPanel editor = new JPanel();
	private final JTextArea textArea = new JTextArea();
	
	

	public Notepad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		editor.setBounds(12, 10, 410, 242);
		contentPane.add(editor);
		editor.setLayout(null);
		
		mb.setBounds(0, 0, 410, 21);
		editor.add(mb);
		
		mb.add(file);
		file.add(open);
		file.add(save);
		file.add(exit);
		mb.add(help);
		textArea.setBounds(0, 22, 410, 220);
		
		editor.add(textArea);
		
		
		file.addActionListener(this);
		open.addActionListener(this);
		save.addActionListener(this);
		exit.addActionListener(this);
		help.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == open) {
			FileDialog fd = new FileDialog(this, "파일열기", FileDialog.LOAD);
			//BufferedReader in = new BufferedReader(new InputStreamReader(fd)); 
			try {
				String infile = in.readLine();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			fd.setVisible(true);
		}else if(ob == save) {
			FileDialog fd = new FileDialog(this, "파일저장", FileDialog.SAVE);
			fd.setVisible(true);
		}else if(ob == exit) {
			System.exit(0);
		}
	
	}
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotepadT frame = new NotepadT();
					FileDialog fd = new FileDialog(frame);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
