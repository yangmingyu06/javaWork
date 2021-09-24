/**
 * @(#)DbConfiguration.java, 9月 22, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.readwritesplit.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author yangmingyu
 */
@Configuration
public class DbConfiguration {

    @Autowired
    Environment env;

    @Primary
    @Bean("master")
    public DataSource master() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(env.getProperty("master.url"));
        config.setUsername(env.getProperty("master.user"));
        config.setPassword(env.getProperty("master.passWord"));

        return new HikariDataSource(config);
    }

    @Bean("slaver1")
    public DataSource slaver1() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(env.getProperty("slaver1.url"));
        config.setUsername(env.getProperty("slaver1.user"));
        config.setPassword(env.getProperty("slaver1.passWord"));

        return new HikariDataSource(config);
    }

    @Bean("slaver2")
    public DataSource slaver2() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(env.getProperty("slaver2.url"));
        config.setUsername(env.getProperty("slaver2.user"));
        config.setPassword(env.getProperty("slaver2.passWord"));

        return new HikariDataSource(config);
    }
}