package constructor;

public class StarCraft {
	public static void main(String[] args) {
		
		Marine my = new Marine();
		Marine com = new Marine();

		
		System.out.println("�� ü��: " + my.getStatus() + " ��ü��: " + com.getStatus());
		//��ü��: 100, ��ü��: 100


		int count = 2;
		System.out.println("\n1. ���� ���� " + count + "ȸ ����!!!!!!");
		my.attack(com, count);
		System.out.println("�� ü��: " + my.getStatus() + " ��ü��: " + com.getStatus());
		//��ü��: 100, ��ü��: 80

		
		count = 4;
		System.out.println("\n2. ���� ���� " + count + "ȸ ����!!!!!!");
		com.attack(my, count);
		System.out.println("�� ü��: " + my.getStatus() + " ��ü��: " + com.getStatus());
		//�� ü��: 60, ��ü��: 80


		System.out.println("\n**********�� ��庯��!!!!!!************");
		
		
		my.changeMode();
		System.out.println("�� ü��: " + my.getStatus() + " ��ü��: " + com.getStatus());
		//�� ü��: 35, ��ü��: 80
		
		count = 3;
		System.out.println("\n3. ���� ���� " + count + "ȸ ����!!!!!!");
		my.attack(com, count);
		System.out.println("�� ü��: " + my.getStatus() + " ��ü��: " + com.getStatus());
		//�� ü��: 35, ��ü��: 35

		
		System.out.println("\n�� ��庯��!!!!!!");
		my.changeMode();
		System.out.println("�� ü��: " + my.getStatus() + " ��ü��: " + com.getStatus());

		//���: ��� ���� �Ұ�~!!!!!!!
		//�� ü��: 35, ��ü��: 35

		count = 3; //���� ��� ��ȿ��
		System.out.println("\n4. ���� ���� " + count + "ȸ ����!!!!!!");
		my.attack(com, count);
		System.out.println("�� ü��: " + my.getStatus() + " ��ü��: " + com.getStatus());
		//System.out.println("�� ü��: " + my.hp + " ��ü��: " + com.hp);
		//�� ü��: 35, ��ü��: die			//die�� ������ win�� �����Բ��Ѵ�.
		
		
	}
}
