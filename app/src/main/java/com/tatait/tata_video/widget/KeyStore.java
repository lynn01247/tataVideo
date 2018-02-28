package com.tatait.tata_video.widget;

import java.lang.reflect.Field;

/**
 * Created by Lynn on 2016/11/12.
 */
public class KeyStore {
    public static final String BUGLY_APP_ID = "BUGLY_APP_ID";
    public static final String BUGLY_APP_ID_ = "ffadc3cb33";

    public static String getKey(String keyName) {
        try {
            String className = KeyStore.class.getPackage().getName() + ".Keys";
            Class apiKey = Class.forName(className);
            Field field = apiKey.getField(keyName);
            field.setAccessible(true);
            return (String) field.get(null);
        } catch (Exception ignored) {
        }
        return "";
    }
}