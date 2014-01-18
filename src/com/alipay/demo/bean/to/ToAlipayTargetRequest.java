/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.api.AlipayRequest;

/**
 * ֱ����֧��������������
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayTargetRequest.java, v 0.1 2014-1-10 ����12:54:25 jie.hua Exp $
 */
@SuppressWarnings("rawtypes")
public class ToAlipayTargetRequest extends ToAlipayParam {

    /** ���к�ID */
    private static final long serialVersionUID = 62846251755942039L;
    /**
     * ֧����API����
     */
    private AlipayRequest     alipayRequest;

    /**
     * @param alipayRequest
     */
    public ToAlipayTargetRequest(AlipayRequest alipayRequest) {
        super();
        this.alipayRequest = alipayRequest;
    }

    /**
     * Getter method for property <tt>alipayRequest</tt>.
     * 
     * @return property value of alipayRequest
     */
    public AlipayRequest getAlipayRequest() {
        return alipayRequest;
    }

}
