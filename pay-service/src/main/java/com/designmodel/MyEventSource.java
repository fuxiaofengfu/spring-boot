package com.designmodel;

import java.util.List;
import java.util.Vector;

/**
 * 事件源
 */
public class MyEventSource {

    private Vector<Listener> listeners = new Vector<Listener>();
    //添加事件
    public void addListener(Listener listener){
        listeners.add(listener);
    }

    private static MyEvent myEvent = null;

    public void change(Object  arg){
        synchronized (this){
            if(null == myEvent){
                myEvent = new MyEvent(arg,true);
            }
        }
        for (int i = 0; i <listeners.size() ; i++) {
            if(myEvent.isIschanged()){
                listeners.get(i).changeEvent(myEvent);
            }
        }
    }
}
