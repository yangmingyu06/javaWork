/**
 * @(#)UseFutureTask.java, 8月 29, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author yangmingyu
 */
public class UseFutureTask {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        FutureTask<String> stringFutureTask = new FutureTask<>(() -> {
            return "hello";
        });

        executorService.submit(stringFutureTask);
        try {
            System.out.println(stringFutureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}