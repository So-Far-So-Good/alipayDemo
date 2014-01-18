/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.cache;

/**
 * ����ӿ�
 * 
 * @author jie.hua@alipay.com
 * @version $Id: Cache.java, v 0.1 2014-1-8 ����10:24:25 jie.hua Exp $
 */
public interface Cache {

    /**
     * ���û���
     * 
     * @param key
     * @param value
     */
    public void put(String key, Object value);

    /**
     * ���ػ���ֵ
     * 
     * @param key
     * @return
     */
    public Object get(String key);

}
