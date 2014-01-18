/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.response.converter.to;

import com.alipay.demo.bean.to.ToAlipayModelRequest;
import com.alipay.demo.bean.to.ToAlipayTargetRequest;

/**
 *  �̻�->֧��������Ĭ��ת����
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayDefaultRequestConverter.java, v 0.1 2014-1-11 ����3:24:43 jie.hua Exp $
 */
public class ToAlipayDefaultRequestConverter extends ToAlipayRequestConverter {

    /** 
     * @see com.alipay.demo.response.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public ToAlipayTargetRequest convert(ToAlipayModelRequest srcObj) {

        return new ToAlipayTargetRequest(null);
    }

    /** 
     * @see com.alipay.demo.response.converter.to.ToAlipayRequestConverter#getSrcClass()
     */
    @Override
    public Class<? extends ToAlipayModelRequest> getSrcClass() {

        return ToAlipayModelRequest.class;
    }

}
