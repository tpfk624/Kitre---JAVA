public class SmartPhone {

	private String maker;
	private String name;
	private int price;
	private int discountRate;
	
	//������
	public SmartPhone(String maker, String name, int price){
		this.maker = maker;
		this.name = name;
		this.price = price;
	}

	public SmartPhone(String maker, String name, int price, int discountRate){
		this.maker = maker;
		this.name = name;
		this.price = price;
		this.discountRate =discountRate;
	}

	//�޼ҵ����
	public int calculateDiscount() {
		return (int) (price * (1.0 - (double)discountRate / 100));
		//this.discountRate = price - (price * a / 100);
		//return this.discountRate;
	}

	@Override
	public String toString(){
		String str = name +  "[" + maker + "]" + "\n���� : " + price;
		if(discountRate != 0)
			str += "\n���ΰ��� : "+  calculateDiscount();
		str += "\n------------------------";
		return str;
	}
}
	
	/*
	String info(){
		if(discountRate > 0){
		return name +  "[" + maker + "]" + "\n���� : " + price + "\n���ΰ��� : "+  discountRate  + "\n------------------------";
	}else {
		return name +  "[" + maker + "]" + "\n���� : " + price + "\n------------------------";
	}
	*/

	

