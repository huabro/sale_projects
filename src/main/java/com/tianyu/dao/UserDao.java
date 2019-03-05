package com.tianyu.dao;

import com.alibaba.druid.util.StringUtils;
import com.tianyu.pojo.User;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/20 0020.
 */
@Repository
public class UserDao extends HibernateDaoSupport {

    @Autowired
    public UserDao(SessionFactory sf) {
        super.setSessionFactory(sf);
    }

    //登录判断
    public int loginJudge(String loginName, String password) {
        int flag = 0;
        StringBuffer sql = new StringBuffer("from User where userName=?");
        String[] params = new String[1];
        params[0] = loginName;
        List<User> userList = (List<User>) this.getHibernateTemplate().find(sql.toString(), params);
        if (userList != null && userList.size() > 0) {
            if (StringUtils.equals(userList.get(0).getPassword(), password))
                flag = 1;
            else {
                flag = 2;
            }
        }
        return flag;
    }

    //注册判断用户名是否重复
    public boolean userExist(String loginName) {
        boolean flag = false;
        StringBuffer sql = new StringBuffer(" from User where userName=?");
        String[] params = new String[1];
        params[0] = loginName;

        List<User> userList = (List<User>) this.getHibernateTemplate().find(sql.toString(), params);
        if (!(userList != null && userList.size() > 0)) {
            flag = true;
        }
        return flag;
    }

    //注册
    public void insert(User user) throws Exception {
        this.getHibernateTemplate().save(user);
    }

    //更新用户信息
    public boolean update(User user) throws Exception {

        StringBuffer sql = new StringBuffer("UPDATE User set ");
        final List<String> paramterList = new ArrayList<String>();
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
        final String actionSql = sql.toString();

        Object execute = this.getHibernateTemplate().execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(actionSql);
                int i = 0;
                for (String param : paramterList) {
                    if (i == paramterList.size() - 1) {
                        query.setParameter(i, StringUtils.stringToInteger(param));
                    } else {
                        query.setParameter(i, param);
                    }
                    i++;
                }
                return query.executeUpdate();
            }
        });
        int result = Integer.parseInt(String.valueOf(execute));
        return result > 0 ? true : false;
    }
}
