package com.jvm;

import java.lang.invoke.MethodHandle;

/**
 * Created by xiaofengfu on 2017/8/5.
 */
public class ClassInit extends ClassInitParent{
    static {
        i = 0;
        System.out.println("init ClassInit .......");
    }
    public static int i=11;

    public final static int CONSTANT = 23;
}
