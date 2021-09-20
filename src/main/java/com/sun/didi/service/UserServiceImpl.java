package com.sun.didi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int create( String name, String passwd, int code) {

        return jdbcTemplate.update("insert into Register(name, passwd,code) values(?, ?,?)", name, passwd,code);
    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public Integer getAllUsers() {

        return null;
    }

    @Override
    public void deleteAllUsers() {

    }
}
