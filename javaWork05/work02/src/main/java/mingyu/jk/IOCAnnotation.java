package mingyu.jk; /**
 * @(#)AppConfig.java, 9月 06, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangmingyu
 */
@ComponentScan
@Configuration
public class IOCAnnotation {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(IOCAnnotation.class);
        App app = annotationConfigApplicationContext.getBean(App.class);
        app.sayHello();
    }
}