/**
 * @(#)OrderServiceTest.java, 9月 24, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.readwritesplit.service;

import com.example.readwritesplit.config.DataSourceManager;
import com.example.readwritesplit.service.impl.OrderServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author yangmingyu
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class OrderServiceTest {

    @Autowired
    DataSourceManager dataSourceCenter;

    @Autowired
    OrderServiceImpl orderService;

    /**
     * 对读写分离 - 动态 切换数据源版本 1.0 进行测试
     * 测试时会打印当前使用的数据库的URL，用这个来判断是否切换成功
     * insert 使用主库
     * query 从库负载均衡
     */
    @Test
    @Transactional
    public void testInsertAndQuery() throws SQLException {
        String sql = "insert into stores (name, description) VALUES (\"name103\", \"description103\");";
        // 使用主库 master
        orderService.insertOne(dataSourceCenter.getDataSource(), sql);

        sql = "select * from stores limit 5;";
        // 使用从库 slave1
        List<Map<String, Object>> entities = orderService.query(dataSourceCenter.getDataSource(), sql);
        for (Map item: entities) {
            System.out.println(item.toString());
        }

        // 使用从库slave2
        orderService.query(dataSourceCenter.getDataSource(), sql);
    }
}