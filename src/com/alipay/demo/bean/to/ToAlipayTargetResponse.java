/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.api.AlipayResponse;

/**
 * ֱ����֧����������ʵ����Ӧ
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayTargetResponse.java, v 0.1 2014-1-10 ����1:02:57 jie.hua Exp $
 */
public class ToAlipayTargetResponse extends ToAlipayParam {

    /** ���к�ID  */
    private static final long serialVersionUID = 6355237518119428759L;

    /**
     * ֧����API��Ӧ
     */
    private AlipayResponse    alipayResponse;

    /**
     * @param alipayResponse
     */
    public ToAlipayTargetResponse(AlipayResponse alipayResponse) {
        super();
        this.alipayResponse = alipayResponse;
    }

    /**
     * Getter method for property <tt>alipayResponse</tt>.
     * 
     * @return property value of alipayResponse
     */
    public AlipayResponse getAlipayResponse() {
        return alipayResponse;
    }

}
