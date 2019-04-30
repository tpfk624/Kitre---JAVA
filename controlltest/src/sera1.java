public class sera1 {
	public static void main(String[] args) {
		//excercise02
		int x = 10;
		int y = 20;
		int z = (++x) + (y--);
		System.out.println(z);

		//excercise03
		int score = 85;
		String result = (!(score>90)) ? "가" : "나";
		System.out.println(result);

		//excercise04
		int pencils = 534;
		int students = 30;

		//학생 한 명이 가지는 연필 수
		int pencilsPerStudent = pencils / students;
		System.out.println(pencilsPerStudent);

		//남은 연필 수
		int pencilsLeft = pencils % students;
		System.out.println(pencilsLeft);

		//excercise05
		//int value = 356;
		//Syetem.out.println();



		//excercise06
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = ((lengthTop + lengthBottom) * height / 2 );
		System.out.println(area);

		//excercise07
		int a = 10;
		int b = 5;

		System.out.println( (a > 7) && (b <= 5) );
		System.out.println( (a % 3 == 2 ) || (b % 2 != 1));
		System.out.println( b % 2 != 1);







	}
}
