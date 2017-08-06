package com.xinyi_tech.commonlibs.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhiren.zhang on 2016/12/8.
 */
public class GsonUtil {
    private static final String TAG = "GsonUtils";

    public static <T> T json2Object(String json, Class<T> clazz) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.fromJson(json, clazz);
    }


    public static <T> List<T> json2List(String json, Class<T> clazz) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type type = new TypeToken<ArrayList<T>>(){}.getType();
        return gson.fromJson(json, type);
    }


    public static String obj2Json(Object obj) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(obj);
    }


}
