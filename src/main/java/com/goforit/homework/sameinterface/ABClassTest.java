package com.goforit.homework.sameinterface;

/**
 * Created by junqingfjq on 16/6/1.
 */
public class ABClassTest implements AInterface,BInterface {
    @Override
    public void sameFunc(String aaa) {
        System.err.println("In ABClass ."+aaa);
    }

    @Override
    public void different(String bbb) {

    }

    @Override
    public void differentA(String aaa) {

    }

    public static void main(String [] argv){
        ABClassTest test=new ABClassTest();
        AInterface atest=test;
        BInterface btest=test;
        atest.sameFunc("aaa");
        btest.sameFunc("bbb");
    }
}
