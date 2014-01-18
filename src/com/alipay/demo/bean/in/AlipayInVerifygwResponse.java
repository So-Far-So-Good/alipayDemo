/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.in;

import com.alipay.demo.bean.ResultEnum;

/**
 * ֧����->�̻�������֤Ӧ��
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayInVerifygwResponse.java, v 0.1 2014-1-15 ����12:54:36 jie.hua Exp $
 */
public class AlipayInVerifygwResponse extends AlipayInModelResponse {

    /**  */
    private static final long  serialVersionUID = 2355253704601669150L;

    /**
     * ֧����������֤��Ϣ
     */
    private AlipayInVerifyInfo alipayInVerifyInfo;

    /**
     * ��ȡһ���ɹ�ʵ��
     * 
     * @return
     */
    public static AlipayInVerifygwResponse getSuccessInstance() {

        AlipayInVerifygwResponse resp = new AlipayInVerifygwResponse(
            ResultEnum.SUCESS.getResultCode(), ResultEnum.SUCESS.getResultMsg());

        return resp;
    }

    /**
     * @param resultCode
     * @param resultMsg
     */
    public AlipayInVerifygwResponse(String resultCode, String resultMsg) {
        super(resultCode, resultMsg);
    }

    /**
     * Getter method for property <tt>alipayInVerifyInfo</tt>.
     * 
     * @return property value of alipayInVerifyInfo
     */
    public AlipayInVerifyInfo getAlipayInVerifyInfo() {
        return alipayInVerifyInfo;
    }

    /**
     * Setter method for property <tt>alipayInVerifyInfo</tt>.
     * 
     * @param alipayInVerifyInfo value to be assigned to property alipayInVerifyInfo
     */
    public void setAlipayInVerifyInfo(AlipayInVerifyInfo alipayInVerifyInfo) {
        this.alipayInVerifyInfo = alipayInVerifyInfo;
    }

}
