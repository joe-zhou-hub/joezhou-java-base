package com.joezhou.generic;

import org.junit.Before;
import org.junit.Test;

/**
 * @author JoeZhou
 */
public class SingleLinkedListTest {

    private static class SingleLinkedListDemo<E> {

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

        private Node<E> head;

        private SingleLinkedListDemo(E headData) {
            this.head = new Node<>(headData);
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder("single-linked-list: ");
            Node<E> current = this.head;
            while (current != null) {
                result.append("[");
                result.append(current.data);
                result.append("-> ");
                result.append(current.next == null ? "null" : current.next.data);
                result.append("] ");
                current = current.next;
            }
            return result.toString();
        }

        /**
         * 重新设置链表头
         *
         * 创建一个新的节点newNode，注入节点内容
         * newNode节点的next指向原头节点
         * newNode变更为链表头节点
         * @param data 链表头节点数据
         * @return 当前链表
         */
        private SingleLinkedListDemo<E> resetHead(E data) {
            Node<E> newNode = new Node<>(data);
            newNode.next = this.head;
            this.head = newNode;
            return this;
        }

        /**
         * 在链表的尾部追加一个节点
         *
         * 创建一个新的节点newNode，注入节点内容
         * 从头开始向后一直寻找，找到链表的尾节点（currentNode）
         * currentNode节点的next指向newNode
         * @param data 节点数据
         * @return 当前链表
         */
        private SingleLinkedListDemo<E> add(E data) {
            Node<E> currentNode = this.head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = new Node<>(data);
            return this;
        }

        /**
         * 在链表指定位置插入一个节点
         *
         * 如果pos<=0，视为重置头节点操作，直接调用resetHead()
         * 创建一个新的节点newNode，注入节点内容
         * 从头开始向后寻找2次（假设pos值为2）
         * 找到链表中原2号位置上的节点（currentNode）
         * 同时找到链表中原2-1号位置上的节点（preNode）
         * 如果寻找过程中就已经到了节点末尾，直接调用add(E data)
         * preNode节点的next指向newNode
         * newNode节点的next指向currentNode
         * @param data 节点数据
         * @param pos 指定位置，从0开始
         * @return 当前链表
         */
        private SingleLinkedListDemo<E> add(E data, int pos) {

            if (pos <= 0) {
                this.resetHead(data);
                return this;
            }

            Node<E> newNode = new Node<>(data);
            Node<E> currentNode = this.head;
            Node<E> preNode = this.head;
            for (int i = 0; i < pos; i++) {
                if (currentNode.next == null) {
                    add(data);
                    return this;
                }
                preNode = currentNode;
                currentNode = currentNode.next;
            }
            preNode.next = newNode;
            newNode.next = currentNode;
            return this;
        }

        /**
         * 获取指定节点数据对应的节点
         *
         * 从头开始向后一直寻找
         * 寻找的过程中不断地用指定值比对每个节点的data
         * 比对成功返回对应节点
         * 比对失败返回null
         * @param data 节点数据
         * @return 节点数据所在的节点
         */
        private Node<E> get(E data) {
            Node<E> result = null;
            Node<E> currentNode = this.head;
            while (currentNode != null) {
                if (data.equals(currentNode.data)) {
                    result = currentNode;
                    break;
                }
                currentNode = currentNode.next;
            }
            return result;
        }

        /**
         * 删除指定节点数据对应的节点
         *
         * 从头开始向后一直寻找
         * 找到链表中对应指定内容的节点（currentNode）
         * 同时找到currentNode的上一个的节点（preNode）
         * 一旦找到，则将preNode节点的next指向currentNode的next
         * @param data 节点数据
         * @return 当前链表
         */
        private SingleLinkedListDemo<E> delete(E data) {
            Node currentNode = this.head;
            Node preNode = this.head;
            while (currentNode != null) {
                if (data.equals(currentNode.data)) {
                    preNode.next = currentNode.next;
                    break;
                }
                preNode = currentNode;
                currentNode = currentNode.next;
            }
            return this;
        }
    }

    private SingleLinkedListDemo<String> linkList;

    @Before
    public void before() {
        linkList = new SingleLinkedListDemo<>("1111");
    }

    @Test
    public void iterator() {
        System.out.println(linkList);
    }

    @Test
    public void resetHead() {
        System.out.println(linkList);
        System.out.println(linkList.resetHead("2222"));
        System.out.println(linkList.resetHead("3333"));
        System.out.println(linkList.resetHead("4444"));
    }

    @Test
    public void add() {
        System.out.println(linkList);
        System.out.println(linkList.add("2222"));
        System.out.println(linkList.add("3333"));
        System.out.println(linkList.add("4444"));
    }

    @Test
    public void addWithPos() {
        System.out.println(linkList);
        System.out.println(linkList.add("2222", 0));
        System.out.println(linkList.add("3333", 9));
        System.out.println(linkList.add("4444", 1));
        System.out.println(linkList.add("5555", 2));
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
