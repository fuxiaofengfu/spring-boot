package com.designmodel.javaobserve;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者,当观察对象改变触发事件时执行业务处理
 * Created by xiaofengfu on 2017/7/20.
 */
public class JavaObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        JavaObservable javaEvent = (JavaObservable)o;
        //事件数据
        String str = arg.toString();
        System.out.println("观察到JavaObservable改变，数据："+str);
        //TODO 具体业务逻辑
    }
}
