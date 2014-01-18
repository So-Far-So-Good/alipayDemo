/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.tools;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * ��־������
 * 
 * @author jie.hua@alipay.com
 * @version $Id: LoggerUtil.java, v 0.1 2014-1-8 ����8:29:48 jie.hua Exp $
 */
public class LoggerUtil {

    /**
     * info��־
     * 
     * @param logger
     * @param msg
     */
    public static void info(Logger logger, String message) {

        if (logger.isInfoEnabled()) {
            logger.info(logPrefix() + message);
        }
    }

    /**
     * warn��־
     * 
     * @param logger
     * @param message
     */
    public static void warn(Logger logger, String message) {

        logger.warn(logPrefix() + message);

    }

    /**
     * warn��־
     * 
     * @param logger
     * @param message
     * @param t
     */
    public static void warn(Logger logger, String message, Throwable t) {

        logger.warn(logPrefix() + message, t);

    }

    /**
     * error��־
     * 
     * @param logger
     * @param message
     */
    public static void error(Logger logger, String message) {

        logger.error(logPrefix() + message);
    }

    /**
     * error��־
     * 
     * @param logger
     * @param message
     * @param t
     */
    public static void error(Logger logger, String message, Throwable t) {

        logger.error(logPrefix() + message, t);
    }

    /**
     * ��ȡ����Logger��ĵ�����,���÷���,������,�Լ�ͳһ������ID
     * 
     * <p>
     * ��[LoggerUtil-main-165][343434343434]
     * 
     * @return ���ؽ��
     */
    public static String getCaller() {
        StackTraceElement stack[] = (new Throwable()).getStackTrace();
        StackTraceElement s = stack[3];

        // ����
        String className = StringUtils.left(s.getFileName(),
            StringUtils.lastIndexOf(s.getFileName(), "."));

        // ������
        String methodName = s.getMethodName();

        // ����
        int lineNumber = s.getLineNumber();

        return "[" + className + "." + methodName + "(" + lineNumber + ")][threadId="
               + getCurrentThreadId() + "]";
    }

    /**
     * ��־��ӡʱǰ׺���
     * @return �������ǰ׺��Ľ��
     */
    private static String logPrefix() {
        return getCaller() + " --> ";
    }

    /**
     * ��ȡ��ǰ�߳�ID
     * 
     * @return
     */
    private static long getCurrentThreadId() {

        return Thread.currentThread().getId();

    }
}
