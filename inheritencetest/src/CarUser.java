public class CarUser {
	public static void main(String[] args) {
		Car car1 = new Car();  //new Car() 호출 시 생성자가 메모리에 올라감 
		System.out.println(car1); 
 
		Car car2 = new Car("흰색"); 
		System.out.println(car2); 

		Car car3 = new Car("그랜저", "흰색"); //호출 시 순서 지켜야함 
		System.out.println(car3); 
		
		Car car4 = new Car("k5", "은색", "기아"); //호출 시 순서 지켜야함 
		System.out.println(car4); 

		System.out.println("car4의 속도를 3회 증가!!!");
		for(int i = 0; i <3; i++)
			car4.speedUp(i);
		System.out.println("car4의 속도: " + car4.speed);

		System.out.println("car4의 속도를 85 증가!!!");
		int speed = car4.speedUp(85);
		System.out.println("car4의 속도: " + speed);
		System.out.println("car4의 속도: " + car4.speed);
	}
}


