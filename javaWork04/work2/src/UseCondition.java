/**
 * @(#)UseCondition.java, 8月 29, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangmingyu
 */
public class UseCondition {

    private int a = 1;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public String get() {
        lock.lock();
        try {
            while (a == 1) {
                condition.await();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return "hello";
    }

    public void signal() {
        lock.lock();
        try {
            a = 2;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        UseCondition useCondition = new UseCondition();
        Future<String> submit = executorService.submit(useCondition::get);
        System.out.println(submit.isDone());
        Thread.sleep(2000);
        useCondition.signal();
        System.out.println(submit.get());
    }
}