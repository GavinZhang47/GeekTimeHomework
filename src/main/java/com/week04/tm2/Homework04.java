package com.week04.tm2;

import java.util.concurrent.atomic.AtomicLong;

/**
 *AtomicLong
 */
public class Homework04 {


    public static void main(String[] args) {
        AtomicLong atomicLong = new AtomicLong();

        try {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    atomicLong.set(System.currentTimeMillis());
                }
            });
            thread.start();
            thread.join();
            System.err.println("线程返回结果: "+atomicLong);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
