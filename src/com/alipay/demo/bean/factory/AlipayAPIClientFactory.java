/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.factory;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.demo.config.SystemConfig;

/**
 * 
 * ֧����API���󹤳���
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayAPIClientFactory.java, v 0.1 2014-1-10 ����1:52:21 jie.hua Exp $
 */
public class AlipayAPIClientFactory {

    /**
     * ����holder��
     * 
     * @author jie.hua@alipay.com
     * @version $Id: AlipayAPIClientFactory.java, v 0.1 2014-1-10 ����2:02:46 jie.hua Exp $
     */
    private static class AlipaySubHolder {

        /**
         * APIִ������
         */
        private static final AlipayClient ALIPAY_CLIENT = new DefaultAlipayClient(
                                                            SystemConfig.getGateWay(),
                                                            SystemConfig.getPublicId(),
                                                            SystemConfig.getMerchantPrivateKey());
    }

    /**
     * ��ȡΨһʵ��
     * 
     * @return
     */
    public static AlipayClient getClientInstance() {

        return AlipayAPIClientFactory.AlipaySubHolder.ALIPAY_CLIENT;
    }

}
