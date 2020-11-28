package com.joezhou.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.TreeMap;

/**
 * @author JoeZhou
 */
public class TreeMapTest {

    private TreeMap<String, Object> treeMap;

    @Before
    public void before() {
        treeMap = new TreeMap<>();
    }

    @Test
    public void create() {
        treeMap.put("1", "a");
        treeMap.put("3", "c");
        treeMap.put("2", "b");
        treeMap.put("4", "f");
        treeMap.put("5", "e");
        System.out.println(treeMap);
    }

    @Test
    public void retrieve() {
        this.create();
        System.out.println(treeMap.ceilingEntry("2"));
        System.out.println(treeMap.ceilingKey("4"));
        System.out.println(treeMap.higherEntry("2"));
        System.out.println(treeMap.higherKey("2"));

        System.out.println(treeMap.floorEntry("4"));
        System.out.println(treeMap.floorKey("2"));
        System.out.println(treeMap.lowerEntry("4"));
        System.out.println(treeMap.lowerKey("2"));

        System.out.println(treeMap.comparator());

        System.out.println(treeMap.descendingMap());
        System.out.println(treeMap.descendingKeySet());

        System.out.println(treeMap.firstEntry());
        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.lastEntry());
        System.out.println(treeMap.lastKey());
    }

    @Test
    public void intercept() {
        this.create();
        System.out.println(treeMap.headMap("4"));
        System.out.println(treeMap.headMap("4", true));
        System.out.println(treeMap.tailMap("3"));
        System.out.println(treeMap.tailMap("3", false));
        System.out.println(treeMap.subMap("2", "4"));
        System.out.println(treeMap.subMap("2", false, "3", true));
    }
}



