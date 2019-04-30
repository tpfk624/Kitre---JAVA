public class TaxiGuest {
	public static void main(String[] args) {
		Taxi t1 = new Taxi();
		System.out.println("t1 >> " + t1.toString() + "  기본요금 : "  + t1.basicPrice);

		Taxi t2 = new Taxi("K5", "감홍색", "기아");
		System.out.println("t2 >> " + t2.toString() + "  기본요금 : "  + t2.basicPrice);

		int km = 20;
		t2.initPrice();
		System.out.println(t2 + "를 타고 구디에서 강남까지 " + km + "km이동!!!");
		int price = t2.calcPrice(km);
		t2.sumPrice();
		System.out.println("요금 : " + price + "원");
		System.out.println("누적 수익 : " + t2.totalPrice + "원");

		km = 20;
		t2.initPrice();
		System.out.println(t2 + "를 타고 강남에서 구디까지 " + km + "km이동!!!");
		price = t2.calcPrice(km);
		t2.sumPrice();
		System.out.println("요금 : " + price + "원");
		System.out.println("누적 수익 : " + t2.totalPrice + "원");

		int upDown = 50;
		System.out.println("t2의 속도를" + upDown + "만큼 가속!!!");
		int speed = t2.speedUp(upDown);
		System.out.println("t2의 속도 : " + speed + " " + t2.speed);

		upDown = 250;
		System.out.println("t2의 속도를 " + upDown + "만큼 가속!!!");
		speed = t2.speedUp(upDown);
		System.out.println("t2의 속도 : " + speed + " " + t2.speed);//앞은 계기판 뒤는 진짜 자동차의 속도로 본다.


		//System.out.println(t1 + "      " + t2); //문자열이랑 +되면 문자열이 된다.(자동으로 toString가 있다)
		//System.out.println(t1.toString() + "			"+ t2.toString()); //오브젝트에 있는 메소드여서 사용가능


		Taxi t3 = new Taxi("K5", "감홍색", "기아");
		System.out.println(t2 + "      " + t3);
		System.out.println(t2.hashCode() + "      " + t3.hashCode()); //hashCode() - 주소값
		if(t2 == t3) // ==(비교연산자)는 기본DT일 경우에 값을 비교하지만 참조형DT일 경우는 주소값을 비교
			System.out.println("t2와 t3는 주소값이 같은 차이다");
		else
			System.out.println("t2와 t3는 주소값이 다른 차이다");


		if(t2.equals(t3)) //equals(Object obj) - 주소값비교 
			System.out.println("t2와 t3는 차이름이 같은 차이다");
		else
			System.out.println("t2와 t3는 차이름이 다른 차이다");
				

		

	}
}


