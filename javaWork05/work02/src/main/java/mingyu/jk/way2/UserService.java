/**
 * @(#)UserService.java, 9月 06, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package mingyu.jk.way2;

/**
 * @author yangmingyu
 */
public class UserService {

    private MailService mailService;

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    public void sendMail(User user) {
        mailService.sendLoginMail(user);
    }
}