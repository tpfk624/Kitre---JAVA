public class CarUser {
	public static void main(String[] args) {
		Car car1 = new Car();  //new Car() ȣ�� �� �����ڰ� �޸𸮿� �ö� 
		System.out.println(car1); 
 
		Car car2 = new Car("���"); 
		System.out.println(car2); 

		Car car3 = new Car("�׷���", "���"); //ȣ�� �� ���� ���Ѿ��� 
		System.out.println(car3); 
		
		Car car4 = new Car("k5", "����", "���"); //ȣ�� �� ���� ���Ѿ��� 
		System.out.println(car4); 

		System.out.println("car4�� �ӵ��� 3ȸ ����!!!");
		for(int i = 0; i <3; i++)
			car4.speedUp(i);
		System.out.println("car4�� �ӵ�: " + car4.speed);

		System.out.println("car4�� �ӵ��� 85 ����!!!");
		int speed = car4.speedUp(85);
		System.out.println("car4�� �ӵ�: " + speed);
		System.out.println("car4�� �ӵ�: " + car4.speed);
	}
}


