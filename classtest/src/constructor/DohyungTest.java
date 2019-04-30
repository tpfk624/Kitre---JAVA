package constructor;

public class DohyungTest {
	public static void main(String[] args) {
		//1.가로가 4이고 세로가 3인 사각형의 넓이는 12이고 둘레는 14입니다.
		Rect r1 = new Rect();
		double area = r1.calcArea();
		double round = r1.calcRound();
		System.out.println("가로가 " + r1.width + " 세로가 " + r1.height + "인 사각형의 넓이는 " + area + "이고 둘레는 " + round); 
		

		//2.가로가 _이고 세로가 _인 사각형의 넓이는 _이고 둘레는 _입니다.
		Rect r2 = new Rect(5,6); 
	
		area = r2.calcArea();
		round = r2.calcRound();
		System.out.println("가로가 " + r2.width + "세로가 " + r2.height + "인 사각형의 넓이는 " + area + "이고 둘레는 " + round); 
		
		
		//3.반지름이 4인 원의 넓이는 48.xxx이고 둘레는 24.xxx입니다.
		Circle c1 = new Circle();
		area = c1.calcAreaUp();
		round = c1.calcRoundUp();

		System.out.println("반지름이 " + c1.radius + "인 원의 넓이는 " + area + "이고 둘레는 " + round); 
		

		//4.반지름이 _인 원의 넓이는 _이고 둘레는 _입니다.
		Circle c2 = new Circle(13); 
		
		area = c2.calcAreaUp();
		round = c2.calcRoundUp();
		System.out.println("반지름이 " + c2.radius + "인 원의 넓이는 " + area+ "이고 둘레는 " + round); 
	}
}
