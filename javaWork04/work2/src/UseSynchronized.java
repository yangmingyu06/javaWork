/**
 * @(#)UseSynchronized.java, 8月 29, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yangmingyu
 */
public class UseSynchronized {

    private int a;

    public void plus() {
        synchronized (this) {
            a ++;
        }
    }

    public int get() {
        synchronized (this) {
            return a;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        UseSynchronized useSynchronized = new UseSynchronized();
        executorService.execute(useSynchronized::plus);
        Thread.sleep(1000);
        System.out.println(useSynchronized.get());
    }
}