public class Car {
	
	//�������� - ��ü�������� ��밡��
	String carName;
	String color;
	String maker;
	int speed;
	
	public Car() {				//default������ //������ �ʱ�ȭ 
		//super(); this()�� ù�ٿ� �����ؼ� super�� ���� �� ����.
		this("�Ÿ", "������", "����");
	}    

	public Car(String color) {
		//super(); this()�� ù�ٿ� �����ؼ� super�� ���� �� ����.
		this("�Ÿ", color, "����");
	}    

	public Car(String carName, String color) {	
		this(carName, color, "����");
	}
	
	public Car(String carName, String color, String maker) {
		//super(); �׻� �����Ǿ� ����
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
		return maker + "���� ���� " + color + " " + carName;
	}

	@Override
	public boolean equals(Object obj){  //equals�� ī�� �°� �������̵�
		Car car = (Car) obj;  //������ ������ �ִ°��̹Ƿ� ������ ������ ����ȯ�Ѵ�.
		//carName = string= objdect (object�� == �񱳰� �ȵȴ�)������
		//if(carName == car.carName) // ""�� ���� true, new String("")�� ���� false�̹Ƿ� �����ϸ� equals������
		if(carName.equals(car.carName))    
			return true;
		return false;
	}

}
