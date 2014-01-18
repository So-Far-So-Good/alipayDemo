/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.tools;

import java.util.UUID;

/**
 * UUDI������
 * 
 * @author jie.hua@alipay.com
 * @version $Id: UUIDTool.java, v 0.1 2014-1-8 ����10:30:31 jie.hua Exp $
 */
public class UUIDTool {

    /**
     * ��ȡ�����
     * 
     * @return
     */
    public static String random() {

        return UUID.randomUUID().toString();
    }

}
