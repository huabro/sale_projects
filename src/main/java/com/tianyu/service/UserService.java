package com.tianyu.service;

import com.tianyu.dao.UserDao;
import com.tianyu.pojo.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/1/20 0020.
 */
@Service
public class UserService {

    private static Logger log = LogManager.getLogger(UserService.class);

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
    public Boolean insert(User user,User user2)throws Exception{
        userDao.insert(user);
        userDao.insert(user2);
        return  true;
    }

    /**
     *
     * @param loginName
     * @param password
     */
    @Transactional(rollbackFor=Exception.class)
    public void insert(String loginName,String password){
        User user = new User();
        user.setUserName(loginName);
        user.setPassword(password);

        User user2 = new User();
        user2.setUserName(null);
        user2.setPassword(password);
        try {
            insert(user, user2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //用户信息维护
    @Transactional
    public Boolean update(Integer userId,String loginName,String password,String lockStatus){
        if(userId==null){
            return false;
        }
        User user=new User();
        user.setUserId(userId);
        user.setUserName(loginName);
        user.setPassword(password);
        user.setLockStatus(lockStatus);
        return  userDao.update(user);
    }
}
