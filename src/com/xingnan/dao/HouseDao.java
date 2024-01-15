package com.xingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.xingnan.model.House;
import com.xingnan.util.StringUtil;


public class HouseDao {
	
	/**
	 * 房源添加
	 * @param con
	 * @param houseType
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,House house)throws Exception{
		String sql="insert into house values(null,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, house.getHouseName());
		pstmt.setInt(2, house.getHouseTypeId());
		pstmt.setString(3, house.getAddress());
		pstmt.setInt(4, house.getArea());
		pstmt.setInt(5, house.getPrice());
		pstmt.setString(6, house.getHouseDesc());
		return pstmt.executeUpdate();
	}
	
	
	/**
	 * 房源信息查询
	 * @param con
	 * @param house
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,House house)throws Exception{
		StringBuffer sb=new StringBuffer("select * from house h,houseType ht where h.houseTypeId=ht.id");
		if(StringUtil.isNotEmpty(house.getHouseName())){
			sb.append(" and h.houseName like '%"+house.getHouseName()+"%'");
		}
		if(StringUtil.isNotEmpty(house.getAddress())){
			sb.append(" and h.address like '%"+house.getAddress()+"%'");
		}
		if(house.getHouseTypeId()!= 0 && house.getHouseTypeId()!=-1){
			sb.append(" and h.houseTypeId="+house.getHouseTypeId());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		System.out.println(sb.toString());
		return pstmt.executeQuery();
		
	}
	
	/**
	 * 房屋删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String id)throws Exception{
		String sql="delete from house where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
/**
 * 房屋修改
 * @param con
 * @param house
 * @return
 * @throws Exception
 */
	public int update(Connection con,House house)throws Exception{
		String sql="update house set houseName=?,houseTypeid=?,address=?,area=?,price=?,houseDesc=? where houseId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, house.getHouseName());
		pstmt.setInt(2, house.getHouseTypeId());
		pstmt.setString(3, house.getAddress());
		pstmt.setInt(4, house.getArea());
		pstmt.setInt(5, house.getPrice());
		pstmt.setString(6, house.getHouseDesc());
		pstmt.setInt(7, house.getHouseId());
		return pstmt.executeUpdate();
	}
	/**
	 * 判断房源类别下是否存在房屋
	 * @param con
	 * @param houseTypeId
	 * @return
	 * @throws Exception
	 */
	
	public boolean existHouseByHouseTypeId(Connection con,String houseTypeId)throws Exception{
		String sql="select * from house where houseTypeId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, houseTypeId);
		ResultSet rs=pstmt.executeQuery();
		return rs.next();
	}
	
}
