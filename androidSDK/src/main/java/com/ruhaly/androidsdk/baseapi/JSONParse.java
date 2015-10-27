package com.ruhaly.androidsdk.baseapi;

import com.google.gson.Gson;

/**
 * JSON Object生成工具
 *
 * @param <T>
 */
public final class JSONParse<T> implements IDataParse<T> {

    Gson gson = new Gson();
//    ObjectMapper mObjectMapper = new ObjectMapper();

    /**
     * @param data
     * @param clazz
     * @return
     */
    @Override
    public T toBean(String data, Class<T> clazz) {
        T t = null;
        try {

            return gson.fromJson(data, clazz);//mObjectMapper.readValue(data, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

}
