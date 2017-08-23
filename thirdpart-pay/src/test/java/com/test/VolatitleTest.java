package com.test;

import concurrent.voliatitle.VoatitleThread;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xiaofengfu on 2017/8/20.
 */
public class VolatitleTest {

    @Test
    public void test1(){
        CountDownLatch countDownLatch = new CountDownLatch(250);
        for (int i = 1; i <= 250; i++) {
            VoatitleThread voatitleThread = new VoatitleThread();
            voatitleThread.setName("线程序号："+i);
            voatitleThread.setCountDownLatch(countDownLatch);
            voatitleThread.setThreadNum(i);
            voatitleThread.start();
        }
        try {
            countDownLatch.await();
            System.out.println("mainThread..." + countDownLatch.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
