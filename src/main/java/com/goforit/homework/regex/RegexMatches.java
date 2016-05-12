package com.goforit.homework.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by junqingfjq on 16/5/12.
 */
public class RegexMatches {

    public static void main(String argv[]){
        String line="haxcaf@qq.com";

//        String pattern="^[a-z]\\w{1,5}@[a-zA-Z0.9]{2,5}\\.com";
        String pattern="^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

        Pattern r=Pattern.compile(pattern);

        Matcher m=r.matcher(line);

        if(m.find()){
            System.out.println(m.groupCount());
            System.out.println("Found value: " + m.group() );
            m.replaceFirst("xxx");
            System.out.println("Found value: " + m.replaceFirst("xxx") );


        }else {
            System.out.println("NO MATCH");
        }
    }
}
