public class myTaxiGuest {
	public static void main(String[] args) {
		myTaxi t1 = new myTaxi();
		System.out.println("t1 >> " + t1 + "�⺻���� : " + t1.basicPrice);

		myTaxi t2 = new myTaxi("K5", "��ȫ��", "���");
		System.out.println("t2 >> " + t2 + "�⺻���� : " + t2.basicPrice);

		int km = 20;
		t2.initPrice();
		System.out.println(t2 + "�� Ÿ�� ���𿡼� �������� " + km + "km�̵�!!!");
		int price = t2.calcPrice(km);
		System.out.println("��� : " + price + "��");
		t2.sumPrice();
		System.out.println("���� ���� : " + t2.totalPrice + "��");


		km = 20;
		t2.initPrice();
		System.out.println(t2 + "�� Ÿ�� ���𿡼� �������� " + km + "km�̵�!!!");
		price = t2.calcPrice(km);
		System.out.println("��� : " + price + "��");
		t2.sumPrice();
		System.out.println("���� ���� : " + t2.totalPrice + "��");

	}
}
