/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.in;

import com.alipay.demo.bean.ResultEnum;
import com.alipay.demo.bean.msg.AlipayArticleMsg;

/**
 * ֧����������Ӧ��
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayInMsgResponse.java, v 0.1 2014-1-6 ����1:36:18 jie.hua Exp $
 */
public class AlipayInArticleMsgResponse extends AlipayInModelResponse {

    /** ���к� */
    private static final long  serialVersionUID = 6706139850737073862L;

    /**
     * ֧������Ӧ
     */
    private AlipayArticleMsg alipayArticleMsg;

    /**
     * ���سɹ�ʵ��
     * 
     * @return
     */
    public static AlipayInArticleMsgResponse getSuccessInstance() {

        return new AlipayInArticleMsgResponse(ResultEnum.SUCESS.getResultCode(),
            ResultEnum.SUCESS.getResultMsg());
    }

    /**
     * @param resultCode
     * @param resultMsg
     */
    public AlipayInArticleMsgResponse(String resultCode, String resultMsg) {
        super(resultCode, resultMsg);
    }

    /**
     * Getter method for property <tt>alipayArticleMsg</tt>.
     * 
     * @return property value of alipayArticleMsg
     */
    public AlipayArticleMsg getAlipayArticleMsg() {
        return alipayArticleMsg;
    }

    /**
     * Setter method for property <tt>alipayArticleMsg</tt>.
     * 
     * @param alipayArticleMsg value to be assigned to property alipayArticleMsg
     */
    public void setAlipayArticleMsg(AlipayArticleMsg alipayArticleMsg) {
        this.alipayArticleMsg = alipayArticleMsg;
    }

}
