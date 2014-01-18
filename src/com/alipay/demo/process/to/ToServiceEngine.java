/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.to;

import org.apache.log4j.Logger;

import com.alipay.demo.bean.LoggerNames;
import com.alipay.demo.bean.ResultEnum;
import com.alipay.demo.bean.factory.ToAlipayModelResponseFactory;
import com.alipay.demo.bean.factory.ToAlipayTargetRequestFactory;
import com.alipay.demo.bean.process.AlipayDemoException;
import com.alipay.demo.bean.process.Instruction;
import com.alipay.demo.bean.to.ToAlipayModelRequest;
import com.alipay.demo.bean.to.ToAlipayModelResponse;
import com.alipay.demo.bean.to.ToAlipayTargetRequest;
import com.alipay.demo.bean.to.ToAlipayTargetResponse;
import com.alipay.demo.bean.to.ToProcessContext;
import com.alipay.demo.process.ServiceEngineTemplate;
import com.alipay.demo.process.ServiceExecutor;
import com.alipay.demo.tools.LoggerUtil;

/**
 * �̻�-��֧��������ִ������
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToServiceEngine.java, v 0.1 2014-1-10 ����1:13:03 jie.hua Exp $
 */
public class ToServiceEngine extends ServiceEngineTemplate {

    /**
     * ��������
     */
    private static final String      OPERATION_NAME = "������֧����ִ�����桿";

    /**
     * ������־
     */
    private static final Logger      logger         = Logger.getLogger(LoggerNames.SERVICE_LOGGER);

    /**
     * ����������
     */
    private ToServiceExecutorFactory toServiceExecutorFactory;

    /** 
     * @see com.alipay.demo.process.ServiceEngineTemplate#doBefore(com.alipay.demo.bean.process.Instruction)
     */
    @Override
    public void doBefore(Instruction instruction) {

        ToProcessContext toProcessContext = instruction.getInstruction(ToProcessContext.class);
        ToAlipayModelRequest toAlipayModelRequest = toProcessContext
            .getInstruction(ToAlipayModelRequest.class);

        // ��װ����ҵ������->֧����ʵ��API��������
        ToAlipayTargetRequest toAlipayTargetRequest = ToAlipayTargetRequestFactory
            .buildTargetReqFromModel(toAlipayModelRequest);

        toProcessContext.setToAlipayTargetRequest(toAlipayTargetRequest);
    }

    /** 
     * @see com.alipay.demo.process.ServiceEngineTemplate#doAction(com.alipay.demo.bean.process.Instruction)
     */
    @Override
    public void doAction(Instruction instruction) {

        ToProcessContext toProcessContext = instruction.getInstruction(ToProcessContext.class);
        ToAlipayModelRequest toAlipaySrcRequest = toProcessContext
            .getInstruction(ToAlipayModelRequest.class);

        // ��ѯ����֧����������
        ServiceExecutor toServiceExecutor = toServiceExecutorFactory
            .getExecutorByName(toAlipaySrcRequest.getExecutorName());

        // ��������ڣ���ֱ�ӱ���
        if (toServiceExecutor == null) {

            LoggerUtil.warn(logger, OPERATION_NAME + ",��ǰapiִ�����治����.[executorName="
                                    + toAlipaySrcRequest.getExecutorName() + "]");

            throw new AlipayDemoException(ResultEnum.NO_SUCH_EXEUCTOR.getResultCode(),
                String.format(ResultEnum.NO_SUCH_EXEUCTOR.getResultMsg(),
                    toAlipaySrcRequest.getExecutorName()));
        } else {

            toServiceExecutor.doAction(instruction);
        }

    }

    /** 
     * @see com.alipay.demo.process.ServiceEngineTemplate#doFinal(com.alipay.demo.bean.process.Instruction)
     */
    @Override
    public void doFinal(Instruction instruction) {

        ToProcessContext toProcessContext = instruction.getInstruction(ToProcessContext.class);

        ToAlipayTargetResponse toAlipayTargetResponse = toProcessContext
            .getInstruction(ToAlipayTargetResponse.class);

        ToAlipayModelResponse toAlipayModelReponse = toProcessContext
            .getInstruction(ToAlipayModelResponse.class);

        // ��Ϊ�����ʾ��Ҫ����֧������Ӧ�������ת��
        if (toAlipayModelReponse == null) {

            ToAlipayModelResponse modelResponse = ToAlipayModelResponseFactory
                .buildModelRespFromTarget(toAlipayTargetResponse);

            toProcessContext.setToAlipayModelReponse(modelResponse);

        }
    }

    /** 
     * @see com.alipay.demo.process.ServiceEngineTemplate#doFail(com.alipay.demo.bean.process.Instruction, java.lang.Exception)
     */
    @Override
    public void doFail(Instruction instruction, Exception e) {

        ToProcessContext toProcessContext = instruction.getInstruction(ToProcessContext.class);

        String resultCode = null;

        String resultMsg = null;

        if (e instanceof AlipayDemoException) {

            resultCode = ((AlipayDemoException) e).getResultCode();
            resultMsg = ((AlipayDemoException) e).getResultMsg();
        } else {

            resultCode = ResultEnum.SYSTEM_ERROR.getResultCode();
            resultMsg = ResultEnum.SYSTEM_ERROR.getResultMsg();
        }

        // �쳣ҵ����Ӧ
        ToAlipayModelResponse toAlipayModelReponse = ToAlipayModelResponseFactory
            .buildFailResponse(resultCode, resultMsg);
        toProcessContext.setToAlipayModelReponse(toAlipayModelReponse);

    }

    /**
     * Setter method for property <tt>toServiceExecutorFactory</tt>.
     * 
     * @param toServiceExecutorFactory value to be assigned to property toServiceExecutorFactory
     */
    public void setToServiceExecutorFactory(ToServiceExecutorFactory toServiceExecutorFactory) {
        this.toServiceExecutorFactory = toServiceExecutorFactory;
    }

}
