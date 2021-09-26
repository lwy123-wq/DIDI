package com.sun.didi.entity;

import java.io.Serializable;

public class RegisterUser implements Serializable {

    //要缓存的 Java 对象必须实现 Serializable 接口，因为 Spring 会将对象先序列化再存入 Redis
    private static final long serialVersionUID = 2021745504395240314L;
    private String name;
    private String passwd;
    private String email;
    private String code;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
