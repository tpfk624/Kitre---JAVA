package constructor;

/*
1.	체력 hp 100, 모드( 0: 일반, 1: 흥분 )
2.	공격 attack()
		1회 공격당 적 체력 (0: -10, 1 : -15)
	모드변경 changeMode()
		내체력 -25;
		내체력 40이하일 경우는 변경 불가

어택 체인지모드만 메소드만들기
*/
public class Marine {
	int hp;
	int mode;
	int attack;
	
	
//적의hp = 적의 hp - 내공격 * count
	public Marine(){
		hp = 100;
		mode = 0;  //안해도됨
	}
	
	void attack(Marine a, int count){ //Marine a = 적
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
			System.out.println("경고: 모드변경불가~!!!!!!!");
		}
	}


	String getStatus(){
		return hp < 0 ? "die" : hp+ ""; //숫자에 문자열 더하면 문자열됨
	
	}
	
}
