/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.in;

import com.alipay.demo.bean.ToStringBase;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * �ɹ���Ӧ��Ϣ
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayInSuccessInfo.java, v 0.1 2014-1-17 ����8:49:09 jie.hua Exp $
 */
public class AlipayInSuccessInfo extends ToStringBase {

    /** ���к�ID */
    private static final long serialVersionUID = 6627729550552670690L;
    /**
     * �Ƿ�ɹ�
     */
    @XStreamAlias("success")
    private boolean           success;

    /**
     * Getter method for property <tt>success</tt>.
     * 
     * @return property value of success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Setter method for property <tt>success</tt>.
     * 
     * @param success value to be assigned to property success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

}
