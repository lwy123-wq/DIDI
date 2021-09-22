package com.sun.didi.controller;

import com.sun.didi.service.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JobController {
    @Autowired
    private JobServiceImpl jobService;
    @GetMapping(value = "/job")
    @ResponseBody
    public String job(String name,String phone,String id_code,String card,String school,String email,String marriage,String address,int years,String education){
       return " " ;
    }
}
