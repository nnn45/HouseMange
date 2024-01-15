package com.xingnan.dao;

import com.xingnan.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * ÓÃ»§µÇÂ¼
 *
 * @author xingnan
 * @create 2023-12-14 14:32
 **/
public class UserDao {
    public User login(Connection connection, User user) throws Exception{
        User resultUser = null;
        String sql = "select * from users where uname = ? and upwd = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, user.getUname());
        pstmt.setString(2, user.getUpwd());
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            resultUser = new User();
            resultUser.setId(rs.getInt("id"));
            resultUser.setUname(rs.getString("uname"));
            resultUser.setUpwd(rs.getString("upwd"));
        }
        return resultUser;
    }
}
