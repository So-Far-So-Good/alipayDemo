/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process;

import com.alipay.demo.bean.process.Instruction;


/**
 * ����ӿ�
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ServiceExecute.java, v 0.1 2014-1-6 ����4:21:10 jie.hua Exp $
 */
public interface Service {

    /**
     * ִ��ǰ����
     * 
     * @param instruction
     */
    public void doBefore(Instruction instruction);

    /**
     * ������
     * 
     * @param instruction
     */
    public void doAction(Instruction instruction);

    /**
     *  ִ����ϴ���
     */
    public void doFinal(Instruction instruction);

    /**
     * ϵͳ�쳣ʱ����
     * 
     * @param instruction
     * @param  e 
     */
    public void doFail(Instruction instruction, Exception e);

}
