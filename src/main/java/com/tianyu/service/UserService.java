package com.tianyu.service;

import com.tianyu.dao.UserDao;
import com.tianyu.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/1/20 0020.
 */
@Service
public class UserService {

    @Resource
    UserDao userDao;
    //登录判断
    @Transactional
    public int loginJudge(String loginName, String pwd) {
        return  userDao.loginJudge(loginName,pwd);
    }
    //注册判断
    public boolean userExist(String loginName){
        return  userDao.userExist(loginName);
    }
    //新增用户
    @Transactional
    public Boolean insert(String loginName,String password){
        User user=new User();
        user.setUserName(loginName.trim());
        user.setPassword(password.trim());
        return  userDao.insert(user);
    }
    //用户信息维护
    @Transactional
    public Boolean update(Integer userId,String loginName,String password){
        User user=new User();
        user.setUserId(userId);
        user.setUserName(loginName.trim());
        user.setPassword(password.trim());
        return  userDao.update(user);
    }
}
