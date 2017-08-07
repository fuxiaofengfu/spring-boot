package com.designmodel;

import java.util.EventObject;

/**
 * 事件对象
 * Created by xiaofengfu on 2017/7/16.
 */
public class MyEvent extends EventObject {
    //事件状态改变
    private boolean ischanged;
    //数据源
    private Object source;

    public MyEvent(Object source,boolean ischanged) {
        super(source);
        this.source = source;
        this.ischanged = ischanged;
    }

    @Override
    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public boolean isIschanged() {
        return ischanged;
    }

    public void setIschanged(boolean ischanged) {
        this.ischanged = ischanged;
    }
}
