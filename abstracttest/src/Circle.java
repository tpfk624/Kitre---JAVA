public class Circle extends Dohyung{

	int radius;
	

	public Circle(int radius){
		this.radius = radius;	
	}
	
	@Override
	public double getArea(){
		return 3.14 * radius * radius;
	}
	
	@Override
	public double getRound(){
		return 3.14 * 2 * radius;
	}
}
