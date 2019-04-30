import java.awt.*;

public class IsATest extends Frame{ //프레임을 상속
	
	Button b1 = new Button("@눌러봐1@");
	Button b2 = new Button("@눌러봐2@");
	Button b3 = new Button("@눌러봐3@");
	Checkbox c = new Checkbox("선택");

	public IsATest(){
		super("Is A Test!!!!"); //상위클래스 생성자호출
		//setTitle("Is A Test!!!!"); 
		setLayout(new FlowLayout());
		//b.setLabel("눌러봐");  
		b1.setBackground(new Color(210, 255, 210));
		c.setBackground(new Color(210, 255, 255));
		add(b1);
		add(b2);
		add(b3);
		add(c);
		setSize(400, 300); 
		setLocation(300, 200); 
		setVisible(true);
	}

	public static void main(String[] args) {
		IsATest iat = new IsATest();
	}
}
