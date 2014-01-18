/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.config;

/**
 * ���ýӿ�
 * 
 * @author jie.hua@alipay.com
 * @version $Id: Config.java, v 0.1 2014-1-16 ����9:04:38 jie.hua Exp $
 */
public interface Config {

    /**
     * ��ȡ���ص�ַ
     * 
     * @return
     */
    public String getGateWay();

    /**
     * ��ȡ���ں�ID
     * 
     * @return
     */
    public String getPublicId();

    /**
     * ��ȡ�̻���Կ
     * 
     * @return
     */
    public String getMerchantPublicKey();

    /**
     * ��ȡ�̻�˽Կ
     * 
     * @return
     */
    public String getMerchantPrivateKey();

    /**
     * ֧������Կ
     * 
     * @return
     */
    public String getAlipayPublicKey();

    /**
     * �Ƿ��������ǩ
     * 
     * @return
     */
    public boolean isCheckSign();

    /**
     * �Ƿ���������
     * 
     * @return
     */
    public boolean isDecrypt();

    /**
     * �Ƿ�Խ����ǩ
     * 
     * @return
     */
    public boolean isSign();

    /**
     * �Ƿ�Խ������
     * 
     * @return
     */
    public boolean isEncrypt();

}
