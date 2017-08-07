package com.jvm;

/**
 * Created by xiaofengfu on 2017/8/5.
 */
public class ClassInitParent {
    static {
        System.out.println("init ClassInitParent ....");
    }
    public static int parentProperty = 111;
}
