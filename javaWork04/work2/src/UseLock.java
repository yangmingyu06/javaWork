/**
 * @(#)UseLock.java, 8月 29, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangmingyu
 */
public class UseLock {

    private AtomicInteger a = new AtomicInteger(0);

    private Lock lock = new ReentrantLock();

    public void plus() {
        lock.lock();
        try {
            a.getAndAdd(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public AtomicInteger get(){
        lock.lock();
        try {
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
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