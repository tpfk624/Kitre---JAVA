public class SmartPhoneTest {
	public static void main(String[] args) {
	
		System.out.println("=== ��ǰ��� ===");
		System.out.println("------------------------");

		SmartPhone s1 = new SmartPhone("�Ｚ", "�����ó�Ʈ2", 850000);
		System.out.println(s1);

		SmartPhone s2 = new SmartPhone("����", "������5", 740000, 30);
		System.out.println(s2);


		SmartPhone s3 = new SmartPhone("�Ｚ", "������S3", 750000, 35);
		System.out.println(s3);	

		//System.out.println(s1.maker); private���� ���� 	 
	}
}
