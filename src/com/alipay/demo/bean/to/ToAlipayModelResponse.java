/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

/**
 *  ����֧�����ڲ�ҵ����Ӧ����
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayModelResponse.java, v 0.1 2014-1-10 ����2:49:39 jie.hua Exp $
 */
public class ToAlipayModelResponse extends ToAlipayResponseParam {

    /** ���к�ID */
    private static final long serialVersionUID = -2920927448694931553L;

    /**
     * @param resultBase
     */
    public ToAlipayModelResponse(String resultCode, String resultMsg) {

        super(resultCode, resultMsg);
    }

}
