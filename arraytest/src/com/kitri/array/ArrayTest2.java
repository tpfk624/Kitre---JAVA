package com.kitri.array;

public class ArrayTest2 {

	public static void main(String[] args) {
		Car car[] = new Car[6];
		car[0] = new Car("쏘나타", "검정색", "현대");
		car[1] = new Car("k5", "흰색", "기아");
		car[2] = new Car("sm5", "은색", "삼성");
		car[3] = new Car("아반떼", "흰색", "현대");
		car[4] = new Car("니어로", "비둘기색", "기아");
		car[5] = new Car("싼타페", "검정색", "현대");
		
		int len = car.length;
		for(int i = 0; i<len; i++) {
			System.out.println( i + 1 + "번째구역: " + car[i]);
		}
		
		//비둘기색 니어로(기아)는 5번째에 있습니다.
		//String name = "니어로";
		
		//QM5는 없습니다
		String name = "QM5";
		for(int i = 0; i<len; i++) {
			if(name.equals(car[i].getCarName())) { //문자열 비교는 가능하면 equals
				System.out.println(car[i].getColor() + "" + car[i].getCarName() + "(" + 
									car[i].getMaker() + ")는" + (i+1) + "번째 구역에 있습니다");
				break;
			}else if(i == len-1) 
				System.out.println( name + "는 없습니다");
		}
		
		//강사님방법
		//QM5는 없습니다
		name = "QM5";
		Car findCar = null;
		int count = 0;
		for(int i = 0; i<len; i++) {
			if(name.equals(car[i].getCarName())) {
				findCar = car[i];
				count = i + 1;
				break;
			}
		}
			
		if(findCar != null) {
			System.out.println(findCar.getColor() + "" + findCar.getCarName() + "(" + 
									findCar.getMaker() + ")는" + count + "번째 구역에 있습니다");
		}else {
			System.out.println( name + "는 없습니다");
		}
		
		
		
		
		
		
		
		
		
			
		
		
	}
}
