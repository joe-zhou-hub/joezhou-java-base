package com.joezhou.collection;

import org.junit.Test;

import java.io.Serializable;
import java.util.*;

/**
 * @author JoeZhou
 */
@SuppressWarnings("all")
public class WorkTest {

    @SuppressWarnings("unchecked")
    private static class CustomArrayList<E> {
        private E[] array;
        private int total;

        private CustomArrayList() {
            this(10);
        }


        private CustomArrayList(int size) {
            array = (E[]) new Object[size];
        }

        public void add(E e) {
            if (total >= array.length) {
                E[] newArr = (E[]) new Object[array.length + 10];
                System.arraycopy(array, 0, newArr, 0, array.length);
                newArr[total] = e;
                array = newArr;
            } else {
                array[total] = e;
            }
            total++;
        }


        public E get(int index) {
            if (total <= index) {
                throw new IndexOutOfBoundsException();
            } else {
                return array[index];
            }
        }


    }

    private static class Student implements Serializable {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        Student(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student [name=" + name + "]";
        }
    }

    @Test
    public void customArrayList() {
        CustomArrayList<Student> list = new CustomArrayList<>();
        for (int i = 0, j = 100; i < j; i++) {
            list.add(new Student("name-" + i));
        }
        System.out.println(list.get(99));
        System.out.println(list.get(200));
    }

    @Test
    public void iteratorMapByKeySet() {
        Map<String, Object> map = new HashMap<>(3);
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");

        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }

    @Test
    public void charMappingCount() {
        String str = "aabawebaaabbeecc";
        Map<Character, Integer> map = new HashMap<>(5);
        for (Character character : str.toCharArray()) {
            Integer count = map.get(character);
            if (count == null) {
                map.put(character, 1);
            } else {
                map.put(character, ++count);
            }
        }
        System.out.println(map);
    }

    @Test
    public void arrayListVsLinkedList() {
        long testData = 10_0000L;
        long start = 0L;
        long end = 0L;

        ArrayList<Integer> arrayList = new ArrayList<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < testData; i++) {
            arrayList.add(0, i);
        }
        end = System.currentTimeMillis();
        System.out.println("ArrayList spend: " + (end - start));

        start = System.currentTimeMillis();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < testData; i++) {
            linkedList.add(0, i);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList spend: " + (end - start));
    }

    @Test
    public void sortedTreeSet() {
        TreeSet<Object> treeSet = new TreeSet<>(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 1;
            }
        });

        treeSet.add(1);
        treeSet.add(4);
        treeSet.add(3);
        treeSet.add(2);

        System.out.println(treeSet);
    }

    @Test
    public void sortedByStringLength() {
        Set<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int prevLength = o1.length();
                int nextLength = o2.length();
                return prevLength == nextLength ? 1 : prevLength - nextLength;
            }
        });
        set.add("a");
        set.add("bc");
        set.add("aaa");
        set.add("aaaa");
        set.add("bbab");
        set.add("cdfa");
        set.add("b");
        set.add("c");
        for (String str : set) {
            System.out.println(str);
        }
    }


}
