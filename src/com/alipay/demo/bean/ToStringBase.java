/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *  �ַ���toString����
 *  
 * @author jie.hua@alipay.com
 * @version $Id: ToStringBase.java, v 0.1 2014-1-6 ����9:57:44 jie.hua Exp $
 */
public class ToStringBase implements Serializable {

    /** ���к�ID  */
    private static final long serialVersionUID = 1704932592395633947L;

    /**
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);

    }

}
