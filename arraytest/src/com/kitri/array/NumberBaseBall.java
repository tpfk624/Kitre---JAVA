package com.kitri.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
0, com, my 3�ڸ��迭
1. com ���ڸ� �����߻� >> comRandom()
2. 1�� ���ڴ� �ߺ� ����x
			  0���� ����x
3. ���� �Է��� 3�ڸ� ���ڸ� my�迭�� �ֱ�			  
4. com�� my�� ���ڿ� �ڸ���
5. ���ڰ� ���ٸ�
	5-1. �ڸ��� ���ٸ� strike ����
	5-2. �ڸ��� �ٸ��ٸ� ball����
6. 5�� ���
	6-1.strike�� 3 : 
		xxx�� x��°���� �����Դϴ�.
		���(1), ����(0)
	6-2. strike�� 3�� �ƴ϶��
		1. xxx�� x��Ʈ����ũ x���Դϴ�. >> 3������
*/

//int strike, int ball, int count ��� ������Ŀ� ���� �޶���


public class NumberBaseBall {

	private int my[] = new int[3];
	private int com[] = new int[3];
	BufferedReader in;
	
	
	//������
	public NumberBaseBall() {
		//�����߻��޼ҵ� ȣ��
		comRandom();
		in = new BufferedReader(new InputStreamReader(System.in));//�����͹ޱ�
	}


	//�����߻�
	private void comRandom() {
		
		com[0] = (int)(Math.random() * 10)+1; //0�� ������ x
		
		do {
			com[1] = (int)(Math.random() * 10);
		}while(com[0] == com[1]);
		
		do {
			com[2] = (int)(Math.random() * 10);
		}while(com[0] == com[2] || com[1] == com[2]);
	}
		

	//game() ���� 0������������ ���ѷ���
	private void game() {
		System.out.println(Arrays.toString(com));
		int strike = 0;
		int ball = 0;
		int count = 0;
		
		while(true) {
			strike = 0;
			ball = 0;
			System.out.print("�����Է�: ");
			int myNum = getNumber(); //149
			my[0] = (myNum/100); //1
			my[1] = myNum / 10 % 10; //4 //(myNum-(my[0] *100))/10;
			my[2] = (myNum % 10); //9
			
			//����ڰ� ���� �Ȱ��� ���ڸ� �Է��ߴٸ�? �ҽ��߰��ϱ�
			
			
			
			System.out.println(Arrays.toString(my));
			
			
			//���ڿ� �ڸ�����
			for(int i = 0; i<3; i++) {
				for(int j =0; j<3; j++) {
					if(com[i] == my[j]) {
						if(i == j) {
							strike += 1;
						}else {
							ball += 1;
						}
					}
				}
			}
			count++;
			
			//���
			if(strike != 3) {
				System.out.println(myNum +  "�� " + strike + "��Ʈ����ũ " + ball + "ball�Դϴ�.");
			}else {
				System.out.println(myNum +  "��" + count + "������ �����Դϴ�");
				System.out.print("���Ǵ�(1), ����(0) : ");
				int mynum = getNumber();
		        if(mynum == 0) {
		        	System.out.print("���α׷� ����!!!");
		        	System.exit(0);
		        }
		        else
		        	comRandom();
		        	game();
			}
		}
	}
	
	private int getNumber() {
		int num = 0;
		try {
			num = Integer.parseInt(in.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	
	public static void main(String[] args) {
		NumberBaseBall nbb = new NumberBaseBall();
		nbb.game();
	}
}
