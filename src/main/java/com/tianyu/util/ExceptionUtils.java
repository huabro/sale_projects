package com.tianyu.util;

/**
 * @description: 异常工具类
 * @author: WSZ
 * @create: 2019-03-04 19:38
 **/
public class ExceptionUtils extends RuntimeException{

    public ExceptionUtils(){}

    public ExceptionUtils(String message){
        super(message);
    }
}