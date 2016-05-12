package com.goforit.homework.timeout;

/**
 * Created by junqingfjq on 16/5/6.
 */
public enum TimeoutCallbackFactory {

    INSTANCE{
        @Override
        boolean register() {
            return false;
        }
    };


    abstract boolean register();
}
