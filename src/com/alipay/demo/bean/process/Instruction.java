/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.process;


/**
 * ������ȡ�ӿ�
 * 
 * @author jie.hua@alipay.com
 * @version $Id: Instruction.java, v 0.1 2014-1-5 ����7:57:20 jie.hua Exp $
 */
public interface Instruction {

    /**
     * ���ݴ���������ͣ�ת���ɶ�Ӧ�Ĳ���
     * 
     * @param t
     * @return
     */
    public <T extends BeanWire> T getInstruction(Class<T> t);

}
