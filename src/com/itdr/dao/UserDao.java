package com.itdr.dao;

import com.itdr.pojo.Users;
import com.itdr.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDao {

    public Users selectUser(String username, String password) {
        QueryRunner qr = new QueryRunner(C3P0Util.com());
        Users query = null;
        String sql = "SELECT id,username,password,type,create_time,update_time FROM users WHERE username=? AND password=?";
        try {
            query = qr.query(sql, new BeanHandler<Users>(Users.class), username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public Users selectUsername(String username){
        QueryRunner qr = new QueryRunner(C3P0Util.com());
        Users query = null;
        String sql = "SELECT id,username,password,type,create_time,update_time FROM users WHERE username=?";
        try {
            query = qr.query(sql, new BeanHandler<Users>(Users.class), username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }


    public int zhuCe(String username, String password) {
        QueryRunner qr = new QueryRunner(C3P0Util.com());
        int i = 0;
        SimpleDateFormat sf = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
        Date date = new Date();
        String format = sf.format(date);
        String sql = "INSERT INTO users VALUES (null,?,?,0,?,?)";
        try {
            i = qr.update(sql,username,password,format,format);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

}
