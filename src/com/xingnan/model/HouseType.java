package com.xingnan.model;
/**
 * ��������ʵ��
 * @author xingnan
 * @create 2023-12-16 20:17
 **/
public class HouseType {
	private int id;//���
	private String houseTypeName;//��������
	private String houseTypeDesc;//����
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHouseTypeName() {
		return houseTypeName;
	}
	public void setHouseTypeName(String houseTypeName) {
		this.houseTypeName = houseTypeName;
	}
	public String getHouseTypeDesc() {
		return houseTypeDesc;
	}
	public void setHouseTypeDesc(String houseTypeDesc) {
		this.houseTypeDesc = houseTypeDesc;
	}
	public HouseType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HouseType(String houseTypeName, String houseTypeDesc) {
		super();
		this.houseTypeName = houseTypeName;
		this.houseTypeDesc = houseTypeDesc;
	}
	public HouseType(int id, String houseTypeName, String houseTypeDesc) {
		super();
		this.id = id;
		this.houseTypeName = houseTypeName;
		this.houseTypeDesc = houseTypeDesc;
	}
	@Override
	public String toString() {
		return houseTypeName;
	}
	
	
}
