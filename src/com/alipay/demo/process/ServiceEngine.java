/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process;

import com.alipay.demo.bean.process.Instruction;


/**
 * ����ִ�нӿ�
 * @author jie.hua@alipay.com
 * @version $Id: ServiceEngine.java, v 0.1 2014-1-6 ����4:33:12 jie.hua Exp $
 */
public interface ServiceEngine {

    /**
     * ģ�����ͳһ��������
     * 
     * @param instruction
     */
    public void serviceProcess(Instruction instruction);

}
