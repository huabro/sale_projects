package com.tianyu.mapper;

import com.tianyu.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/1/20 0020.
 */
public interface UserMapper {
    String loginJudge(@Param("loginName")String loginName);
    void insert(User user);
    String userIsExist(@Param("loginName")String loginName);
}
