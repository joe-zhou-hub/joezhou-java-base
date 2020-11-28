package com.joezhou.thread.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author JoeZhou
 */
public class SynchronizedListTest {

    @Test
    public void vectorByDebug() {
        Vector<String> vector = new Vector<>();
        System.out.println(vector.add("zhao-si"));
        vector.add(0, "liu-neng");
        vector.add(1, "da-jiao");
        System.out.println(vector.set(1, "chang-gui"));
        System.out.println(vector.get(1));
        System.out.println(vector.capacity());
        System.out.println(vector.size());
        System.out.println(vector.contains("da-jiao"));
        System.out.println(vector.indexOf("chang-gui"));
        System.out.println(vector.firstElement());
        System.out.println(vector.lastElement());
        System.out.println(vector.removeElement("liu-neng"));
        System.out.println(vector.remove(0));
        vector.clear();
    }

    @Test
    public void synchronizedList() {
        ArrayList<String> arrayList = new ArrayList<>();
        List<String> list = Collections.synchronizedList(arrayList);
        list.add("zhao-si");
        System.out.println(list.get(0));
    }

    @Test
    public void copyOnWriteArrayList() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("zhao-si");
        System.out.println(list.get(0));
    }
}
