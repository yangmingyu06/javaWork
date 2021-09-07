/**
 * @(#)TestUseXml.java, 9月 06, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package mingyu.jk.way2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yangmingyu
 */
public class TestUseXml {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("application.xml");
        UserService userService = context.getBean(UserService.class);
        User user = new User();
        user.setName("jim");
        userService.sendMail(user);
    }
}