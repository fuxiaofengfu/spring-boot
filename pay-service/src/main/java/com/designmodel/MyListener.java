package com.designmodel;

/**
 * 事件处理器
 */
public class MyListener implements Listener{

    @Override
    public void changeEvent(MyEvent event) {
        System.out.println("触发MyEvent事件，数据是："+event.getSource().toString());
    }

}
