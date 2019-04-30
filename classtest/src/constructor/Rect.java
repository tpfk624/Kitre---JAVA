package constructor;

/*
1.	���� width, ���� height
2.	����: calcArea() 
	�ѷ�: calcRound()

������2��
*/

public class Rect {
	int width;
	int height;

	public Rect(){
		this(4,3);
	}

	public Rect(int width, int height){
		this.width = width;
		this.height = height;
	}



	int calcArea(){
		return width * height;
	}

	int calcRound(){
		return 2 * (width+height);
	}
}
