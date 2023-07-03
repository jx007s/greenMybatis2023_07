package aaa.model;

import lombok.Data;

@Data
public class HandPhone {

	String name = "은하수";
	int price = 80;
	public HandPhone(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public HandPhone() {
		// TODO Auto-generated constructor stub
	}
}
