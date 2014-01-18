/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.cache;

import org.apache.log4j.Logger;

import com.alipay.demo.bean.LoggerNames;
import com.alipay.demo.tools.LoggerUtil;

/**
 * 
 *  ������־��չ
 * 
 * @author jie.hua@alipay.com
 * @version $Id: CacheLoggerWapper.java, v 0.1 2014-1-9 ����3:55:25 jie.hua Exp $
 */
public class CacheLoggerWapper implements Cache {

    /**
     * ��������
     */
    private static final String OPERATION_NAME = "�����������";

    /**
     * ��־
     */
    private static final Logger logger         = Logger.getLogger(LoggerNames.CACHE_LOGGER);

    /**
     * Ŀ�껺��
     */
    private Cache               cache;

    /**
     * @param cache
     */
    public CacheLoggerWapper(Cache cache) {
        super();
        this.cache = cache;
    }

    /** 
     * @see com.alipay.demo.cache.Cache#put(java.lang.String, java.lang.Object)
     */
    @Override
    public void put(String key, Object value) {

        this.cache.put(key, value);

        LoggerUtil.info(logger, OPERATION_NAME + ",�������ݣ�[key=" + key + ",value=" + value + "]");

    }

    /** 
     * @see com.alipay.demo.cache.Cache#get(java.lang.String)
     */
    @Override
    public Object get(String key) {

        Object object = this.cache.get(key);

        LoggerUtil.info(logger, OPERATION_NAME + ",��ȡ���ݣ�[key=" + key + ",value=" + object + "]");

        return object;
    }

}
