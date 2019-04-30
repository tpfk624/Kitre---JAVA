package test_dtodao;

import java.io.Serializable;
import java.sql.Date;


public class Good implements Serializable {//DTO
	//객체를 전송하거나 저장하려면 객체직렬화가 필요하다 
	//그때 구현해야 하는 것이 Interface Serializable 
	
	private String code;
	private String name;
	private String manufacture;
	private int price;
	private Date makingdate;
	
	public Good() {
		super();
	}

	public Good(String code, String name, String manufacture, int price, Date makingdate) {
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
