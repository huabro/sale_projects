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
    @Transactional(rollbackFor=Exception.class)
    public Boolean insert(String loginName,String password){
        for(int i=1;i<=2;i++) {
            User user = new User();
            if(i==2){
                user.setUserName(null);
            }else {
                user.setUserName(loginName+i);
            }
            user.setPassword(password+i);
            try {
                userDao.insert(user);
            } catch (Exception e) {
                log.error(e.getMessage());
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
        return  true;
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
