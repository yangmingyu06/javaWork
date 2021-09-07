/**
 * @(#)UserService.java, 9月 06, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package mingyu.data;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yangmingyu
 */
public class UserService {

    @Autowired
    private MailService mailService;

    public void sendMail() {
        mailService.sendLoginMail();
    }
}