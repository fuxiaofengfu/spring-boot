package com.test;

import com.designmodel.MyEventSource;
import com.designmodel.MyListener;
import com.designmodel.data.XuehaiwuyaPerson;
import com.designmodel.javaobserve.JavaObserver;
import com.designmodel.javaobserve.ObserveSource;
import com.hashmap.Person;
import org.junit.Test;

import java.util.*;

/**
 * Created by xiaofengfu on 2017/7/20.
 */
public class JavaTest {

    @Test
    public void test() {
        //数据源
        XuehaiwuyaPerson chatsPerson = new XuehaiwuyaPerson();
        //事件源
        MyEventSource myEventSource = new MyEventSource();
        //注册监听器
        myEventSource.addListener(new MyListener());

        chatsPerson.setUsername("学海无涯小时候");
        chatsPerson.setAge("1");
        //传递数据源，告知事件源发生事件改变
        myEventSource.change(chatsPerson);

        chatsPerson.setUsername("学海无涯长大中");
        chatsPerson.setAge("2");
        myEventSource.change(chatsPerson);

        chatsPerson.setUsername("学海无涯长大了");
        chatsPerson.setAge("3");
        myEventSource.change(chatsPerson);
    }

    @Test
    public void test2(){
        //创建观察源
        ObserveSource eventSource = new ObserveSource();
        //添加观察者
        eventSource.addListener(new JavaObserver());

        XuehaiwuyaPerson person = new XuehaiwuyaPerson();
        person.setAge("1");
        person.setUsername("小孩");
        eventSource.notifyEvent(person);

        person.setAge("2");
        person.setUsername("中孩");
        eventSource.notifyEvent(person);

        person.setAge("3");
        person.setUsername("大孩");
        eventSource.notifyEvent(person);
    }

    @Test
    public void test3(){
        Person person1 = new Person("1234","人1","12");
        Person person2 = new Person("1234","人2","13");
        System.out.println("equals比较>>>>"+person1.equals(person2));
        System.out.println("==比较>>>"+(person1==person2));
        System.out.println("--------分界线---------");
        HashMap<Person,String> map = new HashMap<Person,String>();

        map.put(person1,"学海无涯1");
        map.put(person2,"学海无涯2");
        System.out.println("//验证值会被替换...");
        System.out.println("通过person1--key获取value...."+map.get(person1));
        System.out.println("通过person2--key获取value...."+map.get(person2));
        System.out.println("--------分界线---------");
        System.out.println("//验证key不会替换....");
        for(Person key : map.keySet()){
            System.out.println("遍历key---"+key.getName());
        }
    }


    private static int totalTime=0;
    @Test
    public void test4(){
        //执行一千次
        for (int i = 0; i < 1000; i++) {
             new Thread(){
                 @Override
                 public void run() {
                     testPutMap();
                 }
             }.start();
        }

        int avg = totalTime/1000;
        System.out.println("hashcode不同时：总耗时："+totalTime);
        System.out.println("hashcode不同时：平均耗时。。。"+avg);
    }
    public static void testPutMap(){
        Map<Person,String> map = new HashMap<Person,String>(5,1);
        long now = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Person person1 = new Person("1234"+i,"人"+i,"0"+i);
            map.put(person1,"学海无涯");
        }
        long after = System.currentTimeMillis();
        totalTime += after - now;
        //System.out.println("当hashcode相等时放入10000个耗时。。。。"+ totalTime+"。。map长度："+map.size());
    }

    @Test
    public void test5(){
        List<Object> list = new ArrayList<Object>();
        while(true){
            list.add(new Object());
        }
    }
}
