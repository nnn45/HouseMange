package com.xingnan.model;

/**
 * 用户实体
 * @author xingnan
 * @create 2023-12-13 21:33
 **/
public class User {


    private int id;
    private String uname;
    private String upwd;

    public User() {
       super();
    }


    public User(String uname, String upwd) {
        this.uname = uname;
        this.upwd = upwd;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                '}';
    }


}
