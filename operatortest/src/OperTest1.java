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
		
		//��������ȯ
		char c = 'a';
		System.out.println("c == " + c);
		System.out.println("(int)c == " + (int)c);
		
		//�ڵ�����ȯ
		int y = c;
		System.out.println("y == " + y);
		
		//��������ȯ
		//int(4byte)�� char(2byte)�� ���� ���� ����.
		c = (char)y;
		System.out.println("c == " + c);
		
		//boolean�� ���ڷ� �ٲ� �� ��� ����ȯx
		//error
		//boolean b = true;
		//int z = b;


		int z = 30;
		double d = z;
		//z = d;   //error
		z = (int)d;


	}
}
