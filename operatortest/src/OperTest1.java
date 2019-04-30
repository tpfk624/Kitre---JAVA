public class OperTest1 
{
	public static void main(String[] args) 
	{	

		int x = 10;
		System.out.println(x);
		System.out.println(x++);
		System.out.println(--x);
		System.out.println(x++);
		System.out.println(++x);
		System.out.println(x--);
		System.out.println(--x);
		System.out.println(x++);
		System.out.println(x);
		
		//강제형변환
		char c = 'a';
		System.out.println("c == " + c);
		System.out.println("(int)c == " + (int)c);
		
		//자동형변환
		int y = c;
		System.out.println("y == " + y);
		
		//강제형변환
		//int(4byte)를 char(2byte)로 넣을 수는 없다.
		c = (char)y;
		System.out.println("c == " + c);
		
		//boolean은 숫자로 바꿀 수 없어서 형변환x
		//error
		//boolean b = true;
		//int z = b;


		int z = 30;
		double d = z;
		//z = d;   //error
		z = (int)d;


	}
}
