package com.tianyu.service;

import com.tianyu.dao.UserDao;
import com.tianyu.pojo.User;
import com.tianyu.util.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import javax.transaction.TransactionScoped;

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
        return userDao.loginJudge(loginName, pwd);
    }

    //注册判断
    public boolean userExist(String loginName) {
        return userDao.userExist(loginName);
    }

    /**
     * 新增用户
     *
     * @param loginName
     * @param password
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public void insert(String loginName, String password) {
        User user = new User();
        user.setUserName(loginName);
        user.setPassword(password);

        User user2 = new User();
        user2.setUserName(null);
        user2.setPassword(password);
        try {
            userDao.insert(user);
            userDao.insert(user2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //用户信息维护
    @Transactional()
    public Boolean update(Integer userId, String loginName, String password, String lockStatus) throws Exception {
        if (userId == null) {
            return false;
        }
        User user = new User();
        user.setUserId(userId);
        user.setUserName(loginName);
        user.setPassword(password);
        user.setLockStatus(lockStatus);

        userDao.update(user, "");
        int i = 1 / 0;

        return true;
    }

    /**
     * 测试调用事务方法
     * 同类中未事务的方法A，调用事务方法B：触发事务?
     *
     * @param userId
     * @param loginName
     * @param password
     * @param lockStatus
     * @return
     */
    public boolean propa(Integer userId, String loginName, String password, String lockStatus) throws Exception {
        return this.update(userId, loginName, password, lockStatus);
    }
}
