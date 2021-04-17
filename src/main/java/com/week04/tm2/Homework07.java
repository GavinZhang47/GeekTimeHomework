package com.week04.tm2;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 *CopyOnWriteArrayList
 */
public class Homework07 {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Object> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        try {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    copyOnWriteArrayList.add(System.currentTimeMillis());
                }
            });
            thread.start();
            thread.join();
            System.err.println("线程返回结果: "+copyOnWriteArrayList.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
