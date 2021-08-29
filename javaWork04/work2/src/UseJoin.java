/**
 * @(#)UseJoin.java, 8月 29, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author yangmingyu
 */
public class UseJoin {

    public static void main(String[] args) throws InterruptedException {
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        atomicBoolean.set(false);
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicBoolean.set(true);
        });
        thread.start();
        thread.join();
        System.out.println(atomicBoolean);
    }
}