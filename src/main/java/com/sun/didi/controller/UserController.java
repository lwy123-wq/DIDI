package com.sun.didi.controller;


import com.sun.didi.entity.RegisterUser;
import com.sun.didi.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String Aa(){
        return "aaa";
    }

    //登录
    @RequestMapping(value = "/loginn",method = RequestMethod.GET)
    public ModelAndView login(){
        return new ModelAndView("/login.html");
    }
    @PostMapping(value = "/login")
    @ResponseBody
    public String login( String username,String password, String email) {
        RegisterUser user = userService.select(username, DigestUtils.md5DigestAsHex(password.getBytes()),email);
        if (user == null || user.getName() == null) {
            return "error";
        }
      //  String sign = JWTUtil.sign(user, 60L * 1000L * 30L);
        return "success";
    }

//注册

    @RequestMapping(value = "/registry", method = RequestMethod.GET)
    @ResponseBody
    public String registry(@RequestBody RegisterUser user) {
        user.setName(user.getName());
        user.setPasswd(user.getPasswd());
        user.setEmail(user.getEmail());
        boolean register = userService.register(user);
        if (register) {
            return "hello" + user.getName();
        }
        return "注册失败";
    }


    @RequestMapping(value = "find_name", method = RequestMethod.GET)
    @ResponseBody
    public String registry(@RequestParam String username) {
        RegisterUser userByName = userService.findUserByName(username);
        if (userByName != null) {
            return userByName.getName();
        }
        return "未找到该用户";
    }


//    @RequestMapping(value = "find_id", method = RequestMethod.GET)
//    @ResponseBody
//    public String findById(@RequestParam int id) {
//        RegisterUser userById = userService.findById(id);
//        if (userById != null) {
//            return userById.getName();
//        }
//        return "未找到该用户";
//    }
//
//
//    @RequestMapping(value = "update_name", method = RequestMethod.POST)
//    @ResponseBody
//    public String updateName(@RequestBody RegisterUser user) {
//        int count = userService.updateUserName(user);
//        if (count != 0) {
//            return "更新成功";
//        }
//        return "未找到该用户";
//    }
//
//
//    @RequestMapping(value = "testException",method = RequestMethod.GET)
//    @ResponseBody
//    public String testException(){
//        throw new RuntimeException("bbb");
//    }


}
