/**
 * @(#)DataSourceManager.java, 9月 23, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.readwritesplit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author yangmingyu
 */
@Component
public class DataSourceManager {

    @Autowired
    @Qualifier("master")
    DataSource master;


    @Autowired
    @Qualifier("slaver1")
    DataSource slaver1;

    @Autowired
    @Qualifier("slaver2")
    DataSource slaver2;

    public DataSource getDataSource() {
        return master;
    }

    public DataSource getReadDataSource() {
        if (System.currentTimeMillis() % 2 == 1) {
            return slaver1;
        } else {
            return slaver2;
        }
    }
}