package com.week04.tm2;

/**
 * final
 */
public class Homework09 {

    public static void main(String[] args) {

        final long[] num = new long[1];

        try {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    num[0] = System.currentTimeMillis();
                }
            });
            thread.start();
            thread.join();
            System.err.println("线程返回结果: " + num[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
