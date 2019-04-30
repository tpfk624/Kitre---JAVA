package constructor;

/*
1. 반지름 radius
2.	넓이: calcArea()  
	둘레: calcRound() 

생성자2개
*/
public class Circle {
	int radius;
	//double calcArea;
	//double calcRound;


	public Circle(){
		this(4);
	}

	public Circle(int radius){
		this.radius = radius;
	}

	double calcAreaUp(){
		//return 3.14 * radius * radius;
		return Math.PI * radius * radius;
	}

	double calcRoundUp(){
		//return 3.14 * 2 * radius;
		return Math.PI * 2 * radius;
	}

}
