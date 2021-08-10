package com.yzq.Integral_process_server.server.bean;

public class User {
    private String user_name;
    private String pwd;
    private Integer id;


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_name='" + user_name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", id=" + id +
                '}';
    }
}
