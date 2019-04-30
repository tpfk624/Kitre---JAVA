public class OperTest5 {
	public static void main(String[] args) {
		int x = 0;
		System.out.println("1. x = " + x);

		x = 10;
		System.out.println("2. x = " + x);

		x += 5; //x = x + 5
		System.out.println("3. x = " + x);

		x -= 5; //x = x - 5
		System.out.println("4. x = " + x);

		x *= 5; //x = x * 5
		System.out.println("5. x = " + x);

		x /= 5; //x = x / 5
		System.out.println("6. x = " + x);

		x %= 5; //x = x %  5
		System.out.println("7. x = " + x);



		//test) 
		//int y = 10;
		//y의 값을 1증가시키는방법?
		
		int y = 10;
		System.out.println("1.y = " + y);

		y = y + 1;
		System.out.println("2.y = " + y);

		y += 1;
		System.out.println("3.y = " + y);

		y++;
		System.out.println("4.y = " + y);

		++y;
		System.out.println("5.y = " + y);


		int z = 0 / 10;
		System.out.println("z == " + z);

		z = 10/0;
	}
}
