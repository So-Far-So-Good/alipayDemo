/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.factory;

import com.alipay.demo.cache.AlipayMemoryCache;
import com.alipay.demo.cache.Cache;
import com.alipay.demo.cache.CacheLoggerWapper;

/**
 * ���湤����
 * 
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayCacheFactory.java, v 0.1 2014-1-8 ����10:26:32 jie.hua Exp $
 */
public class AlipayCacheFactory {

    /**
     * ��ȡ����ʵ��
     * <pre>
     *  Ŀǰֻʵ�����ڴ滺��ʵ��,�̻�����������չ
     * </pre>
     * 
     * @return
     */
    public static Cache getCacheInstance() {

        return new CacheLoggerWapper(AlipayMemoryCache.getInstance());
    }

}
