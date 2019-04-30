/*
1. ���
  �⺻���(basicPrice)
    �Ϲ� : 3800
	�ɾ� : 5000
  �����(totalPrice)
  ���(price)
    �Ϲ� : 100/km
	�ɾ� : 150/km
2. ��� ���(calcPrice())
3. �ɾ����� : 0�� ~ 6��
*/
import java.util.*;


public class myTaxi extends Car {
	
	int basicPrice;
	int totalPrice;
	int price;
	int pricePerKm;
 
	public myTaxi() {		//default������
		super();
		basicPrice = 3800;
	}

	public myTaxi(String carName, String color, String maker) {
		super(carName, color, maker);
		basicPrice = 3800;
	}
	
	void initPrice(){ 
		//�ð����
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);

		if(hour < 6){
			basicPrice = 5000;
			pricePerKm = 150;
		}else{
			basicPrice = 3800;
			pricePerKm = 100;
		}
	}


	int calcPrice(int km) {
		price = basicPrice + (km * pricePerKm);
		return price;
	}



	void sumPrice(){
		totalPrice += price;
		price = 0;
		basicPrice = 0;
	}
	
}
