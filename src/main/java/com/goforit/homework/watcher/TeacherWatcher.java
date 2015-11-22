package com.goforit.homework.watcher;

/**
 * Created by junqingfjq on 15/11/22.
 */
public class TeacherWatcher implements Watcher {

    private String name="";

    @Override
    public void update(Object obj) {
        System.err.println("teacher "+this.name+" get notified:"+obj);
    }

    @Override
    public boolean equals(Watcher watcher) {


        if(watcher instanceof TeacherWatcher){
            return this.name.equals(((TeacherWatcher) watcher).getName());
        }

        return false;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
