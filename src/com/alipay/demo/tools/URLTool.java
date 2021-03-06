/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.tools;

import org.apache.commons.lang3.StringUtils;

/**
 * URL工具类
 * 
 * @author jie.hua@alipay.com
 * @version $Id: URLTool.java, v 0.1 2014-1-8 下午10:47:40 jie.hua Exp $
 */
public class URLTool {

    /**
     * 构建URL串
     * 
     * @param hostUrl
     * @param queryStr
     * @return
     */
    public static String builderURL(String hostUrl, String queryStr) {

        StringBuilder urlBuilder = new StringBuilder(hostUrl);

        if (StringUtils.isBlank(queryStr)) {

            // 空查询串则不用追加
        } else if (StringUtils.contains(urlBuilder, "?")) {
            // 已经包含?则无需添加，直接&
            urlBuilder.append("&").append(queryStr);
        } else {
            // 不包含?则需要添加?
            urlBuilder.append("?").append(queryStr);
        }

        return urlBuilder.toString();
    }

}
