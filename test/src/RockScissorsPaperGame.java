import java.io.*;

public class RockScissorsPaperGame {

	private int com;
	BufferedReader in;

	public RockScissorsPaperGame() {
		in = new BufferedReader(new InputStreamReader(System.in));
		comRandom();
	}

	public void comRandom() {
		com = (int)(Math.random() * 3);
	}

	public void menu() throws Exception {
		System.out.print("���Ǵ�(1), ����(0) : ");
		int exit = Integer.parseInt(in.readLine());
		if(exit == 0)
			exit();
		else
			comRandom();
	}

	public void game(int my) throws Exception {
		int result = (my - com + 2) % 3;
		String resultStr = "";
		if(result == 0) {//��
			resultStr = "�̰��.";
		} else if(result == 1) {//��
			resultStr = "����.";
		} else {//��
			resultStr = "����.";
		}

		System.out.println("�� : " + gbb(my) + "\t�� : " + gbb(com) + "\t��� : " + resultStr);
		menu();
	}

	public String gbb(int num) {
		String gbb = "";
		if(num == 0) {
			gbb = "����";
		} else if(num == 1){ 
			gbb = "����";
		} else {
			gbb = "��";
		}
		return gbb;
	}

	public void exit() {
		System.exit(0);
	}

	public static void main(String[] args) throws Exception {
		RockScissorsPaperGame gbb = new RockScissorsPaperGame();
		System.out.println("============ ��ǻ�Ϳ� ���� ���� �� ���� !!! ============");
		while(true) {
			System.out.print("����(0) ����(1) ��(2) �Է��ϼ��� : ");
			int my = Integer.parseInt(gbb.in.readLine());
			if(my > 2) {
				System.out.println("����(0) ����(1) ��(2)�� �Է� �����մϴ�.");	
				continue;
			}
			gbb.game(my);
		}
	}
}
