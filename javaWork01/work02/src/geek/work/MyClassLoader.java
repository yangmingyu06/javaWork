/**
 * @(#)MyClassLoader.java, 8月 07, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package geek.work;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yangmingyu
 */
public class MyClassLoader extends ClassLoader {

    public static void main(String[] args)
            throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        final Class<?> helloClass = new MyClassLoader().findClass("Hello");
        final Method helloMethod = helloClass.getMethod("hello");
        helloMethod.invoke(helloClass.newInstance());
    }

    @Override
    protected Class<?> findClass(String className) {
        byte[] helloClassBytes = getFromFile("Hello.xlass");
        return defineClass(className, helloClassBytes, 0, helloClassBytes.length);
    }

    private static byte[] getFromFile(String path) {
        try (
            final FileInputStream fi = new FileInputStream(path);
        ) {
            final byte[] bytes = new byte[1000];
            int len = 0;
            while (true) {
                final int cnt = fi.read(bytes);
                if (cnt == -1) {
                    break;
                }
                len += cnt;
            }
            final byte[] classBytes = new byte[len];
            for (int i = 0; i < len; i++) {
                classBytes[i] = (byte)(255 - bytes[i]);
            }
            return classBytes;
        } catch (Exception e) {
            throw new RuntimeException("解析出错");
        }
    }
}