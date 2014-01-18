/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.tools;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * 
 * ULR��ѯ��������
 * 
 * @author jie.hua@alipay.com
 * @version $Id: URLQueryBuilder.java, v 0.1 2014-1-8 ����10:49:04 jie.hua Exp $
 */
public class URLQueryBuilder {

    /**
     * ��־����
     */
    private static final Logger logger = Logger.getLogger(URLQueryBuilder.class);

    /**
     * ����
     */
    private URLQueryBuilder() {
    }

    /**
     * ��ѯ�ַ�ӳ��
     */
    private Map<String, String> queryMap = new HashMap<String, String>();

    /**
     * ����һ��ʵ��
     * 
     * @return
     */
    public static URLQueryBuilder newBuilder() {

        return new URLQueryBuilder();
    }

    /**
     * ��Ӳ�ѯ��
     * 
     * @param key
     * @param value
     * @return
     */
    public URLQueryBuilder appendQuery(String key, String value) {

        this.queryMap.put(key, value);

        return this;
    }

    /**
     * ת���ɲ�ѯ��
     * 
     * @return
     */
    public String toQueryString() {

        StringBuilder query = new StringBuilder(100);

        if (CollectionUtil.isNotEmpty(this.queryMap)) {

            for (Entry<String, String> entry : this.queryMap.entrySet()) {
                query.append(encode(entry.getKey(), "UTF-8"));
                query.append("=");
                query.append(encode(entry.getValue(), "UTF-8"));
                query.append("&");
            }
        }

        String queryStr = query.toString();
        //ɾ�����һ����
        return StringUtils.left(queryStr, queryStr.length() - 1);

    }

    /**
     * ����
     * 
     * @param value
     * @param charset
     * @return
     */
    private static String encode(String value, String charset) {

        try {
            return URLEncoder.encode(value, charset);
        } catch (UnsupportedEncodingException e) {

            LoggerUtil.error(logger, "��������ת���쳣", e);

            return null;
        }
    }

}
