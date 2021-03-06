package com.somnus.support.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON处理工具类
 * @author Somnus
 * @date 2015年11月5日 下午10:10:58 
 */
public class JsonUtils {

    private static Logger log = LoggerFactory.getLogger(JsonUtils.class);
    
    /**
     * 空JSON字符串
     */
    private final static String EMPTY_JSON_STRING = "{}";
    
    /**
     * Object转换为JSON字符串
     * @Description
     * @param obj
     * @return
     */
    public static String obj2JsonString(Object obj){    
        try{
            ObjectMapper objectMapper = instanceObjectMapper();
            if(obj == null)return EMPTY_JSON_STRING;
            return objectMapper.writeValueAsString(obj);
        } catch (JsonParseException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (JsonMappingException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    
    /**
     * List转换为JSON字符串
     * @Description
     * @param list
     * @return
     */
    public static<E> String list2JsonString(List<E> list){  
        try{
            ObjectMapper objectMapper = instanceObjectMapper();
            if(list == null || list.isEmpty())return EMPTY_JSON_STRING;
            return objectMapper.writeValueAsString(list);
        } catch (JsonParseException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (JsonMappingException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    
    /**
     * Map转换为JSON字符串
     * @param map 需要转换的Map
     * @return
     */
    public static<E, V> String map2JsonString(Map<E, V> map){   
        try{
            ObjectMapper objectMapper = instanceObjectMapper();
            if(map == null || map.isEmpty())return EMPTY_JSON_STRING;
            return objectMapper.writeValueAsString(map);
        } catch (JsonParseException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (JsonMappingException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    
// *************************************以下JSON转换为对象***************************************************************
    
    /**
     * JSON字符串转换为Object
     * @param strJsonString 需要转换的JSON字符串
     * @param clazz
     * @return
     */
    public static<T> T jsonString2Object(String strJsonString, Class<T> clazz){
        try {
            ObjectMapper objectMapper = instanceObjectMapper();
            if(StringUtils.isBlank(strJsonString))strJsonString = EMPTY_JSON_STRING;
            return objectMapper.readValue(strJsonString, clazz);
        } catch (JsonParseException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (JsonMappingException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    
    /**
     * json转换为list
     * @param jsonStr
     * @param clazz
     * @return
     */
    public static<T> List<T> json2ObjectList(String jsonStr , Class<T> clazz){
        ObjectMapper mapper = new ObjectMapper();
        JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class,clazz);
        try {
            jsonStr = replaceString(jsonStr, "&quot;", "\"");
            return mapper.readValue(jsonStr, javaType);
        } catch (JsonParseException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (JsonMappingException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    
    /**
     * JSON字符串转换为Map
     * @param strJsonString 需要转换的JSON字符串
     * @return
     */
    @SuppressWarnings("unchecked")
    public static<E, V> Map<E, V> jsonString2Map(String strJsonString){
        try {
            ObjectMapper objectMapper = instanceObjectMapper();
            if(StringUtils.isBlank(strJsonString))strJsonString = EMPTY_JSON_STRING;
            return objectMapper.readValue(strJsonString, Map.class);
        } catch (JsonParseException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (JsonMappingException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    
    /**
     * 
     * 替换一个字符串中的某些指定字符
     * 
     * @param strData
     *            String 原始字符串
     * 
     * @param regex
     *            String 要替换的字符串
     * 
     * @param replacement
     *            String 替代字符串
     * 
     * @return String 替换后的字符串
     */
    public static String replaceString(String strData, String regex,String replacement){
        if (strData == null) {
            return null;
        }
        int index;
        index = strData.indexOf(regex);
        String strNew = "";
        if (index >= 0) {
            while (index >= 0) {
                strNew += strData.substring(0, index) + replacement;
                strData = strData.substring(index + regex.length());
                index = strData.indexOf(regex);
            }
            strNew += strData;
            return strNew;
        }
        return strData;
    }
    
    /**
     * 实例化ObjectMapper
     * @return
     */
    public static ObjectMapper instanceObjectMapper(){
        JsonFactory jf = new JsonFactory();
        jf.configure(Feature.WRITE_NUMBERS_AS_STRINGS, true);
        return new ObjectMapper(jf);
    }
    
}
