package com.goforit.homework.proxy;

import com.goforit.homework.annotate.CaculateTime;

/**
 * Created by junqingfjq on 16/5/4.
 */
public class BusinessProcessorImpl implements BusinessProcessor {

    @Override
    public void processBusiness() {
        System.err.println("processing business...");
    }

    @Override
    @CaculateTime
    public void processBusiness2() {
        System.err.println("processing business 2...");
    }
}
