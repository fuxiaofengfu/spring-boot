package com.test;

import com.jvm.ClassInit;
import com.jvm.ClassInitInterface;
import com.jvm.ClassResolution;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by xiaofengfu on 2017/7/31.
 */
public class TestJVM{

    static {
        System.out.println("init TestJVM.....");
    }

    @Test
    public void test(){
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                System.out.println("加载类。。。"+name);
                String className = name.substring(name.lastIndexOf(".")+1) + ".class";
                InputStream inputStream = getClass().getResourceAsStream(className);
                if(null == inputStream){
                   return super.loadClass(name);
                };
                try {
                    System.out.println("自定义类加载....");
                    int len = inputStream.available();
                    byte[] bytes = new byte[len];
                    inputStream.read(bytes);
                    return defineClass(name,bytes,0,bytes.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                throw new ClassNotFoundException("类没有找到。。。。。");
            }
        };
        try {
            Object loadClass = classLoader.loadClass("com.classload.LoadClass").newInstance();
            System.out.println(loadClass.getClass());
            if(loadClass instanceof  TestJVM){
                System.out.println("...77777777");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test2(){
        TestRT testRT = new TestRT();
    }

    @Test
    public void test3(){
        //System.out.println(ClassInit.parentProperty);
        //ClassInit arr[] = new ClassInit[1];
        //
        //System.out.println(ClassInitInterface.j);

        //new ClassResolution().new E().method();
        System.out.println(ClassInit.CONSTANT);
    }
}
