/**
 * @(#)OrderService.java, 9月 24, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.readwritesplit.service.spi;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author yangmingyu
 */
public interface OrderService {

    void insertOne(DataSource dataSource, String sql) throws SQLException;

    List<Map<String, Object>> query(DataSource dataSource, String sql) throws SQLException;
}