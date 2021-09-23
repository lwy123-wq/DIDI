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

//    @Cacheable(cacheNames = "user", key = "#id")
//    public RegisterUser findById(int id) {
//        return userDao.findByUserId(id);
//    }

    //CachePut会无条件的将方法的返回值写入指定的key中
//    @CachePut(cacheNames = "user", key = "#user.id")
    //CacheEvict按指定的key,清除缓存
//    @CacheEvict(cacheNames = "user", key = "#user.id")
//    public int updateUserName(RegisterUser user) {
//        return userDao.updateUser(user);
//    }

//    @Caching(evict = {@CacheEvict(cacheNames = "user", key = "#user.id"),
//            @CacheEvict(cacheNames = "ClazzUserIds", key = "#oldClazzId")})
//    public int updateUserAndChangeUserClazz(RegisterUser user, int clazzId, int oldClazzId) {
//        //TODO:这里我少写了一些东西，需要未来加上。
//        int updateUser = 0;
//        int updateUserClazzRef = 0;
//        Object execute = txTemplate.execute(new TransactionCallback<Object>() {
//            @Override
//            public Object doInTransaction(TransactionStatus transactionStatus) {
//                try {
//                    userDao.updateUser(user);
//                    userClazzRefDao.updateUserClazzRef(new UserClazzRef(user.getId(), clazzId));
//////                    userClazzRefDao.insertUserClazzRef(new UserClazzRef(user.getId(), clazzId));
//                } catch (Throwable t) {
//                    transactionStatus.setRollbackOnly();
//                }
//                return null;
//            }
//        });
//
//        return updateUser + updateUserClazzRef;
//    }

//    @Transactional
//    public int insertUserAndJoinClazz(RegisterUser user, int clazzId) {
//        boolean register = register(user);
//        if (register) {
//            RegisterUser result = findUserByName(user.getName());
//            if (result == null) {
//                return 0;
//            }
//            return userClazzRefDao.insertUserClazzRef(new UserClazzRef(result.getId(), clazzId));
//        }
//        return 0;
//    }
}
