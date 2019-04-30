public class Car {
	
	//전역변수 - 전체영역에서 사용가능
	String carName;
	String color;
	String maker;
	int speed;
	
	public Car() {				//default생성자 //생성자 초기화 
		//super(); this()는 첫줄에 들어가야해서 super가 있을 수 없다.
		this("쏘나타", "검정색", "현대");
	}    

	public Car(String color) {
		//super(); this()는 첫줄에 들어가야해서 super가 있을 수 없다.
		this("쏘나타", color, "현대");
	}    

	public Car(String carName, String color) {	
		this(carName, color, "현대");
	}
	
	public Car(String carName, String color, String maker) {
		//super(); 항상 생략되어 있음
		this.carName = carName;
		this.color = color;
		this.maker = maker;
	}    

	int speedUp(int speed) {    
		this.speed += speed;
		return this.speed;
	}

	int speedDown(int speed) {    
		speed -= speed;
		if(this.speed < 0)         
			stop();
		return this.speed;
	}

	void stop(){ 
		speed = 0;
	}

	@Override
	public String toString() {   //info -> toString
		return maker + "에서 만든 " + color + " " + carName;
	}

	@Override
	public boolean equals(Object obj){  //equals를 카에 맞게 오버라이딩
		Car car = (Car) obj;  //상위를 하위로 넣는것이므로 상위를 하위로 형변환한다.
		//carName = string= objdect (object는 == 비교가 안된다)이지만
		//if(carName == car.carName) // ""일 경우는 true, new String("")일 경우는 false이므로 가능하면 equals사용권장
		if(carName.equals(car.carName))    
			return true;
		return false;
	}

}
