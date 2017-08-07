package com.designmodel;

import java.util.EventListener;

/**
 * 监听器
 */
public interface Listener extends EventListener {

    public void changeEvent(MyEvent event);
}
