package com.joezhou.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JoeZhou
 */
public class ArrayListTest {

    private ArrayList<String> arrayList;

    @Before
    public void before() {
        arrayList = new ArrayList<>(10);
    }

    @Test
    public void create() {
        arrayList.add("China");
        arrayList.add("Japan");
        arrayList.add(1, "Korea");
        arrayList.add(1, "Thailand");

        List<String> europe = new ArrayList<>();
        europe.add("UK");
        europe.add("France");
        arrayList.addAll(europe);

        List<String> africa = new ArrayList<>();
        africa.add("Congo");
        africa.add("Egypt");
        arrayList.addAll(1, africa);

        System.out.println("add over: " + arrayList);
    }

    @Test
    public void retrieve() {
        this.create();
        List<String> europe = new ArrayList<>();
        europe.add("UK");
        europe.add("France");

        System.out.println(arrayList.get(0));
        System.out.println(arrayList.indexOf("China"));
        System.out.println(arrayList.lastIndexOf("UK"));
        System.out.println(arrayList.equals(europe));
        System.out.println(arrayList.contains("Japan"));
        System.out.println(arrayList.containsAll(europe));
        System.out.println(arrayList.isEmpty());
        System.out.println(arrayList.size());
        System.out.println(arrayList.toArray()[0]);
    }

    @Test
    public void update() {
        this.create();

        arrayList.set(1, "UK");
        System.out.println(arrayList);
    }

    @Test
    public void delete() {
        this.create();
        List<String> europe = new ArrayList<>();
        europe.add("UK");
        europe.add("France");
        List<String> africa = new ArrayList<>();
        africa.add("Congo");
        africa.add("Egypt");

        System.out.println(arrayList.subList(0, 3));
        System.out.println(arrayList.remove(1));
        System.out.println(arrayList.remove("Egypt"));
        arrayList.removeAll(europe);
        arrayList.retainAll(africa);
        arrayList.clear();
    }

    @Test
    public void iteratorByFor() {
        this.create();
        for (int i = 0, j = arrayList.size(); i < j; i++) {
            System.out.print(arrayList.get(i) + "\0");
        }
    }

    @Test
    public void iteratorByForEach() {
        this.create();
        for (String str : arrayList) {
            System.out.print(str + "\0");
        }
    }
}
