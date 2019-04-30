package good;

import java.io.Serializable;
import java.sql.Date;


//dto클래스(good)
//db의 데이터를 저장할 클래스

public class Good implements Serializable{
	//db와 연동할 DTO클래스 생성
	//DB에 있는 변수명과 동일하게 생성
	//접근자메소드, 생성자2가지,toString 메소드 생성

	private String code;
	private String name;
	private String manufacture;
	private int price;
	private Date makingdate;
	
	
	
	public Good() {
		super();
	}

	public Good(String code, String name, String manufacture, int price, Date makingdate) {
		super();
		this.code = code;
		this.name = name;
		this.manufacture = manufacture;
		this.price = price;
		this.makingdate = makingdate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getMakingdate() {
		return makingdate;
	}

	public void setMakingdate(Date makingdate) {
		this.makingdate = makingdate;
	}

	@Override
	public String toString() {
		return "Good [code=" + code + ", name=" + name + ", manufacture=" + manufacture + ", price=" + price
				+ ", makingdate=" + makingdate + "]";
	}
	

}
