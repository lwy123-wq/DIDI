package com.sun.didi.dao;

import com.sun.didi.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class JobDao implements JobService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int create(String name, String phone, String id_code, String card, String school, String email, String marriage, String address, int years, String education) {
        return jdbcTemplate.update("insert into jobinfo(jobname,phone,id_code,card,school,email,marriage,address,years,education)values(?,?,?,?,?,?,?,?,?,?)",name,phone,id_code,card,school,email,marriage,address,years,education);

    }
}