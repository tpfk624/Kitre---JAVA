public class OperTest4 {
	public static void main(String[] args) {
		int jumin = 1;
		String gender = jumin % 2 == 0 ? "����" : "����"; //���׿�����
		System.out.println("�ֹι�ȣ�� " +  jumin + "�� ����� " + gender + "�Դϴ�.");
		
		//������ 80�̻��̸� �հ�, 80�̸��̸� ���հ�
		//����� ������ xx�̹Ƿ� xx�Դϴ�.
		int score = 80;
		String pass = score >= 80 ? "�հ�" : "���հ�";
		System.out.println("����� ������ " + score + "���̹Ƿ� " + pass + "�Դϴ�.");
	}
}
