package com.tianyu.dao;

import com.alibaba.druid.util.StringUtils;
import com.tianyu.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/1/20 0020.
 */
@Repository
public class UserDao {
    @Resource
    SessionFactory sessionFactory;

    private static Logger log = LogManager.getLogger(UserDao.class);


    //登录判断
    public int loginJudge(String loginName, String password) {
        int flag = 0;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" select password from book_user where userName=?");
        query.setParameter(0, loginName);
        String pwd = (String) query.uniqueResult();
        if (StringUtils.equals(pwd, password))
            flag = 1;
        else {
            flag = 2;
        }
        session.close();
        return flag;
    }

    //登录判断
    public boolean userExist(String loginName) {
        int flag = 0;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" select userName from book_user where userName=?");
        query.setParameter(0, loginName);
         loginName = (String) query.uniqueResult();
        session.close();
        return StringUtils.isEmpty(loginName)?false:true;
    }

    //注册
    public boolean insert(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
        session.close();
        return true;
    }
    //更新用户信息
    public boolean update(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
        session.close();
        return true;
    }
}
