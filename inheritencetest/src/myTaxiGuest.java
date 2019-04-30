public class myTaxiGuest {
	public static void main(String[] args) {
		myTaxi t1 = new myTaxi();
		System.out.println("t1 >> " + t1 + "기본값은 : " + t1.basicPrice);

		myTaxi t2 = new myTaxi("K5", "감홍색", "기아");
		System.out.println("t2 >> " + t2 + "기본값은 : " + t2.basicPrice);

		int km = 20;
		t2.initPrice();
		System.out.println(t2 + "를 타고 구디에서 강남까지 " + km + "km이동!!!");
		int price = t2.calcPrice(km);
		System.out.println("요금 : " + price + "원");
		t2.sumPrice();
		System.out.println("누적 수익 : " + t2.totalPrice + "원");


		km = 20;
		t2.initPrice();
		System.out.println(t2 + "를 타고 구디에서 강남까지 " + km + "km이동!!!");
		price = t2.calcPrice(km);
		System.out.println("요금 : " + price + "원");
		t2.sumPrice();
		System.out.println("누적 수익 : " + t2.totalPrice + "원");

	}
}
