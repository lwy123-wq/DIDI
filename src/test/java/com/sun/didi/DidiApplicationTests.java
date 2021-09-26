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
        RegisterUser user=new RegisterUser();
        System.out.println(user.getEmail());
        System.out.println("=============================");
        String password="46623";

//        RegisterUser ll = userService.select("吴小姐", DigestUtils.md5DigestAsHex(password.getBytes()), "00000@qq.com");
//        System.out.println(ll.getEmail()+"\n"+ll.getName()+"\n"+ll.getPasswd());


//        RegisterUser re=new RegisterUser();
//        re.setName("吴小姐");
//        re.setPasswd("46623");
//        re.setEmail("00000@qq.com");
//        re.setCode("UER3F");
//        userService.register(re);
    }

}
