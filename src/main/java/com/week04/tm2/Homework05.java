package com.week04.tm2;

import java.util.concurrent.atomic.AtomicLong;

/**
 *volatile
 */
public class Homework05 {

    private volatile long num;

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public static void main(String[] args) {

        Homework05 homework05 = new Homework05();

        try {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    homework05.num=System.currentTimeMillis();
                    homework05.setNum(System.currentTimeMillis());
                }
            });
            thread.start();
            thread.join();
            System.err.println("线程返回结果: "+homework05.num);
            System.err.println("线程返回结果: "+homework05.getNum());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
