/**
 * @(#)MyStarterAutoConfiguration.java, 9月 07, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package mingyu.autoconfiguration;

import mingyu.data.MailService;
import mingyu.data.User;
import mingyu.data.UserService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangmingyu
 */
@Configuration
@ConditionalOnProperty(prefix = "mystarter", name = "enable", havingValue = "true")
@EnableConfigurationProperties(User.class)
public class MyStarterAutoConfiguration {

    private User user;

    @Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public MailService mailService() {
        return new MailService();
    }
}