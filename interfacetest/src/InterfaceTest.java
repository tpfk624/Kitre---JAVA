import java.awt.*;
import java.awt.event.*;

public class InterfaceTest extends Frame implements WindowListener, ActionListener { //�������� ���
	
	Button b1 = new Button("@������1@");
	

	public InterfaceTest(){
		super("InterfaceTest!!!!"); //����Ŭ���� ������ȣ��
		//setTitle("Is A Test!!!!"); 
		setLayout(new FlowLayout());
		//b.setLabel("������");  
		b1.setBackground(new Color(210, 255, 210));
		b1.setBackground(new Color(210, 255, 255));
		add(b1);
		setSize(400, 300); 
		setLocation(300, 200); 
		setVisible(true);
		
		//WindowListener w1 = new InterfaceTest(); �������� ����
		addWindowListener(this);
		b1.addActionListener(this);
	}
	//Implement�ϸ� �޼ҵ� �������̵� �ؾ��Ѵ�
	//�ƴ��Ͱ� ������ �������̽��� ��� �� �ؾ��Ѵ�.
	public void windowDeactivated(WindowEvent e){}
	public void windowActivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowClosing(WindowEvent e){System.exit(0);}
	public void windowOpened(WindowEvent e){}
	
	//�����س� �޼ҵ尡 �ϳ��̸� ��� �������
	public void actionPerformed(ActionEvent e){
		int r = (int)(Math.random() * 256);
		int g = (int)(Math.random() * 256);
		int b = (int)(Math.random() * 256);
		setBackground(new Color(r, g, b));
	}

	public static void main(String[] args) {
		InterfaceTest iat = new InterfaceTest();
	}
}
