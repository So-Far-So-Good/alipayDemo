/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process;

import com.alipay.demo.bean.process.Instruction;


/**
 * ����ִ����
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ServiceExecutor.java, v 0.1 2014-1-9 ����2:45:59 jie.hua Exp $
 */
public interface ServiceExecutor {

    /**
     * ִ�в���
     * 
     * @param instruction
     */
    public void doAction(Instruction instruction);

}
