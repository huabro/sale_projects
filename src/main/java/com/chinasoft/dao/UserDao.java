package com.chinasoft.dao;

import com.chinasoft.mapper.UserMapper;
import com.chinasoft.pojo.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/1/20 0020.
 */
@Repository
public class UserDao {
    @Resource
    UserMapper userMapper;

    //登录判断
    public int loginJudge(String loginName, String pwd) {
        int flag = 0;
        String userPwd = null;
        try {
            userPwd = userMapper.loginJudge(loginName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (userPwd != null) {
            if (pwd.equals(userPwd))
                flag = 1;
            else {
                flag = 2;
            }
        }
        return flag;
    }
    //注册判断
    public Boolean register(String loginName,String password,String email){
        String name=userMapper.userIsExist(loginName);
        if(name!=null)
        return true;
        else {
            User user=new User();
            user.setLoginName(loginName);
            user.setEmail(email);
            user.setPassword(password);
            userMapper.insert(user);
            return false;
        }
    }
}
