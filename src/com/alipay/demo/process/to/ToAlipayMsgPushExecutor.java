/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.to;

import com.alipay.demo.bean.AlipayAPINames;

/**
 * �̻�->֧����������Ϣִ����
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayMsgPushExecutor.java, v 0.1 2014-1-12 ����4:29:30 jie.hua Exp $
 */
public class ToAlipayMsgPushExecutor extends ToAlipayAPIExecutor {

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {

        return AlipayAPINames.ALIPAY_MSG_PUSH_API;
    }

}
