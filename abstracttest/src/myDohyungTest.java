public class myDohyungTest {
	public static void main(String[] args) {
		
		myRect r1 = new myRect(2, 5);
		System.out.println(r1.width + r1.height + r1.getArea() + r1.getRound());
		
		myCircle c1 = new myCircle(5);
		System.out.println(c1.radius + c1.getArea() + c1.getRound());
	}
}
