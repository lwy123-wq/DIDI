package com.sun.didi.dao.mapper;

import com.sun.didi.entity.RegisterUser;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

@Mapper
public interface UserMapper {

  //  @Select(value = "SELECT id,name,age FROM t_user WHERE id=#{id}")
//    @Results(value = {
//            @Result(column = "id", property = "id"),
//            @Result(column = "name", property = "uName"),
//            @Result(column = "age", property = "uAge"),
//
//    })
    @Select(value = "SELECT *from Register WHERE id=#{id}")
    public RegisterUser findByUserId(int id);


/*    @Select(value = "SELECT id,name,password,Email,code FROM Register WHERE name=#{name}")
    RegisterUser findByName(@Param("name") String name);*/


    @Select(value = "SELECT id,name FROM Register WHERE name=#{name} AND password=#{password}")
    RegisterUser findByNameAndPassword(@Param(value = "name") String name, @Param(value = "password") String password);


   @Select(value = "SELECT *from Register WHERE name=#{name}")
   RegisterUser findByName(@Param("name") String name);

    @Insert(value = "INSERT INTO Register (name,password,Email,code) VALUES (#{user.name},#{user.password},#{user.Email},#{user.code})")
    int insertUser(@Param(value = "user") RegisterUser user);

    @Update(value = "UPDATE Register SET name=#{user.name} WHERE id=#{user.id}")
    int updateUser(@Param(value = "user") RegisterUser user);
}
