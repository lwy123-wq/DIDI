package com.sun.didi.dao;

import com.sun.didi.annotation.Cache;
import com.sun.didi.entity.RegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
//@CacheConfig(cacheNames = "user")
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


//
//    public RegisterUser findByUserId(int id) {
//        final RegisterUser user = new RegisterUser();
//        String sql = "SELECT id,name,age FROM t_user WHERE id=?";
//        jdbcTemplate.query(sql, new Object[]{id}, new RowCallbackHandler() {
//            @Override
//            public void processRow(ResultSet resultSet) throws SQLException {
//                user.setPasswd(resultSet.getString(1));
//                user.setName(resultSet.getString(2));
//                user.setEmail(resultSet.getString(3));
//            }
//        });
////        List list = jdbcTemplate.queryForObject(sql, new Object[]{id}, List.class);
//        return user;
//    }

    @Cache
    public RegisterUser findByName(String name) {

        final RegisterUser user = new RegisterUser();
        String sql = "SELECT name,password,Email FROM Register WHERE name=?";
        jdbcTemplate.query(sql, new Object[]{name}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setName(resultSet.getString(1));
                user.setPasswd(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
            }
        });
        return user;
    }

    public RegisterUser select(String name, String password,String email) {

        final RegisterUser user = new RegisterUser();
        String sql = "SELECT name,password,Email FROM Register WHERE name=? AND password=? AND Email=?";
        jdbcTemplate.query(sql, new Object[]{name, password,email}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setName(resultSet.getString(1));
                user.setPasswd(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));

            }
        });
        return user;
    }

    public int insertUser(RegisterUser user) {
        String sql = "INSERT INTO Register (name,password,Email)VALUES (?,?,?)";
        return jdbcTemplate.update(sql, user.getName(),user.getPasswd(), user.getEmail());
    }


//    public int updateUser(User user) {
//        String sql = "UPDATE t_user SET name=? WHERE id=?";
//        return jdbcTemplate.update(sql, user.getName(), user.getId());
//    }
}
