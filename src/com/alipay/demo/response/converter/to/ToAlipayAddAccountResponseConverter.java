/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.response.converter.to;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.alipay.api.AlipayResponse;
import com.alipay.api.response.AlipayMobilePublicAccountAddResponse;
import com.alipay.demo.bean.ResultEnum;
import com.alipay.demo.bean.factory.AlipayErrorCodeFactory;
import com.alipay.demo.bean.to.ToAlipayAddAccountModelReponse;
import com.alipay.demo.bean.to.ToAlipayModelResponse;
import com.alipay.demo.config.SystemConfig;
import com.alipay.demo.tools.LoggerUtil;

/**
 * ���ⲿ����Ӧ
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayAddAccountResponseConverter.java, v 0.1 2014-1-10 ����7:30:52 jie.hua Exp $
 */
public class ToAlipayAddAccountResponseConverter extends ToAlipayResponseConverter {

    /**
     * ��־����
     */
    private static final String OPERATION_NAME = "�����˻�API��Ӧת����";

    /**
     * ��־����
     */
    private static final Logger logger         = Logger
                                                   .getLogger(ToAlipayAddAccountResponseConverter.class);

    /** 
     * @see com.alipay.demo.response.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public ToAlipayModelResponse convert(AlipayResponse srcObj) {

        AlipayMobilePublicAccountAddResponse alipayAddResponse = (AlipayMobilePublicAccountAddResponse) srcObj;

        // 1.�쳣���
        if (alipayAddResponse == null) {

            ToAlipayAddAccountModelReponse accountModelResponse = new ToAlipayAddAccountModelReponse(
                ResultEnum.SYSTEM_ERROR.getResultCode(), ResultEnum.SYSTEM_ERROR.getResultMsg());
            accountModelResponse.setSuccess(false);

            return accountModelResponse;
        } else if (alipayAddResponse.isSuccess()
                   && StringUtils.equalsIgnoreCase(SystemConfig.getAlipaySuccessCode(),
                       alipayAddResponse.getCode())) {
            // 2.�ɹ�����£���װЭ��ŷ���

            ToAlipayAddAccountModelReponse accountModelResponse = new ToAlipayAddAccountModelReponse(
                ResultEnum.SUCESS.getResultCode(), ResultEnum.SUCESS.getResultMsg());
            accountModelResponse.setAgreementId(alipayAddResponse.getAgreementId());
            accountModelResponse.setSuccess(true);

            LoggerUtil.info(logger,
                OPERATION_NAME + ",�󶨳ɹ�.[agreementId=" + alipayAddResponse.getAgreementId() + "]");

            return accountModelResponse;
        } else {

            // 3.ʧ������£�ת�������
            ResultEnum modelResult = AlipayErrorCodeFactory.convertFromAlipayResponse(
                alipayAddResponse.getCode(), alipayAddResponse.getMsg());

            ToAlipayAddAccountModelReponse accountModelResponse = new ToAlipayAddAccountModelReponse(
                modelResult.getResultCode(), modelResult.getResultMsg());
            accountModelResponse.setSuccess(false);

            return accountModelResponse;
        }

    }

    /** 
     * @see com.alipay.demo.response.converter.to.ToAlipayResponseConverter#getSrcClass()
     */
    @Override
    public Class<? extends AlipayResponse> getSrcClass() {

        return AlipayMobilePublicAccountAddResponse.class;
    }

    /** 
     * @see com.alipay.demo.response.converter.to.ToAlipayResponseConverter#getTargetClass()
     */
    @Override
    public Class<? extends ToAlipayModelResponse> getTargetClass() {

        return ToAlipayAddAccountModelReponse.class;
    }

}
