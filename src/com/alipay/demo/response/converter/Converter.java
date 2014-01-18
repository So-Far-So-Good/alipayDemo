/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.response.converter;

/**
 * ģ��ת���ӿ�
 * 
 * @author jie.hua@alipay.com
 * @version $Id: Converter.java, v 0.1 2014-1-10 ����4:34:53 jie.hua Exp $
 */
public interface Converter<S, T> {

    /**
     * ������srcObj -> Ŀ��obj
     * 
     * @param srcObj  ԭ����
     * @return  Ŀ�����
     */
    public T convert(S srcObj);

    /**
     * ��ȡת��Դclass
     * 
     * @return
     */
    public Class<? extends S> getSrcClass();

    /**
     * ��ȡת����Ŀ��class
     * 
     * @return
     */
    public Class<? extends T> getTargetClass();

}
