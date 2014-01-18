/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.in;

import org.apache.log4j.Logger;

import com.alipay.demo.bean.LoggerNames;
import com.alipay.demo.bean.factory.AlipayInVerifygwRespFactory;
import com.alipay.demo.bean.in.AlipayInVerifyInfo;
import com.alipay.demo.bean.in.AlipayInVerifygwResponse;
import com.alipay.demo.bean.in.InProcessContext;
import com.alipay.demo.bean.msg.MsgConstants;
import com.alipay.demo.bean.process.Instruction;
import com.alipay.demo.config.SystemConfig;
import com.alipay.demo.tools.LoggerUtil;
import com.alipay.demo.tools.ServiceTool;

/**
 * ֧����->�̻����ع�Կ��ִ֤����
 * 
 * @author jie.hua@alipay.com
 * @version $Id: InAlipayVerifygwExecutor.java, v 0.1 2014-1-15 ����1:00:25 jie.hua Exp $
 */
public class InAlipayVerifygwExecutor extends InServiceExecutor {

    /**
     * ��������
     */
    private static final String OPERATION_NAME = "��֧���������̻�������֤��";

    /**
     * ��־
     */
    private static final Logger logger         = Logger.getLogger(LoggerNames.SERVICE_LOGGER);

    /** 
     * @see com.alipay.demo.process.ServiceExecutor#doAction(com.alipay.demo.bean.process.Instruction)
     */
    @Override
    public void doAction(Instruction instruction) {

        LoggerUtil.info(logger, OPERATION_NAME + ",��ʼ������֤����.");

        InProcessContext inProcessContext = instruction.getInstruction(InProcessContext.class);

        AlipayInVerifygwResponse alipayInVerifygwResponse = AlipayInVerifygwResponse
            .getSuccessInstance();

        // ������֤�������̻���Կ���ɹ���ʶ
        AlipayInVerifyInfo alipayInVerifyInfo = new AlipayInVerifyInfo();
        alipayInVerifyInfo.setBizContent(SystemConfig.getMerchantPublicKey());
        alipayInVerifyInfo.setSuccess(true);

        // ��װ������֤ҵ��Ӧ��
        alipayInVerifygwResponse.setAlipayInVerifyInfo(alipayInVerifyInfo);
        alipayInVerifygwResponse.setMerchantMsg(AlipayInVerifygwRespFactory
            .toArributeXML(alipayInVerifyInfo));

        inProcessContext.setAlipayInResponse(alipayInVerifygwResponse);

        LoggerUtil.info(logger, OPERATION_NAME + ",ִ��������֤�������.[alipayInVerifygwResponse="
                                + alipayInVerifygwResponse + "]");

    }

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {

        return ServiceTool.buildInServiceName(MsgConstants.EVENT_MSG_TYPE,
            MsgConstants.VERIFYGW_EVENT_TYPE, null);
    }

}
