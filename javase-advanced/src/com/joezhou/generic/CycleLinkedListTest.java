package com.joezhou.generic;

import org.junit.Before;
import org.junit.Test;

/**
 * @author JoeZhou
 */
public class CycleLinkedListTest {

    private static class CycleLinkedListDemo<E> {

        private Node<E> head;

        private static class Node<E> {
            private E data;
            private Node<E> next;

            private Node(E data) {
                this.data = data;
            }

            @Override
            public String toString() {
                return "[" + data + "-> " + (next == null ? "null" : next.data) + "]";
            }
        }

        private CycleLinkedListDemo(E headData) {
            this.head = new Node<>(headData);
            this.head.next = this.head;
        }

        /**
         * 在链表的脖子位置插入一个新节点
         *
         * 创建一个新的节点newNode，注入节点内容
         * 备份头节点（headNode）
         * 备份脖子节点（neckNode）
         * headNode的next指向newNode
         * newNode的next指向neckNode
         *
         * @param data 节点内容
         * @return 当前链表
         */
        public CycleLinkedListDemo<E> add(E data) {
            Node<E> newNode = new Node<>(data);
            Node<E> headNode = this.head;
            Node<E> neckNode = headNode.next;
            headNode.next = newNode;
            newNode.next = neckNode;
            return this;
        }

        /**
         * 获取指定节点数据对应的节点
         *
         * 备份头节点（currentNode）
         * 先寻找一次，并改变currentNode的指向为下一个，否则循环不进入
         * 只要currentNode不是头，就一直向后寻找
         * 寻找的过程中不断地用指定值比对每个节点的data
         * 比对成功返回对应节点
         * 比对失败返回null
         *
         * @param data 节点内容
         * @return 节点数据所在的节点
         */
        private Node<E> get(E data) {
            Node<E> result = null;
            Node<E> currentNode = this.head;
            do {
                if (data.equals(currentNode.data)) {
                    result = currentNode;
                    break;
                }
                currentNode = currentNode.next;
            } while (currentNode != this.head);
            return result;
        }

        /**
         * 删除指定节点数据对应的节点
         *
         * 备份头节点（headNode）
         * 备份前一个节点（preNode）
         * 先寻找一次，并改变currentNode的指向为下一个，否则循环不进入
         * 只要currentNode不是头，就一直向后寻找
         * 寻找的过程中不断地用指定值比对每个节点的data
         * 比对成功将preNode的next指向currentNode的.next
         * 比对不成功将currentNode备份为preNode，将currentNode指向下一个
         *
         * @param data 节点内容
         * @return 当前链表
         */
        private CycleLinkedListDemo<E> delete(E data) {
            Node currentNode = this.head;
            Node preNode = this.head;
            do {
                if (data.equals(currentNode.data)) {
                    preNode.next = currentNode.next;
                    break;
                }
                preNode = currentNode;
                currentNode = currentNode.next;
            } while (currentNode != this.head);
            return this;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder("cycle-linked-list: ");
            Node<E> current = head;
            do {
                result.append("[");
                result.append(current.data);
                result.append("-> ");
                result.append(current.next == null ? "null" : current.next.data);
                result.append("] ");
                current = current.next;
            } while (current != head);
            return result.toString();
        }
    }

    private CycleLinkedListDemo<String> linkList;

    @Before
    public void before() {
        linkList = new CycleLinkedListDemo<>("1111");
    }

    @Test
    public void add() {
        System.out.println(linkList);
        System.out.println(linkList.add("2222"));
        System.out.println(linkList.add("3333"));
        System.out.println(linkList.add("4444"));
    }

    @Test
    public void get() {
        System.out.println(linkList);
        System.out.println(linkList.add("2222"));
        System.out.println(linkList.add("3333"));
        System.out.println("node: " + linkList.get("2222"));
        System.out.println("node: " + linkList.get("3333"));
        System.out.println("node: " + linkList.get("4444"));
    }

    @Test
    public void delete() {
        System.out.println(linkList);
        System.out.println(linkList.add("2222"));
        System.out.println(linkList.add("3333"));
        System.out.println(linkList.add("4444"));
        System.out.println(linkList.delete("2222"));
        System.out.println(linkList.delete("5555"));
    }
}
