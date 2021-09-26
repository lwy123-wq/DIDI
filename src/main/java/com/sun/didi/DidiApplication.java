package com.sun.didi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*
* @CachePut  对其结果进行缓存
* @CacheEvict 清空缓存
* @Cacheable
* */
@MapperScan("com.sun.didi.dao.mapper")
@SpringBootApplication
public class DidiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DidiApplication.class, args);
    }

}
