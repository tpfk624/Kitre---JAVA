public class DohyungTest {
	public static void main(String[] args) {
		Rect r1 = new Rect(4, 5);
		System.out.println("가로가 " + r1.width + "이고 세로가 " + r1.height + 
				"인 사각형의 넓이는 " + r1.getArea() + " 둘레는 " + r1.getRound() + "입니다.");

		Circle c1 = new Circle(4);
		System.out.println("반지름이 " + c1.radius + "인 원의 넓이는 " + c1.getArea() + " 둘레는 " + c1.getRound() + "입니다.");

		//Dohyung d = new Dohyung(); 오류남 
		Dohyung d1 = new Rect(5, 7); //d1은 dohyung를 가리킨다
		System.out.println("도형의 넓이는 " + d1.getArea() + " 둘레는 " + d1.getRound() + "입니다.");
		
		//Rect r2 = d1; 오류남(상위를 하위에 넣을 수는 없다)
		Rect r2 = (Rect) d1; //rect를 가리킴
		System.out.println("가로가 " + r2.width + "이고 세로가 " + r2.height + 
				"인 사각형의 넓이는 " + r2.getArea() + " 둘레는 " + r2.getRound() + "입니다.");
		
		Circle c2 = (Circle) d1; //문법적으로만 가능
	}
}
