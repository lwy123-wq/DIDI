package com.sun.didi.service;

import com.sun.didi.dao.UserDao;
import com.sun.didi.entity.RegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.util.DigestUtils;

@Service
//@CacheConfig(cacheNames = "user")
public class UserServiceImpl {

    @Autowired
    private UserDao userDao;


    public RegisterUser findUserByName(String username) {
        return userDao.findByName(username);
    }

    public RegisterUser select(String username, String password,String email) {
        return userDao.select(username, password,email);
    }

    public boolean register(RegisterUser user) {
        //用户重名校验
        RegisterUser userByName = findUserByName(user.getName());
        if (userByName != null && userByName.getName() != null && userByName.getName().equals(user.getName())) {
            return true;
        }
        //对用户密码进行MD5,目的是，数据库中的敏感数据，不要存储明文。
        user.setPasswd(DigestUtils.md5DigestAsHex(user.getPasswd().getBytes()));
        return userDao.insertUser(user) != 0;
    }

}
