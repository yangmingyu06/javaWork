/**
 * @(#)UseCompletableFuture.java, 8月 29, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yangmingyu
 */
public class UseCompletableFuture {

    private AtomicInteger a = new AtomicInteger(0);


    public AtomicInteger plus() {
        a.addAndGet(1);
        return a;
    }

    public static void main(String[] args) {
        UseCompletableFuture useCompletableFuture = new UseCompletableFuture();
        CompletableFuture.supplyAsync(() -> useCompletableFuture.plus()).thenAccept(v -> System.out.println(v));
    }
}