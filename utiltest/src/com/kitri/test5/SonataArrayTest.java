package com.kitri.test5;

public class SonataArrayTest {
	
	public static void main(String[] args) {
		Sonata car[] = new Sonata[4];
		car[0] = new Sonata("흰색", 5000, "승용", "NF");
		car[1] = new Sonata("은색", 7000, "업무", "Brillant");
		car[2] = new Sonata("감홍색", 4000, "택시", "EF");
		car[3] = new Sonata("검정색", 4000, "택시", "Hybrid");
		
		System.out.println("================ Sonata 생산 시작 ================");
		int len = car.length;
		for(int i = 0; i<len; i++) {
			System.out.println(car[i]);
		}
		
	}
}
