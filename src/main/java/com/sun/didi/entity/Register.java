package com.sun.didi.entity;

public class Register {
    private int id;
    private String name;
    private String passwd;
    private int code; //验证码


    public Register(int id,String name,String passwd,int code){
        this.id=id;
        this.name=name;
        this.passwd=passwd;
        this.code=code;
    }

    public Register() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
