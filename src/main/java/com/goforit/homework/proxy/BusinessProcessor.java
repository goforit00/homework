package com.goforit.homework.proxy;


import com.goforit.homework.annotate.CaculateTime;

/**
 * Created by junqingfjq on 16/5/4.
 */
public interface BusinessProcessor {

    @CaculateTime
    public void processBusiness();

    public void processBusiness2();
}
