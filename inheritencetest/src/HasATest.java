import java.awt.*;

public class HasATest {
	
	Frame f = new Frame("Has A Test!!!!");
	Button b = new Button("@������@");

	public HasATest(){
		//f.setTitle("Has A Test!!!!"); //����
		f.setLayout(new FlowLayout());
		//b.setLabel("������");  //��ư�̸�
		f.add(b);
		f.setSize(400, 300); 
		f.setLocation(300, 200); //â��ġ
		f.setVisible(true);
	}

	public static void main(String[] args) {
		HasATest hat = new HasATest();
	}
}





