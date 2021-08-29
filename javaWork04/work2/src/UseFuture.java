/**
 * @(#)UseFuture.java, 8月 29, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author yangmingyu
 */
public class UseFuture {

    public String get() {
        return "hello";
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        UseFuture useFuture = new UseFuture();
        Future<String> submit = executorService.submit(() -> {
            Thread.sleep(1000);
            return useFuture.get();
        });
        try {
            System.out.println(submit.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}