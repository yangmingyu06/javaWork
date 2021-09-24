/**
 * @(#)ReadAspect.java, 9月 24, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.readwritesplit.aop;

import com.example.readwritesplit.config.DataSourceManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author yangmingyu
 */
@Aspect
@Component
public class ReadAspect {

    @Autowired
    private DataSourceManager manager;

    @Pointcut("@annotation(ReadAnnotation)")
    public void read(){}

    @Around("read()")
    public List<Map<String, Object>> switchDataSource(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("switch data source...");
        final Object[] args = pjp.getArgs();
        args[0] = manager.getReadDataSource();
        return (List<Map<String, Object>>) pjp.proceed(args);
    }
}