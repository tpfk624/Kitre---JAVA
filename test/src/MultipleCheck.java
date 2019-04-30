/*
※ 구현내용
프로그램 실행 후 원하는 숫자를 입력한다.
1부터 입력한 수까지 숫자를 하나씩 증가시켜
조건에 맞는 문자열을 출력한다

*/
public class MultipleCheck {
	public static void main(String[] args) {
		
		int num = 20;

		int b2 = 0;
		int b3 = 0;
		int b5 = 0;

		System.out.println("반복 횟수를 입력하세요 : "  +  num);

		for(int i = 1; i <= num; i++){    
			System.out.print(i + ". ");
			if(i % 2 == 0){						//if else가 아니라 if를 돌려야한다.
				System.out.print("2의 배수");
				b2++;
			}
			if(i % 3 == 0){
				System.out.print("3의 배수");
				b3++;
			}
			if(i % 5  == 0){
				System.out.print("5의 배수");
				b5++;
			}
			System.out.println();

		}
		System.out.println("==== 출력횟수 ====");
		System.out.println("2의 배수: " + b2);
		System.out.println("3의 배수: " + b3);
		System.out.println("5의 배수: " + b5);

	}
}