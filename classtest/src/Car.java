public class Car {
	
	//�������� - ��ü�������� ��밡��
	String carName;
	String color;
	String maker;
	int speed;
	
	//public Car() {}    //default�����ڰ� ���������� ��������
	

	//�޼ҵ��
	//�ӵ��� +10�߰��̰ų� -10����
	public void speedUp() {    //�Ѱ��ٰ��� ��� void 
		speed += 10;
	}

	public void speedDown(){  //int���� ����
		speed -= 10;
		if(speed < 0)         //if���̳� for�� �����϶��� {}��������
			stop();           //���� Ŭ�����ȿ��� �޼ҵ�ȣ��  //������ �޼ҵ�� ���� Ŭ������������ . �Ƚᵵ ��
	}

	public void stop(){ //stop�� ������ void�� ��ȭ�ϴ� ���� �����ϱ�
		speed = 0;
	}
}
