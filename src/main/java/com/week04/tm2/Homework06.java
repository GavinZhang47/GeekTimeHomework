package com.week04.tm2;

import java.util.concurrent.CompletableFuture;

/**
 *CompletableFuture
 */
public class Homework06 {

    public static void main(String[] args) {

        try {
            CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync(() -> {
                return System.currentTimeMillis();
            });
            CompletableFuture<Long> completableFuture2 = completableFuture.thenApplyAsync(v -> v + System.currentTimeMillis());
            Long result = completableFuture2.join();
            System.err.println("线程返回结果: "+result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
