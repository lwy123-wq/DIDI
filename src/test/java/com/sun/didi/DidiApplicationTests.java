package com.sun.didi;

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

        userService.create("ll","1111",33);
    }

}
