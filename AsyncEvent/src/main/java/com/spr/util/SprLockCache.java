package com.spr.util;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 */
public class SprLockCache {
    private static ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
    static String put(String key,String value){
        return concurrentHashMap.putIfAbsent(key,value);
    }
    static void remove(String key){
        concurrentHashMap.remove(key);
    }
    static String get(String key){
        return concurrentHashMap.get(key);
    }
}
