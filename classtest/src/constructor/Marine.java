package constructor;

/*
1.	ü�� hp 100, ���( 0: �Ϲ�, 1: ��� )
2.	���� attack()
		1ȸ ���ݴ� �� ü�� (0: -10, 1 : -15)
	��庯�� changeMode()
		��ü�� -25;
		��ü�� 40������ ���� ���� �Ұ�

���� ü������常 �޼ҵ常���
*/
public class Marine {
	int hp;
	int mode;
	int attack;
	
	
//����hp = ���� hp - ������ * count
	public Marine(){
		hp = 100;
		mode = 0;  //���ص���
	}
	
	void attack(Marine a, int count){ //Marine a = ��
		if(mode == 0){
			a.hp -= count * 10;
		}else{
			a.hp -= count * 15;
		}		
	}

	void changeMode(){
		if(hp > 40){
			mode = 1;
			hp -= 25;
		}else{
			//mode = 0;
			System.out.println("���: ��庯��Ұ�~!!!!!!!");
		}
	}


	String getStatus(){
		return hp < 0 ? "die" : hp+ ""; //���ڿ� ���ڿ� ���ϸ� ���ڿ���
	
	}
	
}
