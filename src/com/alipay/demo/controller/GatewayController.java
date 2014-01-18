/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alipay.demo.bean.factory.AlipayInTargetReqFactory;
import com.alipay.demo.bean.in.AlipayInTargetRequest;
import com.alipay.demo.bean.in.AlipayInTargetResponse;
import com.alipay.demo.bean.in.InProcessContext;
import com.alipay.demo.process.in.InServiceEngine;
import com.alipay.demo.tools.LoggerUtil;

/**
 * �̻���������controller��
 * <pre>
 *   ��Ϊ��ǰ��������ͳһ������ص�ַ
 * </pre>
 * @author jie.hua@alipay.com
 * @version $Id: GatewayController.java, v 0.1 2014-1-5 ����7:27:42 jie.hua Exp $
 */
@Controller
public class GatewayController {

    /**
     * ��־����
     */
    private static final Logger logger         = Logger.getLogger("weblogger");

    /**
     * �������
     */
    private static final String OPERATION_NAME = "��֧������������";

    /**
     * �������
     */
    @Autowired
    private InServiceEngine     inServiceEngine;

    /**
     * ͳһ�������url
     * 
     * @param request
     * @param repsonse
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "gateway/gateway.do")
    public void doProcess(HttpServletRequest request, HttpServletResponse repsonse)
                                                                                   throws Exception {

        LoggerUtil.info(logger, OPERATION_NAME + ",����ʼ����...");

        // 1.��װ����
        AlipayInTargetRequest alipayInSrcRequest = AlipayInTargetReqFactory.buildRequest(request);
        InProcessContext inProcessContext = InProcessContext.getInstance()
            .build(alipayInSrcRequest);

        LoggerUtil.info(logger, OPERATION_NAME + ",���������װ���.[inProcessContext=" + inProcessContext
                                + "]");

        // 2.ִ��
        inServiceEngine.serviceProcess(inProcessContext);

        // 3.��Ӧ���
        PrintWriter writer = repsonse.getWriter();

        AlipayInTargetResponse alipayInTargetResponse = inProcessContext
            .getInstruction(AlipayInTargetResponse.class);
        writer.println(alipayInTargetResponse.getTargetMerchantMsg());

        LoggerUtil
            .info(logger,
                OPERATION_NAME + ",���������.[Ӧ������" + alipayInTargetResponse.getTargetMerchantMsg()
                        + "]");

    }

}
