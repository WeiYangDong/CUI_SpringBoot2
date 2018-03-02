package com.blblz.app.domain;

/**
 * @author WeiYangDong
 * @date 2018/3/2 17:23
 * @deprecated 用户模型
 */
public class User {

    private int id;//主键ID
    private String userName;//用户名

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
