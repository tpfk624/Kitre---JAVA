public class Car {
	
	//전역변수 - 전체영역에서 사용가능
	String carName;
	String color;
	String maker;
	int speed;
	
	//public Car() {}    //default생성자가 내부적으로 숨어있음
	

	//메소드들
	//속도는 +10중가이거나 -10감소
	public void speedUp() {    //넘겨줄값이 없어서 void 
		speed += 10;
	}

	public void speedDown(){  //int여도 가능
		speed -= 10;
		if(speed < 0)         //if문이나 for문 한줄일때는 {}생략가능
			stop();           //같은 클래스안에서 메소드호출  //변수나 메소드는 같은 클래스내에서는 . 안써도 됨
	}

	public void stop(){ //stop은 무조건 void다 변화하는 값이 없으니까
		speed = 0;
	}
}
