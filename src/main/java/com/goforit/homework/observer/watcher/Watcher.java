package com.goforit.homework.observer.watcher;

/**
 * Created by junqingfjq on 15/11/22.
 */
public interface Watcher {

    public void update(Object obj);

    public boolean equals(Watcher watcher);
}
