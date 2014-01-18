/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.to;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alipay.demo.process.ServiceExecutor;

/**
 * ����֧��������������
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToServiceExecutorFactory.java, v 0.1 2014-1-10 ����1:15:11 jie.hua Exp $
 */
public class ToServiceExecutorFactory {

    /**
     * ����ӳ��
     */
    private Map<String, ToServiceExecutor> executorMaps = new HashMap<String, ToServiceExecutor>();

    /**
     * ����name��ѯ����ִ����
     * 
     * @param name
     * @return
     */
    public ServiceExecutor getExecutorByName(String name) {

        return executorMaps.get(name);

    }

    /**
     *  ���÷���ִ����
     * 
     * @param executors
     */
    public void setExecutorList(List<ToServiceExecutor> executors) {

        if (executors == null || executors.isEmpty()) {

            return;
        }

        for (ToServiceExecutor executor : executors) {

            executorMaps.put(executor.getExecutorName(), executor);
        }

    }

}
