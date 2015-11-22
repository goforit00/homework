package com.goforit.homework.watcher;

/**
 * Created by junqingfjq on 15/11/22.
 */
public interface Watched {

    public void addWatcher(Watcher watcher);

    public void deleteWatcher(Watcher watcher);

    public void notifiedWatcher(Object obj);
}
