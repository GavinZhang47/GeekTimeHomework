package com.week04.tm2;

import java.util.concurrent.*;

/**
 * future 和 Callable
 */
public class Homework01 {

    public static void main(String[] args) {

        try {
            ExecutorService executorService = Executors.newCachedThreadPool();
            Future<Long> result = executorService.submit(new Callable<Long>() {
                @Override
                public Long call() {
                    return System.currentTimeMillis();
                }
            });
            executorService.shutdown();

            System.err.println("线程返回结果: "+result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
