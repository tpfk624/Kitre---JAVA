import java.io.*;


public class Test {

	int com;
	BufferedReader in;


	public Test(){
		in = new BufferedReader(new InputStreamReader(System.in));
	}


	public void game()throws Exception {
		while(true){
			System.out.println("0 1 2 �Է� : ");
			int my = Integer.parseInt(in.readLine());
			System.out.println("my ===" + my);
			if(my == 4){
				exit();
			}
		}
	}

	public void exit(){
		System.out.println("���α׷� �����մϴ�!!!!");
	}

	public static void main(String[] args)throws Exception{
		Test t = new Test();
		t.game();
	}
}
