/*
�� ��������
���α׷� ���� �� ���ϴ� ���ڸ� �Է��Ѵ�.
1���� �Է��� ������ ���ڸ� �ϳ��� ��������
���ǿ� �´� ���ڿ��� ����Ѵ�

*/
public class MultipleCheck {
	public static void main(String[] args) {
		
		int num = 20;

		int b2 = 0;
		int b3 = 0;
		int b5 = 0;

		System.out.println("�ݺ� Ƚ���� �Է��ϼ��� : "  +  num);

		for(int i = 1; i <= num; i++){    
			System.out.print(i + ". ");
			if(i % 2 == 0){						//if else�� �ƴ϶� if�� �������Ѵ�.
				System.out.print("2�� ���");
				b2++;
			}
			if(i % 3 == 0){
				System.out.print("3�� ���");
				b3++;
			}
			if(i % 5  == 0){
				System.out.print("5�� ���");
				b5++;
			}
			System.out.println();

		}
		System.out.println("==== ���Ƚ�� ====");
		System.out.println("2�� ���: " + b2);
		System.out.println("3�� ���: " + b3);
		System.out.println("5�� ���: " + b5);

	}
}