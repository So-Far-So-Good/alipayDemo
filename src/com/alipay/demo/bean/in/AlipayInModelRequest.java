/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.in;

/**
 * ֧�������������
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayInModelRequest.java, v 0.1 2014-1-5 ����8:05:26 jie.hua Exp $
 */
public class AlipayInModelRequest extends AlipayInParam {

    /** ���к�ID */
    private static final long  serialVersionUID = 1699648485894765322L;

    /**
     * ����api����
     */
    private String             service;

    /**
     * ǩ������
     */
    private String             sign;

    /**
     * ǩ������
     */
    private String             signType;

    /**
     * ��������
     */
    private String             charset;

    /**
     * ҵ������
     */
    private String             bizContent;

    /**
     * ҵ�����ݶ�Ӧģ��
     */
    private AlipayInBizContent alipayInBizContent;

    /**
     * Getter method for property <tt>service</tt>.
     * 
     * @return property value of service
     */
    public String getService() {
        return service;
    }

    /**
     * Setter method for property <tt>service</tt>.
     * 
     * @param service value to be assigned to property service
     */
    public void setService(String service) {
        this.service = service;
    }

    /**
     * Getter method for property <tt>sign</tt>.
     * 
     * @return property value of sign
     */
    public String getSign() {
        return sign;
    }

    /**
     * Setter method for property <tt>sign</tt>.
     * 
     * @param sign value to be assigned to property sign
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * Getter method for property <tt>signType</tt>.
     * 
     * @return property value of signType
     */
    public String getSignType() {
        return signType;
    }

    /**
     * Setter method for property <tt>signType</tt>.
     * 
     * @param signType value to be assigned to property signType
     */
    public void setSignType(String signType) {
        this.signType = signType;
    }

    /**
     * Getter method for property <tt>charset</tt>.
     * 
     * @return property value of charset
     */
    public String getCharset() {
        return charset;
    }

    /**
     * Setter method for property <tt>charset</tt>.
     * 
     * @param charset value to be assigned to property charset
     */
    public void setCharset(String charset) {
        this.charset = charset;
    }

    /**
     * Getter method for property <tt>bizContent</tt>.
     * 
     * @return property value of bizContent
     */
    public String getBizContent() {
        return bizContent;
    }

    /**
     * Setter method for property <tt>bizContent</tt>.
     * 
     * @param bizContent value to be assigned to property bizContent
     */
    public void setBizContent(String bizContent) {
        this.bizContent = bizContent;
    }

    /**
     * Getter method for property <tt>alipayInBizContent</tt>.
     * 
     * @return property value of alipayInBizContent
     */
    public AlipayInBizContent getAlipayInBizContent() {
        return alipayInBizContent;
    }

    /**
     * Setter method for property <tt>alipayInBizContent</tt>.
     * 
     * @param alipayInBizContent value to be assigned to property alipayInBizContent
     */
    public void setAlipayInBizContent(AlipayInBizContent alipayInBizContent) {
        this.alipayInBizContent = alipayInBizContent;
    }

}
