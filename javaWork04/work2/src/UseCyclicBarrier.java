/**
 * @(#)UseCyclicBarrier.java, 8月 29, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yangmingyu
 */
public class UseCyclicBarrier {

    private AtomicInteger a = new AtomicInteger(0);

    public CyclicBarrier barrier;


    public void plus() throws BrokenBarrierException, InterruptedException {
        a.addAndGet(1);
        barrier.await();
    }

    public AtomicInteger get() {
        return a;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        UseCyclicBarrier useCyclicBarrier = new UseCyclicBarrier();
        useCyclicBarrier.barrier =  new CyclicBarrier(5, () -> {
            System.out.println(useCyclicBarrier.get());
        });

        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> {
                try {
                    useCyclicBarrier.plus();
                } catch (BrokenBarrierException e) {

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}