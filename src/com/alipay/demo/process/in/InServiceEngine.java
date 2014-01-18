/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.in;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.demo.bean.ResultEnum;
import com.alipay.demo.bean.factory.AlipayInModelReqFactory;
import com.alipay.demo.bean.in.AlipayInBizContent;
import com.alipay.demo.bean.in.AlipayInModelRequest;
import com.alipay.demo.bean.in.AlipayInModelResponse;
import com.alipay.demo.bean.in.AlipayInTargetRequest;
import com.alipay.demo.bean.in.AlipayInTargetResponse;
import com.alipay.demo.bean.in.InProcessContext;
import com.alipay.demo.bean.process.AlipayDemoException;
import com.alipay.demo.bean.process.Instruction;
import com.alipay.demo.config.SystemConfig;
import com.alipay.demo.process.ServiceEngineTemplate;
import com.alipay.demo.process.ServiceExecutor;
import com.alipay.demo.tools.ServiceTool;

/**
 * 
 *  ֧����->�̻��������������
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ServiceEngine.java, v 0.1 2014-1-5 ����8:41:47 jie.hua Exp $
 */
public class InServiceEngine extends ServiceEngineTemplate {

    /**
     * ������񹤳�
     */
    private InServiceExecutorFactory inServiceExecutorFactory;

    /**
     * ִ��ǰ����
     * 
     * @param instruction
     */
    @Override
    public void doBefore(Instruction instruction) {

        InProcessContext inProcessContext = instruction.getInstruction(InProcessContext.class);
        AlipayInTargetRequest inSrcRequest = inProcessContext
            .getInstruction(AlipayInTargetRequest.class);

        try {

            // 1.ǩ����ǩ�ͽ���
            String alipayMsg = AlipaySignature.checkSignAndDecrypt(inSrcRequest.getRequestParams(),
                SystemConfig.getAlipayPublicKey(), SystemConfig.getMerchantPrivateKey(),
                SystemConfig.isCheckSign(), SystemConfig.isEncrypt());

            // 2.����ת��
            AlipayInModelRequest alipayInRequest = AlipayInModelReqFactory.buildRequest(
                inSrcRequest.getRequestParams(), alipayMsg);

            inProcessContext.setAlipayInRequest(alipayInRequest);

        } catch (AlipayApiException e) {

            //TODO add log

            throw new AlipayDemoException(e, ResultEnum.SIGN_VERIFY_FAIL);
        }

    }

    /**
     * ������
     * 
     * @param instruction
     */
    @Override
    public void doAction(Instruction instruction) {

        // 1.��ȡ����
        InProcessContext inProcessContext = instruction.getInstruction(InProcessContext.class);
        AlipayInModelRequest alipayInRequest = inProcessContext
            .getInstruction(AlipayInModelRequest.class);
        AlipayInBizContent alipayInBizContent = alipayInRequest.getAlipayInBizContent();

        // 2.ִ�з���
        ServiceExecutor executor = inServiceExecutorFactory.getExecutorByName(ServiceTool
            .buildInServiceName(alipayInBizContent.getMsgType(), alipayInBizContent.getEventType(),
                alipayInBizContent.getActionParam()));

        // 3.ִ�з���
        // 3.1 û�ж�Ӧ����ֱ�ӷ��ؽ��
        if (executor == null) {

            AlipayInModelResponse alipayInResponse = new AlipayInModelResponse(
                ResultEnum.SUCESS.getResultCode(), ResultEnum.SUCESS.getResultMsg());

            inProcessContext.setAlipayInResponse(alipayInResponse);

        } else {
            // 3.2 ����ֱ�ӵ���ִ��
            executor.doAction(instruction);
        }

    }

    /**
     *  ִ����ϴ���
     */
    @Override
    public void doFinal(Instruction instruction) {

        InProcessContext inProcessContext = instruction.getInstruction(InProcessContext.class);
        AlipayInModelResponse alipayInResponse = inProcessContext
            .getInstruction(AlipayInModelResponse.class);

        String merchantTargetMsg = null;
        String resultCode = alipayInResponse.getResultCode();
        String resultMsg = alipayInResponse.getResultMsg();

        try {

            //  1.����֧�������ص����ݽ��м�ǩ�ͼ���
            merchantTargetMsg = AlipaySignature.encryptAndSign(alipayInResponse.getMerchantMsg(),
                SystemConfig.getAlipayPublicKey(), SystemConfig.getMerchantPrivateKey(),
                SystemConfig.getAlipayCharSet(), SystemConfig.isEncrypt(), SystemConfig.isSign());

        } catch (AlipayApiException e) {

            //TODO add log
            merchantTargetMsg = null;
            resultCode = ResultEnum.SIGN_DO_FAIL.getResultCode();
            resultMsg = ResultEnum.SIGN_DO_FAIL.getResultMsg();

        } finally {

            // 2.ת�����ս��
            AlipayInTargetResponse alipayInTargetResponse = new AlipayInTargetResponse(resultCode,
                resultMsg);
            alipayInTargetResponse.setTargetMerchantMsg(merchantTargetMsg);

            inProcessContext.setAlipayInTargetResponse(alipayInTargetResponse);
        }

    }

    /**
     * ϵͳ�쳣ʱ����
     * 
     * @param instruction
     * @param  e 
     */
    @Override
    public void doFail(Instruction instruction, Exception e) {

        InProcessContext inProcessContext = instruction.getInstruction(InProcessContext.class);

        String resultCode = null;

        String resultMsg = null;

        if (e instanceof AlipayDemoException) {

            resultCode = ((AlipayDemoException) e).getResultCode();
            resultMsg = ((AlipayDemoException) e).getResultMsg();
        } else {

            resultCode = ResultEnum.SYSTEM_ERROR.getResultCode();
            resultMsg = ResultEnum.SYSTEM_ERROR.getResultMsg();
        }

        AlipayInModelResponse failResponse = AlipayInModelResponse.buildFailResponse(resultCode,
            resultMsg);
        // TODO �޸Ķ�Ӧ�쳣�İ�:�������д�������࣬����resultCode���ظ���Ӧ���
        failResponse.setMerchantMsg("���쳣��������");
        inProcessContext.setAlipayInResponse(failResponse);

    }

    /**
     * Setter method for property <tt>inServiceExecutorFactory</tt>.
     * 
     * @param inServiceExecutorFactory value to be assigned to property inServiceExecutorFactory
     */
    public void setInServiceExecutorFactory(InServiceExecutorFactory inServiceExecutorFactory) {
        this.inServiceExecutorFactory = inServiceExecutorFactory;
    }

}
