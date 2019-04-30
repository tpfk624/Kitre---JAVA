import java.awt.*;

public class HasATest {
	
	Frame f = new Frame("Has A Test!!!!");
	Button b = new Button("@눌러봐@");

	public HasATest(){
		//f.setTitle("Has A Test!!!!"); //제목
		f.setLayout(new FlowLayout());
		//b.setLabel("눌러봐");  //버튼이름
		f.add(b);
		f.setSize(400, 300); 
		f.setLocation(300, 200); //창위치
		f.setVisible(true);
	}

	public static void main(String[] args) {
		HasATest hat = new HasATest();
	}
}





