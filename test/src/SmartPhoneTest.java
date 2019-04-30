public class SmartPhoneTest {
	public static void main(String[] args) {
	
		System.out.println("=== 제품목록 ===");
		System.out.println("------------------------");

		SmartPhone s1 = new SmartPhone("삼성", "갤럭시노트2", 850000);
		System.out.println(s1);

		SmartPhone s2 = new SmartPhone("애플", "아이폰5", 740000, 30);
		System.out.println(s2);


		SmartPhone s3 = new SmartPhone("삼성", "갤럭시S3", 750000, 35);
		System.out.println(s3);	

		//System.out.println(s1.maker); private여서 오류 	 
	}
}
