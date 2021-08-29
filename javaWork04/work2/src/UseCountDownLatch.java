/**
 * @(#)UseCountDownLatch.java, 8月 29, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yangmingyu
 */
public class UseCountDownLatch {

    private AtomicInteger a = new AtomicInteger(0);

    public CountDownLatch countDownLatch = new CountDownLatch(10);

    public void plus() {
        a.addAndGet(1);
        countDownLatch.countDown();
    }

    public AtomicInteger get() {
        return a;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        UseCountDownLatch useCountDownLatch = new UseCountDownLatch();

        for (int i = 0; i < 10; i++) {
            executorService.execute(useCountDownLatch::plus);
        }

        useCountDownLatch.countDownLatch.await();
        System.out.println(useCountDownLatch.get());
    }
}