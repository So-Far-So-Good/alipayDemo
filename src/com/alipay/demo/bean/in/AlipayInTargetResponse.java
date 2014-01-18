/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.in;

import com.alipay.demo.bean.ResultBase;
import com.alipay.demo.bean.process.BeanWire;

/**
 * ���ջظ��̻�����Ӧ
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayInTargResponse.java, v 0.1 2014-1-6 ����11:24:40 jie.hua Exp $
 */
public class AlipayInTargetResponse extends ResultBase implements BeanWire {

    /** ���к�ID */
    private static final long serialVersionUID = -4706200637743990542L;

    /**
     * ���շ��͸��̻�������
     */
    private String            targetMerchantMsg;

    /**
     * @param resultCode
     * @param resultMsg
     */
    public AlipayInTargetResponse(String resultCode, String resultMsg) {

        super(resultCode, resultMsg);
    }

    /**
     * Getter method for property <tt>targetMerchantMsg</tt>.
     * 
     * @return property value of targetMerchantMsg
     */
    public String getTargetMerchantMsg() {
        return targetMerchantMsg;
    }

    /**
     * Setter method for property <tt>targetMerchantMsg</tt>.
     * 
     * @param targetMerchantMsg value to be assigned to property targetMerchantMsg
     */
    public void setTargetMerchantMsg(String targetMerchantMsg) {
        this.targetMerchantMsg = targetMerchantMsg;
    }

}
