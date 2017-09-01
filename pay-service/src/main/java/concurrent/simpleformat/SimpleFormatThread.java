package concurrent.simpleformat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xiaofengfu on 2017/8/29.
 */
public class SimpleFormatThread {

    private static  SimpleDateFormat simpleDateFormat = new SimpleDateFormat();


    public static void format(Date date){

        String str = simpleDateFormat.format(date);
        //System.out.println("simpleDateFormat="+simpleDateFormat.hashCode()+"//"+str);
    }

    public static void main(String[] args) {
        Date date = new Date();
        for (;;) {
            Thread thread = new Thread(){
                @Override
                public void run() {
                    try {
                        System.out.println(this.hashCode());
                        this.join(2000);
                        SimpleFormatThread.format(date);
                    }catch (Exception e){
                        System.out.println("----------");
                        System.exit(11);
                    }
                }
            };
            System.out.println(thread.hashCode());
            thread.start();
        }
    }
}
