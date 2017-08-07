package com.jvm;

/**
 * Created by xiaofengfu on 2017/8/5.
 */
public class ClassResolution {

    public ClassInit b;

    interface A{
        public int a = 1;
        public void method();
    }

    public class D {
        public int a = 3;
        public void method(){
            System.out.println("invoke method ....");
        }
    }

    public class E extends D implements A{
       // public static int a = 3;
    }
}
