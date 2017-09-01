package concurrent.voliatitle;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xiaofengfu on 2017/8/20.
 */
public class VoatitleThread extends Thread {

    private int threadNum;
    ThreadLocal<VolatilePerson> vp = new ThreadLocal<VolatilePerson>();
    private volatile CountDownLatch countDownLatch;
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try{
            VolatilePerson volatilePerson = VolatilePerson.getInstance();//vp.get();
            synchronized (VoatitleThread.class){
                if(null == volatilePerson){
                    volatilePerson = VolatilePerson.getInstance();
                }
            }
            volatilePerson.setName(this.getName());
            volatilePerson.setIdcard(volatilePerson.getIdcard() + 1);
            volatilePerson.setAge(volatilePerson.getAge() + 1);
            vp.set(volatilePerson);
            System.out.println(this.getName());
        }finally{
            System.out.println("subthread.."+countDownLatch.getCount());
            countDownLatch.countDown();
        }
    }

    public int getThreadNum() {
        return threadNum;
    }

    public void setThreadNum(int threadNum) {
        this.threadNum = threadNum;
    }

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
}
