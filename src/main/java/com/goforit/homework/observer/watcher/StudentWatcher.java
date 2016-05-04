package com.goforit.homework.observer.watcher;

/**
 * Created by junqingfjq on 15/11/22.
 */
public class StudentWatcher implements Watcher {

    private String name="";


    @Override
    public void update(Object obj) {
        System.err.println("student "+this.name+" get notified:"+obj);
    }

    @Override
    public boolean equals(Watcher watcher) {

        if(watcher instanceof StudentWatcher){
            return this.name.equals(((StudentWatcher) watcher).getName());
        }

        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
