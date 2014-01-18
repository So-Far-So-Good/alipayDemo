/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean;

/**
 * ����ӿ�
 * 
 * @author jie.hua@alipay.com
 * @version $Id: Result.java, v 0.1 2014-1-8 ����8:15:30 jie.hua Exp $
 */
public interface Result {

    /**
     * ����Ƿ�ɹ�
     * 
     * @return
     */
    public boolean isSuccess();

    /**
     * Getter method for property <tt>resultCode</tt>.
     * 
     * @return property value of resultCode
     */
    public String getResultCode();

    /**
     * Getter method for property <tt>resultMsg</tt>.
     * 
     * @return property value of resultMsg
     */
    public String getResultMsg();

}
