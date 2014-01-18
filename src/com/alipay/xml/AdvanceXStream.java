/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.xml;

import java.io.Writer;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.alipay.demo.tools.LoggerUtil;
import com.alipay.xml.tools.FieldsTool;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * XStream��ǿ��
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AdvanceXstream.java, v 0.1 2014-1-6 ����9:44:07 jie.hua Exp $
 */
public class AdvanceXStream {

    /**
     * ��������
     */
    private static final String OPERATION_NAME = "��XML������";

    /**
     * ��־����
     */
    private static final Logger logger         = Logger.getLogger(AdvanceXStream.class);

    /**  
     * CDDATA���η���ʼ
     * 
     */
    private static final String PREFIX_CDATA   = "<![CDATA[";

    /**  
     *  CDDATA���η�����
     * 
     */
    private static final String SUFFIX_CDATA   = "]]>";

    /**
     * ��װ����
     */
    private XStream             xStream;

    /**
     * @param xStream
     */
    public AdvanceXStream(XStream xStream) {
        super();
        this.xStream = xStream;
    }

    /**
     * 
     */
    public AdvanceXStream() {

        super();
        this.xStream = new XStream(new XppDriver() {
            @Override
            public HierarchicalStreamWriter createWriter(Writer out) {
                return new PrettyPrintWriter(out) {
                    @Override
                    protected void writeText(QuickWriter writer, String text) {
                        if (StringUtils.isBlank(text)) {
                            super.writeText(writer, text);
                        } else if (text.startsWith(PREFIX_CDATA) && text.endsWith(SUFFIX_CDATA)) {
                            writer.write(text);
                        } else {
                            writer.write(PREFIX_CDATA + text + SUFFIX_CDATA);
                        }
                    }
                };
            };
        });

    }

    /**
     * ע�����������Զ����XStreamAliasע�����ת��
     * 
     * @param objs
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void registerParserClass(Class... clazs) {

        if (clazs == null || clazs.length <= 0) {

            return;
        }

        if (xStream == null) {

            return;
        }

        for (Class clz : clazs) {

            XStreamAlias annotation = (XStreamAlias) clz.getAnnotation(XStreamAlias.class);

            if (annotation != null && (StringUtils.isNotBlank(annotation.value()))) {

                xStream.alias(annotation.value(), clz);
            }

        }

    }

    /**
     * ע��ת����
     * 
     * @param converter
     */
    public void registerConverter(Converter converter) {

        xStream.registerConverter(converter);
    }

    /**
     *  xml -> bean
     * 
     * @param xml
     * @return
     */
    public Object fromXml(String xml) {

        if (StringUtils.isBlank(xml)) {
            return null;
        }

        return xStream.fromXML(xml);
    }

    /**
     * bean -> xml
     * 
     * @param obj
     * @return
     */
    public String toXml(Object obj) {

        if (obj == null) {

            return null;
        }

        return xStream.toXML(obj);
    }

    /**
     * ��������->xml 
     * <pre>
     *  ��toXml��ͬ���ǣ�������ֻ�ǽ���ǰ������������Ա��xml��ʽ����ƴ���ַ�����ʽ
     * </pre>
     * @param obj
     * @return
     */
    public String toArributeXML(Object obj) {

        if (obj == null) {

            return null;
        }

        StringBuilder xmlBuilder = new StringBuilder(100);

        List<Field> declaredFields = FieldsTool.getAllFields(obj);

        // �����������ԣ�ת���ɳ�xml��ǩ��ʽ
        for (Field field : declaredFields) {
            XStreamAlias annotation = field.getAnnotation(XStreamAlias.class);
            if (annotation == null) {
                continue;
            }

            try {

                field.setAccessible(true);
                Object value = field.get(obj);
                if (value == null) {
                    continue;
                }

                xStream.alias(annotation.value(), field.getType());
                String xml = xStream.toXML(value).replace("__", "_");
                xmlBuilder.append(xml);

            } catch (Exception e) {

                LoggerUtil.warn(logger, OPERATION_NAME + ",����ת����XML�쳣", e);
            }
        }

        return xmlBuilder.toString();

    }

}
