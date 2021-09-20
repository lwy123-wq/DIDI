package com.sun.didi.service;

public interface UserService {
    /**
     * 新增一个用户
     * @return
     */
    int create( String name, String passwd, int code);

    /**
     * 根据name删除一个用户
     * @param name
     */
    void deleteByName(String name);

    /**
     * 获取用户总量
     */
    Integer getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();

}
