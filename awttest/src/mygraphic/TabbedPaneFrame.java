package mygraphic;

import javax.swing.*;
import java.awt.*;

public class TabbedPaneFrame extends JFrame {
	public TabbedPaneFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createTabbedPane();
		setSize(300, 300);
		setVisible(true);
	}

	void createTabbedPane() {
		JTabbedPane tPane = new JTabbedPane();
		add(tPane);
		tPane.addTab("박지연", new JLabel(new ImageIcon("images/back.jpg")));
		tPane.addTab("함은정", new JLabel(new ImageIcon("images/kwak.jpg")));
		// tPane.addTab("티아라", new JPanel(new SnakeFrame.GroundPanel()));
	}

	public static void main(String args[]) {
		new TabbedPaneFrame();
	}
}
