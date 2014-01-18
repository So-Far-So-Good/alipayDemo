/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.in;

import com.alipay.demo.bean.ToStringBase;

/**
 * ����û������Ϣ
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayInUserInfo.java, v 0.1 2014-1-6 ����10:52:53 jie.hua Exp $
 */
public class AlipayInUserInfo extends ToStringBase {

    /** ���к�ID  */
    private static final long serialVersionUID = 1649348479572036077L;

    /**
     * ֧�����˺�
     */
    private String            logon_id;

    /**
     * ֧�����û���
     */
    private String            user_name;

    /**
     * Getter method for property <tt>logon_id</tt>.
     * 
     * @return property value of logon_id
     */
    public String getLogon_id() {
        return logon_id;
    }

    /**
     * Setter method for property <tt>logon_id</tt>.
     * 
     * @param logon_id value to be assigned to property logon_id
     */
    public void setLogon_id(String logon_id) {
        this.logon_id = logon_id;
    }

    /**
     * Getter method for property <tt>user_name</tt>.
     * 
     * @return property value of user_name
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * Setter method for property <tt>user_name</tt>.
     * 
     * @param user_name value to be assigned to property user_name
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

}
