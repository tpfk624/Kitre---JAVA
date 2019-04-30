
public class myCircle extends myDohyung {
	
	int radius;
	
	public myCircle(int radius) {
		this.radius = radius;
	}
	
	@Override
	public double getArea() {
		return Math.PI * radius * radius; 
	}
	
	@Override
	double getRound() {
		return Math.PI * 2 * radius;
	}

}
