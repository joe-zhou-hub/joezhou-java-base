package com.joezhou.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author JoeZhou
 */
public class HashMapTest {

    private HashMap<String, Object> hashMap;

    @Before
    public void before() {
        hashMap = new HashMap<>(5);
    }

    @Test
    public void create() {
        hashMap.put("gong-zuo", "");
        hashMap.put("gong-zuo", "singer");
        hashMap.put("job", "singer");
        hashMap.put("t", null);
        hashMap.put(null, "k");
        hashMap.put(null, null);

        HashMap<String, Object> newHashMap = new HashMap<>(5);
        hashMap.put("a", 1);
        hashMap.put("b", 2);
        hashMap.putAll(newHashMap);

        System.out.println("create over: " + hashMap);
    }

    @Test
    public void retrieve() {
        this.create();
        System.out.println(hashMap.get("gong-zuo"));
        System.out.println(hashMap.containsKey("gong-zuo"));
        System.out.println(hashMap.containsValue("singer"));
        System.out.println(hashMap.isEmpty());
        System.out.println(hashMap.size());
        System.out.println(hashMap.values());
        System.out.println(hashMap.keySet());
    }

    @Test
    public void delete() {
        this.create();
        System.out.println(hashMap.remove("job"));
        hashMap.remove(null);
        hashMap.clear();
    }

    @Test
    public void iteratorByEntrySet() {
        this.create();
        Set<Map.Entry<String, Object>> entries = hashMap.entrySet();
        for (Map.Entry<String, Object> e : entries) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }

    @Test
    public void iteratorByKeySet() {
        this.create();
        Set<String> keys = hashMap.keySet();
        for (String key : keys) {
            System.out.println(key + ": " + hashMap.get(key));
        }
    }

}



