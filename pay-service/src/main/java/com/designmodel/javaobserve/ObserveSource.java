package com.designmodel.javaobserve;

import java.util.Observer;

/**
 * Created by xiaofengfu on 2017/7/20.
 */
public class ObserveSource {

    private JavaObservable observable = new JavaObservable();
    //添加观察者
    public void addListener(Observer javaListener){
        observable.addObserver(javaListener);
    }
    //添加观察者
    public void removeListener(Observer javaListener){
        observable.deleteObserver(javaListener);
    }
    //通知事件执行
    public void notifyEvent(Object obj){
        observable.action(obj);
    }
}
