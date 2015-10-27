package com.ruhaly.androidsdk.baseapi;

public interface IDataParse<T> {
    T toBean(String data, Class<T> clazz);
}
