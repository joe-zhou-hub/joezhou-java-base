package com.joezhou.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author JoeZhou
 */
public class IteratorTest {

    private List<Integer> arrayList = null;

    @Before
    public void before() {
        for (int i = 0, j = 20; i < j; i++) {
            arrayList.add(i);
        }
    }

    @Test
    public void iterator() {
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            int e = iterator.next();
            if (e == 1) {
                iterator.remove();
            }
            System.out.print(e + "\0");
        }
    }

    @Test
    public void listIterator() {
        ListIterator<Integer> listIter = arrayList.listIterator(0);
        while (listIter.hasNext()) {
            int e = listIter.next();
            if (e == 3) {
                listIter.set(300);
            }
            if (e == 5) {
                listIter.remove();
            }
            System.out.print(e + "\0");
        }
    }

    @Test
    public void reverseListIterator() {
        ListIterator<Integer> listIter = arrayList.listIterator(arrayList.size());
        while (listIter.hasPrevious()) {
            System.out.print(listIter.previous() + "\0");
        }
    }
}
