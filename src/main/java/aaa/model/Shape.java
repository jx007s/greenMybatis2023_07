package aaa.model;

import lombok.Data;

@Data
public class Shape {

	String name;
	int area, border;
	public Shape(String name, int area, int border) {
		super();
		this.name = name;
		this.area = area;
		this.border = border;
	}
	public Shape() {
		// TODO Auto-generated constructor stub
	}
	
}
