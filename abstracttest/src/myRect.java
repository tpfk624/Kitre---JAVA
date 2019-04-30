
public class myRect extends myDohyung {
	
	int width;
	int height;
	
	public myRect(int width, int height) {
			this.width = width;
			this.height = height;
	}

	@Override
	double getArea() {
		return width * height;
	}
	
	@Override 
	double getRound() {
		return 2 * width * height;
	}
	
	

}
