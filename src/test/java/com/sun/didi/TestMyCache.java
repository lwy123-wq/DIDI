package com.sun.didi;

import com.sun.didi.dao.UserDao;
import com.sun.didi.dao.mapper.UserMapper;
import com.sun.didi.entity.RegisterUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

//spring-test来初始化单元测试用的IOC容器
//@RunWith(SpringJUnit4ClassRunner.class)
//用来给spring-test标注，哪些Bean需要注入到IOC容器中
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DidiApplication.class)
public class TestMyCache {
    @Autowired
     private UserMapper userMapper;

//    @Resource
//    private UserDao userDao;

    @Test
    public void testCache() {
        RegisterUser user = userMapper.findByNameAndPassword("ll","1111");
       // RegisterUser user=new RegisterUser();
        System.out.println(user.getEmail());
//        Assert.assertEquals("ll", user.getName());

    }

}
