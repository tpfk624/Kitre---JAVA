package constructor;

/*
1. ������ radius
2.	����: calcArea()  
	�ѷ�: calcRound() 

������2��
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
