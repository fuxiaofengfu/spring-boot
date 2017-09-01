package concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created by xiaofengfu on 2017/8/23.
 */
public class ABA {

    public static void main(String[] args) {
        AtomicInteger atomicInteger =  new AtomicInteger(100);
        AtomicStampedReference atomicStampedReference = new AtomicStampedReference(100,0);
        Thread t1 =  new Thread(){
            @Override
            public void run() {
                boolean cas = atomicInteger.compareAndSet(100,200);
                System.out.println(cas +"==" +atomicInteger.get());
                boolean cass = atomicInteger.compareAndSet(200,100);
                System.out.println(cas + "===="+atomicInteger.get());
            }
        };
        Thread t2 =  new Thread(){
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                boolean cas = atomicInteger.compareAndSet(100,200);
                System.out.println(cas + "=="+atomicInteger.get());
            }
        };
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t3 = new Thread(){
            @Override
            public void run() {
                /*try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                boolean bool = atomicStampedReference.compareAndSet(100,200,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
                System.out.println(bool+"=="+atomicStampedReference.getReference());
                bool = atomicStampedReference.compareAndSet(100,1000,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
                System.out.println(bool+"=="+atomicStampedReference.getReference());
            }
        };
        Thread t4 = new Thread(){
            @Override
            public void run() {
                /*try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                int stamp = atomicStampedReference.getStamp();
                boolean bool = atomicStampedReference.compareAndSet(200,100,stamp,stamp);
                System.out.println(bool+"=="+atomicStampedReference.getReference());
            }
        };

        t3.run();
        t4.run();
        //System.out.println(atomicStampedReference.getReference());
    }
}
