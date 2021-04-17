package com.week04.tm2;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * static
 */
public class Homework03 {
    private static long num;

    public static void main(String[] args) {

        try {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    num = System.currentTimeMillis();
                }
            });
            thread.start();
            thread.join();
            System.err.println("线程返回结果: "+num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
