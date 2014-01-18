/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.tools;

import org.apache.commons.lang3.StringUtils;

/**
 * URL������
 * 
 * @author jie.hua@alipay.com
 * @version $Id: URLTool.java, v 0.1 2014-1-8 ����10:47:40 jie.hua Exp $
 */
public class URLTool {

    /**
     * ����URL��
     * 
     * @param hostUrl
     * @param queryStr
     * @return
     */
    public static String builderURL(String hostUrl, String queryStr) {

        StringBuilder urlBuilder = new StringBuilder(hostUrl);

        if (StringUtils.isBlank(queryStr)) {

            // �ղ�ѯ������׷��
        } else if (StringUtils.contains(urlBuilder, "?")) {
            // �Ѿ�����?��������ӣ�ֱ��&
            urlBuilder.append("&").append(queryStr);
        } else {
            // ������?����Ҫ���?
            urlBuilder.append("?").append(queryStr);
        }

        return urlBuilder.toString();
    }

}
