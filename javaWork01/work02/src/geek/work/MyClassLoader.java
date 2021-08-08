/**
 * @(#)MyClassLoader.java, 8月 07, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package geek.work;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;

/**
 * @author yangmingyu
 */
public class MyClassLoader extends ClassLoader{

    public static void main(String[] args) {
        try {
            final Class<?> helloClass = new MyClassLoader().findClass("Hello");
            final Method helloMethod = helloClass.getMethod("hello");
            helloMethod.invoke(helloClass.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) {

        byte[] bytes = new byte[0];
        try {
            bytes = getFromFile("Hello.xlass");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte)(255 - bytes[i]);
        }
        return defineClass(name,bytes,0,bytes.length);
    }

    private byte[] getFromFile(String path) throws IOException {
        return Files.readAllBytes(new File(path).toPath());
    }
}