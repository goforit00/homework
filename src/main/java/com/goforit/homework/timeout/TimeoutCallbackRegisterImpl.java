package com.goforit.homework.timeout;

import org.springframework.stereotype.Service;

/**
 * Created by junqingfjq on 16/5/6.
 */

@Service
public class TimeoutCallbackRegisterImpl implements TimeoutCallbackRegister {
    @Override
    public String getTableName() {
        return "aaa";
    }
}
