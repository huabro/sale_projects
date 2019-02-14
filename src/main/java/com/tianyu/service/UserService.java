package com.tianyu.service;

import com.tianyu.dao.UserDao;
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
    public Boolean register(String loginName,String password,String email){
        return  userDao.register(loginName,password,email);
    }
}
