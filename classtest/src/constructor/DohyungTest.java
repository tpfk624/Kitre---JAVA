package constructor;

public class DohyungTest {
	public static void main(String[] args) {
		//1.���ΰ� 4�̰� ���ΰ� 3�� �簢���� ���̴� 12�̰� �ѷ��� 14�Դϴ�.
		Rect r1 = new Rect();
		double area = r1.calcArea();
		double round = r1.calcRound();
		System.out.println("���ΰ� " + r1.width + " ���ΰ� " + r1.height + "�� �簢���� ���̴� " + area + "�̰� �ѷ��� " + round); 
		

		//2.���ΰ� _�̰� ���ΰ� _�� �簢���� ���̴� _�̰� �ѷ��� _�Դϴ�.
		Rect r2 = new Rect(5,6); 
	
		area = r2.calcArea();
		round = r2.calcRound();
		System.out.println("���ΰ� " + r2.width + "���ΰ� " + r2.height + "�� �簢���� ���̴� " + area + "�̰� �ѷ��� " + round); 
		
		
		//3.�������� 4�� ���� ���̴� 48.xxx�̰� �ѷ��� 24.xxx�Դϴ�.
		Circle c1 = new Circle();
		area = c1.calcAreaUp();
		round = c1.calcRoundUp();

		System.out.println("�������� " + c1.radius + "�� ���� ���̴� " + area + "�̰� �ѷ��� " + round); 
		

		//4.�������� _�� ���� ���̴� _�̰� �ѷ��� _�Դϴ�.
		Circle c2 = new Circle(13); 
		
		area = c2.calcAreaUp();
		round = c2.calcRoundUp();
		System.out.println("�������� " + c2.radius + "�� ���� ���̴� " + area+ "�̰� �ѷ��� " + round); 
	}
}
