package com.goforit.homework.staticclass;

/**
 * Created by junqingfjq on 16/5/30.
 */
public class StaticClassTest {

    public static void main(String argv[]){

        AnothorClass ac=new AnothorClass();
        ac.test();
    }

    class C1{

        private String a="hello world";
        public void c1Fun(){
            System.err.println(a);
        }
    }

    static class StaticC1{
        private String a="hello static";

        public void c1Fun(){
            System.err.println(a);
        }
    }
}
