import java.awt.*;
import java.awt.event.*;

public class InterfaceTest extends Frame implements WindowListener, ActionListener { //프레임을 상속
	
	Button b1 = new Button("@눌러봐1@");
	

	public InterfaceTest(){
		super("InterfaceTest!!!!"); //상위클래스 생성자호출
		//setTitle("Is A Test!!!!"); 
		setLayout(new FlowLayout());
		//b.setLabel("눌러봐");  
		b1.setBackground(new Color(210, 255, 210));
		b1.setBackground(new Color(210, 255, 255));
		add(b1);
		setSize(400, 300); 
		setLocation(300, 200); 
		setVisible(true);
		
		//WindowListener w1 = new InterfaceTest(); 무한으로 생김
		addWindowListener(this);
		b1.addActionListener(this);
	}
	//Implement하면 메소드 오버라이딩 해야한다
	//아답터가 있지만 인터페이스는 모두 다 해야한다.
	public void windowDeactivated(WindowEvent e){}
	public void windowActivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowClosing(WindowEvent e){System.exit(0);}
	public void windowOpened(WindowEvent e){}
	
	//구현해낼 메소드가 하나이면 모두 적어야함
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
