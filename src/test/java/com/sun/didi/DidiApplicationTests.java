package com.sun.didi;

import com.sun.didi.entity.RegisterUser;
import com.sun.didi.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DidiApplication.class)
class DidiApplicationTests {
    @Autowired
    private UserServiceImpl userService;

    @Test
    void contextLoads() {

       // userService.create("ll","1111","21561@qq.com",5555);
       // RegisterUser ll = userService.select("ll", "1111", "21546@qq.com");
        RegisterUser re=new RegisterUser();
        re.setName("lxj");
        re.setPasswd("222");
        re.setEmail("3432523@qq.com");
        userService.register(re);
    }

}
