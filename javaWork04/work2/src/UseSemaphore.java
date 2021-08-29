/**
 * @(#)Semaphore.java, 8月 29, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yangmingyu
 */
public class UseSemaphore {

    private AtomicInteger a = new AtomicInteger(0);

    final Semaphore semaphore = new Semaphore(3);

    public void plus() {
        try {
            semaphore.acquire();
            a.getAndAdd(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public AtomicInteger get(){
        try {
            semaphore.acquire();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            return a;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        UseSemaphore useSemaphore = new UseSemaphore();
        for (int i = 0; i < 5; i++) {
            executorService.execute(useSemaphore::plus);
        }
        Thread.sleep(1000);
        System.out.println(useSemaphore.get());
    }

}