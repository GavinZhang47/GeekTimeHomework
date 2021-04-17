package com.week04.tm2;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 *FutureTask 和 Callable
 */
public class Homework02 {

    public static void main(String[] args) {

        try {
            FutureTask<Long> longFutureTask = new FutureTask<>(new Callable<Long>() {
                @Override
                public Long call() throws Exception {
                    return System.currentTimeMillis();
                }
            });
            new Thread(longFutureTask).start();

            System.err.println("线程返回结果: "+longFutureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
