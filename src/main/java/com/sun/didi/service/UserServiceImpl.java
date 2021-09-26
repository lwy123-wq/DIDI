package com.sun.didi.service;

import com.sun.didi.annotation.Cache;
import com.sun.didi.dao.UserDao;
import com.sun.didi.dao.mapper.UserMapper;
import com.sun.didi.entity.RegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Service
public class UserServiceImpl {

    @Resource
    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;
@Autowired
private RedisTemplate redisTemplate;
/*

*将方法的运行结果进行缓存，以后再要相同的数据，直接从缓存获取，不用调用方法
CacheManager :管理缓存
*CacheNames/value:指定缓存的名字
key:缓存数据使用的key ，可以用来指定，默认是使用方法参数逇值
* */
/*@Cacheable(cacheNames = {"emp"})//,condition = "#id>0" id>0的数据才存到这个缓存的key中
    public RegisterUser findById1(int id) {
        System.out.println(id+"员工");
        RegisterUser byUserId = userMapper.findByUserId(id);
        return byUserId;
    }*/
    public RegisterUser findUserByName(String username) {
        return userDao.findByName(username);
    }

    @Cacheable(cacheNames = "emp")
    public RegisterUser select(String username, String password,String email,String code) {
        password=DigestUtils.md5DigestAsHex(password.getBytes());
        return userDao.select(username, password,email,code);
    }

    @Cacheable(cacheNames = {"registern"},key = "#id")
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

    @Cacheable(cacheNames = "user", key = "#id")
    public RegisterUser findById(int id) {
        return userDao.findByUserId(id);
    }

    //CachePut会无条件的将方法的返回值写入指定的key中
//    @CachePut(cacheNames = "user", key = "#user.id")
    //CacheEvict按指定的key,清除缓存
    @CacheEvict(cacheNames = "user", key = "#user.id")
    public int updateUserName(RegisterUser user) {
        return userDao.updateUser(user);
    }

}
