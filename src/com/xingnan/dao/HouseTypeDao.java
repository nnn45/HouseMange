package com.xingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.xingnan.model.HouseType;
import com.xingnan.util.StringUtil;

/**
 * 房屋类别
 *
 * @author xingnan
 * @create 2023-12-14 14:32
 **/
public class HouseTypeDao {
	/**
	 * 房屋类别添加
	 * 
	 */
	public int add(Connection con,HouseType houseType)throws Exception{
		String sql="insert into houseType values(null,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, houseType.getHouseTypeName());
		pstmt.setString(2, houseType.getHouseTypeDesc());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 查询房屋类别集合
	 * @param con
	 * @param HouseType
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,HouseType houseType)throws Exception{
		StringBuffer sb=new StringBuffer("select * from houseType");
		if(StringUtil.isNotEmpty(houseType.getHouseTypeName())){
			sb.append(" and houseTypeName like '%"+houseType.getHouseTypeName()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	/**
	 * 删除房屋类别
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String id)throws Exception{
		String sql="delete from houseType where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 更新房屋类别
	 * @param con
	 * @param HouseType
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con,HouseType houseType)throws Exception{
		String sql="update houseType set houseTypeName=?,houseTypeDesc=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, houseType.getHouseTypeName());
		pstmt.setString(2, houseType.getHouseTypeDesc());
		pstmt.setInt(3, houseType.getId());
		return pstmt.executeUpdate();
	}
}
