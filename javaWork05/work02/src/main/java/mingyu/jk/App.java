package mingyu.jk; /**
 * @(#)App.java, 9月 06, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import org.springframework.stereotype.Component;

/**
 * @author yangmingyu
 */
@Component
public class App {
    public App() {
        System.out.println("mingyu.jk.App 被创建了");
    }

    public void sayHello() {
        System.out.println("hello");
    }
}