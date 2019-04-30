package mygraphic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

//��ư �������� �����ϴ� ������
class DrawActionListener implements ActionListener {
	JTextField text1, text2, text3;
	DrawingPanel drawingPanel;

	DrawActionListener(JTextField text1, JTextField text2, JTextField text3, DrawingPanel drawingPanel) {
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
		this.drawingPanel = drawingPanel;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			int korean = Integer.parseInt(text1.getText());
			int english = Integer.parseInt(text2.getText());
			int math = Integer.parseInt(text3.getText());
			drawingPanel.setScores(korean, english, math);
			drawingPanel.repaint();
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(drawingPanel, "�߸��� ���� �Է��Դϴ�", "�����޽���", JOptionPane.ERROR_MESSAGE);
		}
	}
}
