/**
 * @(#)TestMyStarter.java, 9月 07, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package jeek.work.teststarter.service;

import mingyu.data.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author yangmingyu
 */
@Service
public class TestMyStarter {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void test() {
        userService.sendMail();
    }
}