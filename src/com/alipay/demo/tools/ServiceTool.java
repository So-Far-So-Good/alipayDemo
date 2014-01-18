/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.tools;

import org.apache.commons.lang3.StringUtils;

/**
 * ������ع�����
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ServiceTools.java, v 0.1 2014-1-6 ����4:44:19 jie.hua Exp $
 */
public class ServiceTool {

    /**
     * �ָ���
     */
    public static final String SEPARATOR = "_";

    /**
     * ����֧����->�̻� api����
     * 
     * @param msgType
     * @param eventType
     * @param actionParams
     * @return
     */
    public static String buildInServiceName(String msgType, String eventType, String actionParams) {

        return StringUtils.defaultIfBlank(msgType, StringUtils.EMPTY) + SEPARATOR
               + StringUtils.defaultIfBlank(eventType, StringUtils.EMPTY) + SEPARATOR
               + StringUtils.defaultIfBlank(actionParams, StringUtils.EMPTY);

    }

}
