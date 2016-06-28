package com.goforit.homework.aop;

/**
 * Created by junqingfjq on 16/5/20.
 */
public class AccountServiceImpl implements AccountService {

    @Override
    public void save(String loginName, String password) {
        System.err.println("login name:"+loginName+",password:"+password);
    }
}
