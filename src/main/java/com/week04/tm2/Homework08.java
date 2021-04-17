package com.week04.tm2;

import java.util.concurrent.ConcurrentHashMap;

/**
 *ConcurrentHashMap
 */
public class Homework08 {

    public static void main(String[] args) {
        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();

        try {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    concurrentHashMap.put("time",System.currentTimeMillis());
                }
            });
            thread.start();
            thread.join();
            System.err.println("线程返回结果: "+concurrentHashMap.get("time"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
