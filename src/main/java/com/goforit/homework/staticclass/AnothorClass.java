package com.goforit.homework.staticclass;

/**
 * Created by junqingfjq on 16/5/30.
 */
public class AnothorClass {

    public void test(){
        StaticClassTest.C1 c1=new StaticClassTest().new C1();

        c1.c1Fun();


        StaticClassTest.StaticC1 staticC1=new StaticClassTest.StaticC1();
        staticC1.c1Fun();
    }
}
