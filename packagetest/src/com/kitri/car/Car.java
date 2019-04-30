package com.kitri.car;

public class Car {

	private String name; //default는 패키지내에서만 사용가능//그러나 필드값은 보통public x
	private String color;
	private String maker;
	private int speed;

	public Car(String name) {
		super();
		this.name = name;
	}

	public Car(String name, String color, String maker) {
		super();
		this.name = name;
		this.color = color;
		this.maker = maker;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + ", maker=" + maker + ", speed=" + speed + "]";
	} 
	
	
	
	
	
	
	
	

	
	

}
 