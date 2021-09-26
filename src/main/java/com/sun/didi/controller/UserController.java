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
        return "select";
    }

    @RequestMapping(value = "/emp/{a}/{b}/{c}",method = RequestMethod.GET)
    @ResponseBody
    public RegisterUser emp(@PathVariable(name = "a") String name,@PathVariable(name = "b") String passwd,@PathVariable(name = "c") String email){
        RegisterUser byId = userService.select(name,passwd,email);
        return byId;
    }
    //登录
    @RequestMapping(value = "/loginn",method = RequestMethod.GET)
<<<<<<< HEAD
    public ModelAndView login(){
        return new ModelAndView("/login.html");//跳转页面
=======
    public ModelAndView login1(){
        return new ModelAndView("/login.html");
>>>>>>> b63ec687f91c8addc3617f8aeb34f03cd8971bae
    }
    @PostMapping(value = "/login")
    @ResponseBody
    public String login( String username,String password, String email) {
        System.out.println(username+"==================================");
        RegisterUser user = userService.select(username, DigestUtils.md5DigestAsHex(password.getBytes()),email);
        if (user == null || user.getName() == null) {
            return "error";
        }
<<<<<<< HEAD
        return "success";
    }

    //注册
     @RequestMapping(value = "/registern",method = RequestMethod.GET)
     public ModelAndView register(){
     return new ModelAndView("/register.html");//跳转页面
}
=======
      //  String sign = JWTUtil.sign(user, 60L * 1000L * 30L);
        return "success";
    }

//注册
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        return new ModelAndView("/register.html");
    }
>>>>>>> b63ec687f91c8addc3617f8aeb34f03cd8971bae
    @PostMapping(value = "/registry")
    @ResponseBody
    public String registry(@RequestBody RegisterUser user) {
        user.setName(user.getName());
        user.setPasswd(user.getPasswd());
        user.setEmail(user.getEmail());
        user.setCode(user.getCode());
        System.out.println(user);
        boolean register = userService.register(user);
        if (register) {
            return "success";
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
