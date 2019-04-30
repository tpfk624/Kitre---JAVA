package constructor;

public class StarCraft {
	public static void main(String[] args) {
		
		Marine my = new Marine();
		Marine com = new Marine();

		
		System.out.println("내 체력: " + my.getStatus() + " 적체력: " + com.getStatus());
		//내체력: 100, 적체력: 100


		int count = 2;
		System.out.println("\n1. 내가 적을 " + count + "회 공격!!!!!!");
		my.attack(com, count);
		System.out.println("내 체력: " + my.getStatus() + " 적체력: " + com.getStatus());
		//내체력: 100, 적체력: 80

		
		count = 4;
		System.out.println("\n2. 적이 나를 " + count + "회 공격!!!!!!");
		com.attack(my, count);
		System.out.println("내 체력: " + my.getStatus() + " 적체력: " + com.getStatus());
		//내 체력: 60, 적체력: 80


		System.out.println("\n**********내 모드변경!!!!!!************");
		
		
		my.changeMode();
		System.out.println("내 체력: " + my.getStatus() + " 적체력: " + com.getStatus());
		//내 체력: 35, 적체력: 80
		
		count = 3;
		System.out.println("\n3. 내가 적을 " + count + "회 공격!!!!!!");
		my.attack(com, count);
		System.out.println("내 체력: " + my.getStatus() + " 적체력: " + com.getStatus());
		//내 체력: 35, 적체력: 35

		
		System.out.println("\n내 모드변경!!!!!!");
		my.changeMode();
		System.out.println("내 체력: " + my.getStatus() + " 적체력: " + com.getStatus());

		//경고: 모드 변경 불가~!!!!!!!
		//내 체력: 35, 적체력: 35

		count = 3; //아직 모드 유효함
		System.out.println("\n4. 내가 적을 " + count + "회 공격!!!!!!");
		my.attack(com, count);
		System.out.println("내 체력: " + my.getStatus() + " 적체력: " + com.getStatus());
		//System.out.println("내 체력: " + my.hp + " 적체력: " + com.hp);
		//내 체력: 35, 적체력: die			//die가 나오면 win이 나오게끔한다.
		
		
	}
}
