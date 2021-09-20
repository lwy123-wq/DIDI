package com.sun.didi.controller;

import com.sun.didi.entity.RegisterUser;
import com.sun.didi.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    @ResponseBody
    public String register(@RequestBody RegisterUser register){
//        register.setId(2);
//        register.setName("wu");
//        register.setPasswd("66666");
//        register.setCode(888);
        int joinInClazz = userService.create(register.getName(),register.getPasswd(),register.getCode());
        if (joinInClazz!=0){
            return "success";
        }
        return "注册失败";
    }


//    @RequestMapping(value = "find_name", method = RequestMethod.GET)
//    @ResponseBody
//    public String registry(@RequestParam String username) {
//        RegisterUser userByName = userService.deleteByName(username);
//        if (userByName != null) {
//            return userByName.getName();
//        }
//        return "未找到该用户";
//    }


}
