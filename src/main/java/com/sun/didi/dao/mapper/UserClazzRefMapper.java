package com.sun.didi.dao.mapper;

import com.sun.didi.entity.RegisterUser;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserClazzRefMapper {


    @Select(value = "SELECT user_id,clazz_id FROM t_clazz_user_ref WHERE user_id=#{id}")
    RegisterUser findByUserId(@Param("id") int id);

    @Select(value = "SELECT user_id FROM t_clazz_user_ref WHERE clazz_id=#{clazzId}")
    List<Integer> findByClazzId(@Param("clazzId") int clazzId);

    @Insert(value = "INSERT INTO t_clazz_user_ref (user_id,clazz_id) VALUES (#{userClazzRef.userId},#{userClazzRef.clazzId})")
    int insertUserClazzRef(@Param("userClazzRef") RegisterUser userClazzRef);

    @Update(value = "UPDATE t_clazz_user_ref SET clazz_id=#{userClazzRef.clazzId} WHERE user_id=#{userClazzRef.userId}")
    int updateUserClazzRef(@Param("userClazzRef") RegisterUser userClazzRef);
}
