package com.kitri.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
0, com, my 3자리배열
1. com 세자리 난수발생 >> comRandom()
2. 1의 숫자는 중복 숫자x
			  0으로 시작x
3. 내가 입력한 3자리 숫자를 my배열에 넣기			  
4. com과 my의 숫자와 자리비교
5. 숫자가 같다면
	5-1. 자리수 같다면 strike 증가
	5-2. 자리수 다르다면 ball증가
6. 5의 결과
	6-1.strike가 3 : 
		xxx는 x번째만에 정답입니다.
		계속(1), 종료(0)
	6-2. strike가 3이 아니라면
		1. xxx는 x스트라이크 x볼입니다. >> 3번으로
*/

//int strike, int ball, int count 어디에 만드느냐에 따라 달라짐


public class NumberBaseBall {

	private int my[] = new int[3];
	private int com[] = new int[3];
	BufferedReader in;
	
	
	//생성자
	public NumberBaseBall() {
		//난수발생메소드 호출
		comRandom();
		in = new BufferedReader(new InputStreamReader(System.in));//데이터받기
	}


	//난수발생
	private void comRandom() {
		
		com[0] = (int)(Math.random() * 10)+1; //0이 나오면 x
		
		do {
			com[1] = (int)(Math.random() * 10);
		}while(com[0] == com[1]);
		
		do {
			com[2] = (int)(Math.random() * 10);
		}while(com[0] == com[2] || com[1] == com[2]);
	}
		

	//game() 종료 0번누를때까지 무한루프
	private void game() {
		System.out.println(Arrays.toString(com));
		int strike = 0;
		int ball = 0;
		int count = 0;
		
		while(true) {
			strike = 0;
			ball = 0;
			System.out.print("숫자입력: ");
			int myNum = getNumber(); //149
			my[0] = (myNum/100); //1
			my[1] = myNum / 10 % 10; //4 //(myNum-(my[0] *100))/10;
			my[2] = (myNum % 10); //9
			
			//사용자가 만약 똑같은 숫자를 입력했다면? 소스추가하기
			
			
			
			System.out.println(Arrays.toString(my));
			
			
			//숫자와 자리수비교
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
			
			//결과
			if(strike != 3) {
				System.out.println(myNum +  "은 " + strike + "스트라이크 " + ball + "ball입니다.");
			}else {
				System.out.println(myNum +  "은" + count + "번만에 정답입니다");
				System.out.print("한판더(1), 종료(0) : ");
				int mynum = getNumber();
		        if(mynum == 0) {
		        	System.out.print("프로그램 종료!!!");
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
