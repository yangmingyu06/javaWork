/**
 * @(#)Hello.java, 8月 07, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package geek.work;

/**
 * @author yangmingyu
 */
public class Hello {
    public static void main(String[] args) {
        int a = 10;
        int b = 2;
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                System.out.println(a + b);
            }
            if (i == 1) {
                System.out.println(a - b);
            }
            if (i == 2) {
                System.out.println(a * b);
            }
            if (i == 3) {
                System.out.println(b / a);
            }
        }
    }
}