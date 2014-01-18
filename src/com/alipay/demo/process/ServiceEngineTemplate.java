/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process;

import org.apache.log4j.Logger;

import com.alipay.demo.bean.process.AlipayDemoException;
import com.alipay.demo.bean.process.Instruction;

/**
 * ����ģ����
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ServiceTemplate.java, v 0.1 2014-1-6 ����4:23:49 jie.hua Exp $
 */
public class ServiceEngineTemplate implements ServiceEngine, Service {

    /**
     * ��־
     */
    private static final Logger logger = Logger.getLogger("servicelogger");

    /**
     * 
     * @see com.alipay.demo.process.ServiceEngine#serviceProcess(Instruction)
     */
    public final void serviceProcess(Instruction instruction) {

        try {

            doBefore(instruction);

            doAction(instruction);

        } catch (AlipayDemoException de) {

            logger.error("����ִ��ҵ���쳣", de);
            doFail(instruction, de);

        } catch (Exception e) {

            logger.error("����ִ��ϵͳ�쳣", e);
            doFail(instruction, e);

        } finally {

            doFinal(instruction);
        }

    }

    /** 
     * @see com.alipay.demo.process.Service#doBefore(Instruction)
     */
    @Override
    public void doBefore(Instruction instruction) {
    }

    /** 
     * @see com.alipay.demo.process.Service#doAction(Instruction)
     */
    @Override
    public void doAction(Instruction instruction) {
    }

    /** 
     * @see com.alipay.demo.process.Service#doFinal(Instruction)
     */
    @Override
    public void doFinal(Instruction instruction) {

    }

    /** 
     * @see com.alipay.demo.process.Service#doFail(Instruction, Exception)
     */
    @Override
    public void doFail(Instruction instruction, Exception e) {

    }

}
