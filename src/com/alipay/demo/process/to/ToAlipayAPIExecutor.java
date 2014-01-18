/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.to;

import org.apache.log4j.Logger;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayResponse;
import com.alipay.demo.bean.LoggerNames;
import com.alipay.demo.bean.ResultEnum;
import com.alipay.demo.bean.factory.AlipayAPIClientFactory;
import com.alipay.demo.bean.process.AlipayDemoException;
import com.alipay.demo.bean.process.Instruction;
import com.alipay.demo.bean.to.ToAlipayModelRequest;
import com.alipay.demo.bean.to.ToAlipayTargetRequest;
import com.alipay.demo.bean.to.ToAlipayTargetResponse;
import com.alipay.demo.bean.to.ToProcessContext;
import com.alipay.demo.tools.LoggerUtil;

/**
 *  ����֧����APIִ����
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayAPIExecutor.java, v 0.1 2014-1-11 ����4:44:44 jie.hua Exp $
 */
public abstract class ToAlipayAPIExecutor extends ToServiceExecutor {

    /**
     * ��������
     */
    private static final String OPERATION_NAME = "������֧����APIִ������";

    /**
     * ��־����
     */
    private static final Logger logger         = Logger.getLogger(LoggerNames.SERVICE_LOGGER);

    /** 
     * @see com.alipay.demo.process.ServiceExecutor#doAction(com.alipay.demo.bean.process.Instruction)
     */
    @SuppressWarnings("unchecked")
    @Override
    public void doAction(Instruction instruction) {

        ToProcessContext toProcessContext = instruction.getInstruction(ToProcessContext.class);

        ToAlipayTargetRequest toAlipayTargetRequest = toProcessContext
            .getInstruction(ToAlipayTargetRequest.class);
        ToAlipayModelRequest toModelRequest = toProcessContext
            .getInstruction(ToAlipayModelRequest.class);

        AlipayClient alipayClient = AlipayAPIClientFactory.getClientInstance();

        try {

            LoggerUtil.info(logger, OPERATION_NAME + ",��ʼ����֧�������أ�[modelRequest=" + toModelRequest
                                    + "]");

            // ����֧����API
            AlipayResponse alipayResponse = alipayClient.execute(toAlipayTargetRequest
                .getAlipayRequest());

            LoggerUtil.info(logger,
                OPERATION_NAME + ",����֧����������ɣ�[targetResult=" + alipayResponse.getErrorCode()
                        + ",body=" + alipayResponse.getBody() + "]");

            ToAlipayTargetResponse toAlipayTargetResponse = new ToAlipayTargetResponse(
                alipayResponse);

            // ��װʵ�ʽ����
            toProcessContext.setToAlipayTargetResponse(toAlipayTargetResponse);

        } catch (AlipayApiException e) {

            LoggerUtil.error(logger, OPERATION_NAME + ",����API�쳣.[apiName=" + getExecutorName()
                                     + "]", e);

            throw new AlipayDemoException(e, ResultEnum.ALIPAY_EXP_EXECUTOR);
        }

    }

}
