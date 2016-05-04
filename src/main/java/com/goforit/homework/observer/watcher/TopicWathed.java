package com.goforit.homework.observer.watcher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junqingfjq on 15/11/22.
 */
public class TopicWathed implements Watched {

    private List<Watcher> watchers =new ArrayList<Watcher>();

    @Override
    public void addWatcher(Watcher watcher) {
        if( watcher == null){
            return;
        }

        for(Watcher w:watchers){
            if(w.equals(watcher)){
                return;
            }
        }

        watchers.add(watcher);
    }

    @Override
    public void deleteWatcher(Watcher watcher) {
        if(watcher==null){
            return;
        }
        for( Watcher w:watchers){
            if(w.equals(watcher)){
                watchers.remove(watcher);
            }
        }

    }

    @Override
    public void notifiedWatcher(Object obj) {
        for( Watcher w: watchers){
            w.update(obj);
        }
    }


    public static void main(String [] argvs){

        Watched topicWatched=new TopicWathed();

        StudentWatcher stuWatcher=new StudentWatcher();
        TeacherWatcher teaWatcher=new TeacherWatcher();

        stuWatcher.setName("jx");
        teaWatcher.setName("fjq");

        topicWatched.addWatcher(stuWatcher);
        topicWatched.addWatcher(teaWatcher);

        topicWatched.notifiedWatcher("you are a watcher");
    }
}
