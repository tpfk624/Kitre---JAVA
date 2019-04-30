package constructor;

public class Car {
	
	//�������� - ��ü�������� ��밡��
	String carName;
	String color;
	String maker;
	int speed;
	
	public Car() {				//default������ //������ �ʱ�ȭ       
		/*
		carName = "�Ÿ";
		color = "������";
		maker = "����";
		*/
		this("�Ÿ", "������", "����");
	}    

	public Car(String color) {				 		
		/*
		carName = "�Ÿ";
		this.color = color;  //�ڱ��ڽ��� ����
		maker = "����";
		*/
		this("�Ÿ", color, "����");
	}    

	public Car(String carName, String color) {	
		/*
		carName = cn;
		color = c;
		maker = "����";
		*/
		this(carName, color, "����");
	}
	
	public Car(String carName, String color, String maker) {			
		this.carName = carName;
		this.color = color;
		this.maker = maker;
	}    

	void speedUp() {    
		speed += 10;
	}

	int speedUp(int speed) {    
		this.speed += speed;
		return this.speed;
	}

	void speedDown(){  
		speed -= 10;
		if(speed < 0)        
			stop();          
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

	String info(){
		return "���̸�: " + carName + "  ����: " + color + " ������: "  + maker;
	}
}
