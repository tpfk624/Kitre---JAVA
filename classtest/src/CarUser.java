public class CarUser {
	public static void main(String[] args) {
		Car car1 = null;    //선언 //Car의 주소값을 초기화  
		car1 = new Car();   //생성  //default생성자 숨어있음
		System.out.println("1. 차이름: " + car1.carName + "  색상: " + car1.color + " 제조사: "  + car1.maker ); //사용

		car1.carName = "쏘나타";
		car1.color = "검정색";
		car1.maker = "현대";
		System.out.println("1. 차이름: " + car1.carName + "  색상: " + car1.color + " 제조사: "  + car1.maker ); //사용

		System.out.println("최초" + car1.carName + "의 속도: " + car1.speed);
		System.out.println("car1의 속도를 2회 증가!!!!");
		car1.speedUp(); //메소드호출
		car1.speedUp(); 
		System.out.println("2회 증가 후" + car1.carName + "의 속도: " + car1.speed);
		
		System.out.println("car1의 속도를 8회 증가!!!!");
		for(int i = 0; i<8; i++){ //반복문 사용하여 메소드호출
			car1.speedUp();
		}
		System.out.println("8회 증가 후" + car1.carName + "의 속도: " + car1.speed);

		System.out.println("car1의 속도를 4회 감소!!!!");
		for(int i = 0; i<4; i++){
			car1.speedDown();
		}
		System.out.println("4회 감소 후 " + car1.carName + "의 속도: " + car1.speed);


		System.out.println("car1의 속도를 10회 감소!!!!");
		for(int i = 0; i<10; i++){
			car1.speedDown();
		}
	
		System.out.println("10회 감소 후 " + car1.carName + "의 속도: " + car1.speed);

















		Car car2 =  new Car();
		System.out.println("z. 차이름: " + car2.carName + "  색상: " + car2.color + " 제조사: "  + car2.maker ); //사용
		car2.carName = "K5";
		car2.color = "흰색";
		car2.maker = "기아";
		System.out.println("zz. 차이름: " + car2.carName + "  색상: " + car2.color + " 제조사: "  + car2.maker ); //사용

		System.out.println("car1: " + car1);//주소값이 다르다
		System.out.println("car2: " + car2);
	}
}


