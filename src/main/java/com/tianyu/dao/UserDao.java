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
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.List;

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
        StringBuffer sql=new StringBuffer(" select password from User where userName=?");
        Query query = session.createQuery(sql.toString());
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
        StringBuffer sql=new StringBuffer(" select userName from User where userName=?");
        Query query = session.createQuery(sql.toString());
        query.setParameter(0, loginName);
        loginName = (String) query.uniqueResult();
        session.close();
        return StringUtils.isEmpty(loginName) ? false : true;
    }

    //注册
    public void insert(User user) throws  Exception{
        Session session = sessionFactory.openSession();
        session.save(user);
        session.close();
    }

    //更新用户信息
    public boolean update(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        StringBuffer sql = new StringBuffer("UPDATE User set ");
        List<String> paramterList = new ArrayList<String>();
        boolean secondUpdateflag = false;
        if (!StringUtils.isEmpty(user.getUserName())) {
            sql.append(" userName=? ");
            paramterList.add(user.getUserName());
            secondUpdateflag = true;
        }
        if (!StringUtils.isEmpty(user.getPassword())) {
            if (secondUpdateflag) {
                sql.append(",");
            }
            sql.append(" password=?");
            paramterList.add(user.getPassword());
        }
        if (!StringUtils.isEmpty(user.getLockStatus())) {
            if (secondUpdateflag) {
                sql.append(",");
            }
            sql.append(" lockStatus=?");
            paramterList.add(user.getLockStatus());
        }
        sql.append(" where userId=?");
        paramterList.add(String.valueOf(user.getUserId()));
        try {
            Query query = session.createQuery(sql.toString());
            int i = 0;
            for (String param : paramterList) {
                if(i==paramterList.size()-1){
                    query.setParameter(i,StringUtils.stringToInteger(param));
                }else {
                    query.setParameter(i, param);
                }
                i++;
            }
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
        session.close();
        return true;
    }
}
