package com.xingnan.model;
/**
 * 房屋实体
 */

public class House {
	private int houseId;
	private String houseName;//名称
	private int houseTypeId;//类别ID
	private String address;//地址
	private int area;//面积
	private int price;//价格
	private int houseTypeName;//类别名称
	private String houseDesc;//备注
	
	
	
	
	
	
	
	
	
	public House(int houseId, String houseName, int houseTypeId, String address, int area, int price,
			String houseDesc) {
		super();
		this.houseId = houseId;
		this.houseName = houseName;
		this.houseTypeId = houseTypeId;
		this.address = address;
		this.area = area;
		this.price = price;
		this.houseDesc = houseDesc;
	}
	public House(String houseName, int houseTypeId, String address) {
		super();
		this.houseName = houseName;
		this.houseTypeId = houseTypeId;
		this.address = address;
	}
	public House(String houseName, int houseTypeId, String address, int area, int price, String houseDesc) {
		super();
		this.houseName = houseName;
		this.houseTypeId = houseTypeId;
		this.address = address;
		this.area = area;
		this.price = price;
		this.houseDesc = houseDesc;
	}
	public House() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getHouseId() {
		return houseId;
	}
	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public Integer getHouseTypeId() {
		return houseTypeId;
	}
	public void setHouseTypeId(int houseTypeId) {
		this.houseTypeId = houseTypeId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String addree) {
		this.address = addree;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getHouseTypeName() {
		return houseTypeName;
	}
	public void setHouseTypeName(int houseTypeName) {
		this.houseTypeName = houseTypeName;
	}
	public String getHouseDesc() {
		return houseDesc;
	}
	public void setHouseDesc(String houseDesc) {
		this.houseDesc = houseDesc;
	}
	
	
	
	
	
	
}
