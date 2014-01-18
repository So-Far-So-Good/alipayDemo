/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.config;

import com.alipay.demo.bean.ToStringBase;

/**
 * ��������
 * 
 * @author jie.hua@alipay.com
 * @version $Id: EnviromentConfig.java, v 0.1 2014-1-16 ����9:17:44 jie.hua Exp $
 */
public class EnviromentConfig extends ToStringBase {

    /** ���к�ID  */
    private static final long    serialVersionUID = -6235945319090595835L;
    /**
     * ֧������������
     */
    private AlipayEnviromentType alipayEnviromentType;

    /**
     * Getter method for property <tt>alipayEnviromentType</tt>.
     * 
     * @return property value of alipayEnviromentType
     */
    public AlipayEnviromentType getAlipayEnviromentType() {
        return alipayEnviromentType;
    }

    /**
     * Setter method for property <tt>alipayEnviromentType</tt>.
     * 
     * @param alipayEnviromentType value to be assigned to property alipayEnviromentType
     */
    public void setAlipayEnviromentType(AlipayEnviromentType alipayEnviromentType) {
        this.alipayEnviromentType = alipayEnviromentType;
    }

}
