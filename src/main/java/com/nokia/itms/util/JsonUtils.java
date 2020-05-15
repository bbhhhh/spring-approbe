/**   
 *
 */
package com.nokia.itms.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author haihuab
 * @date 2018年6月9日 上午10:37:19
 */
public class JsonUtils {
    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);
    private static ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    static {
        // 解决实体未包含字段反序列化时抛出异常
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // 对于空的对象转json的时候不抛出错误
        OBJECT_MAPPER.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        // 允许属性名称没有引号
        OBJECT_MAPPER.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        // 允许单引号
        OBJECT_MAPPER.configure(Feature.ALLOW_SINGLE_QUOTES, true);

        OBJECT_MAPPER.setVisibility(PropertyAccessor.ALL, Visibility.ANY);

    }

    public static String objectToJson(Object jsonObj) {
        if (jsonObj == null) {
            throw new IllegalArgumentException("The jsonObj is null");
        }

        //om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String jsonStr = null;

        try {
            jsonStr = OBJECT_MAPPER.writeValueAsString(jsonObj);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }

        return jsonStr;

    }

    public static <T> T jsonToObject(String jsonStr, Class<T> jsonType) {
        if (jsonStr == null) {
            throw new IllegalArgumentException("The jsonStr is null");
        }

        T jsonObj = null;

        try {
            jsonObj = OBJECT_MAPPER.readValue(jsonStr, jsonType);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }

        return jsonObj;

    }

    public static <T> T jsonToObject(File inFile, Class<T> jsonType) {
        if (inFile == null) {
            throw new IllegalArgumentException("The inFile is null");
        }

        T jsonObj = null;

        try {
            jsonObj = OBJECT_MAPPER.readValue(inFile, jsonType);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }

        return jsonObj;

    }

    public static <T> T jsonToObject(InputStream inputStream, Class<T> jsonType) {
        if (inputStream == null) {
            throw new IllegalArgumentException("The inputStream is null");
        }

        T jsonObj = null;

        try {
            jsonObj = OBJECT_MAPPER.readValue(inputStream, jsonType);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }

        return jsonObj;

    }

    public static void main(String[] args) {

        //String jsonStr = "{}";
        //IprobeRequest jsonObj = null;
        //jsonObj = JsonUtils.jsonToObject(jsonStr, IprobeRequest.class);
        //System.out.println(JsonUtils.objectToJson(jsonObj));

        //String jsonStr2 = "{\"deviceInfo\":{\"deviceId\":\"\"},\"keyInfo\":{\"serverTimeStamp\":\"\"}}";
        //String jsonStr2 = "{}";
        //EncryptedMessage jsonObj2 = null;
        //jsonObj2 = JsonUtils.jsonToObject(jsonStr2, EncryptedMessage.class);
        //jsonObj2 = new EncryptedMessageJsonBean();

        //        PeriodConfigParameter pcp = JsonUtils.jsonToObject(
        //                "{\"uploadConfig\": { \"reportMode\": \"MESSAGE\",\"msgreportInterval\": \"600\"}, \"hguInfoConfig\": {\"deviceInfoEnable\": \"TRUE\",\"hguParametersConfig\": { \"wanRateSampleInterval\": \"60\", \"lanRateSampleInterval\": \"60\" }},\"serviceDataConfig\": {\"tcpConnectInfoEnable\": \"TRUE\"}}",
        //                PeriodConfigParameter.class);
        //        System.out.println(JsonUtils.objectToJson(pcp));

    }
}
