package com.jvm;

/**
 * Created by xiaofengfu on 2017/7/30.
 */
public class MyJvm {

    //方法区
    private final int i=0;
    //方法区
    private static int j = 0;
    //heap区
    private int k = 0;
    //heap区
    private Object obj = new Object();

    //栈
    private void method1(){
        //局部变量表
        int m = i + j;
        //入栈
        method2();
        return;
    }

    //栈
    private void method2() {
    }




}
