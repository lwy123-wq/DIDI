package com.sun.didi.service;

import com.sun.didi.dao.JobDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl extends JobDao {
    @Autowired
    private JobDao jobDao;
    public int insertJob(String name,String phone,String id_code,String card,String school,String email,String marriage,String address,int years,String education){
        return jobDao.create(name,phone,id_code,card,school,email,marriage,address,years,education) ;
    }

}
