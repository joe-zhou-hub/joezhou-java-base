package com.joezhou.thread.collection;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author JoeZhou
 */
public class SynchronizedMapTest {

    @Test
    public void hashtable() {
        Hashtable<String, Object> hashtable = new Hashtable<>();
        hashtable.put("name", "zhao-si");
        hashtable.put("gender", "male");
        hashtable.put("age", 18);
        hashtable.forEach((key, value) -> {
            System.out.println(value);
        });
        System.out.println(hashtable.size());
    }

    @Test
    public void synchronizedHashMap() {
        HashMap<String, Object> hashMap = new HashMap<>(3);
        Map<String, Object> map = Collections.synchronizedMap(hashMap);
        map.put("name", "zhao-si");
        map.forEach((k, v) -> {
            System.out.println(v);
        });
    }

    @Test
    public void concurrentHashMap() {
        Map<Object, Object> map = new ConcurrentHashMap<>(3);
        map.put("name", "zhao-si");
        map.forEach((k, v) -> {
            System.out.println(v);
        });
    }

    @Test
    public void concurrentSkipListMap() {
        Map<Object, Object> map = new ConcurrentSkipListMap<>();
        map.put("name", "zhao-si");
        map.forEach((k, v) -> {
            System.out.println(v);
        });
    }
}
