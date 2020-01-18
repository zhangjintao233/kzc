package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.UserDao;
import com.itdr.pojo.Users;

public class UserService2 implements UserService{

    private UserDao userDao = new UserDao();

    @Override
    public ResponseCode<Users> login(String username, String password) {
        if (username == null || "".equals(username)){
            return ResponseCode.toDefeated("登录失败");
        }

        if (password == null || "".equals(password)){
            return ResponseCode.toDefeated("登录失败");
        }

        Users users = userDao.selectUser(username, password);
        if (users == null){
            return ResponseCode.toDefeated("登录失败");
        }
        return ResponseCode.toSuccess(users);
    }

    @Override
    public ResponseCode zhuCe(String username, String password) {
        if (username == null || "".equals(username)){
            return ResponseCode.toDefeated("账号不能为空");
        }

        if (password == null || "".equals(password)){
            return ResponseCode.toDefeated("密码不能为空");
        }

        Users users = userDao.selectUsername(username);
        if (users != null){
            return ResponseCode.toDefeated("用户名已存在");
        }


        int i = userDao.zhuCe(username, password);
        return ResponseCode.toSuccess(i);
    }
}
