package com.joezhou.generic;

import org.junit.Before;
import org.junit.Test;

/**
 * @author JoeZhou
 */
public class DoubleLinkedListTest<T> {

    private static class DoubleLinkedListDemo<E> {

        private static class Node<E> {
            private E data;
            private Node<E> next;
            private Node<E> pre;

            private Node(E data) {
                this.data = data;
            }

            @Override
            public String toString() {
                return "["
                        + (pre == null ? "null" : pre.data)
                        + "<- " + data + "->"
                        + (next == null ? "null" : next.data)
                        + "]";
            }
        }

        private Node<E> head;

        private DoubleLinkedListDemo(E headData) {
            this.head = new Node<>(headData);
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder("double-linked-list: ");
            Node<E> current = this.head;
            while (current != null) {
                result.append("[");
                result.append(current.pre == null ? "null" : current.pre.data);
                result.append(" <-");
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
         * 原头节点的pre指向newNode
         * newNode的next指向原头节点
         * newNode变更为链表头
         *
         * @param data 节点内容
         * @return 当前链表
         */
        private DoubleLinkedListDemo<E> resetHead(E data) {
            Node<E> newNode = new Node<>(data);
            this.head.pre = newNode;
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
         * newNode节点的pre指向currentNode
         *
         * @param data 节点内容
         * @return 当前链表
         */
        private DoubleLinkedListDemo<E> add(E data) {
            Node<E> newNode = new Node<>(data);
            Node<E> currentNode = this.head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
            newNode.pre = currentNode;
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
         * newNode节点的pre指向preNode
         * preNode节点的next指向newNode
         * newNode节点的next指向currentNode
         * currentNode节点的pre指向newNode
         *
         * @param data 节点数据
         * @param pos  指定位置，从0开始
         * @return 当前链表
         */
        private DoubleLinkedListDemo<E> add(E data, int pos) {

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
            newNode.pre = preNode;
            preNode.next = newNode;
            newNode.next = currentNode;
            currentNode.pre = newNode;
            return this;
        }

        /**
         * 获取指定节点数据对应的节点
         *
         * 从头开始向后一直寻找
         * 寻找的过程中不断地用指定值比对每个节点的data
         * 比对成功返回对应节点
         * 比对失败返回null
         *
         * @param data 节点内容
         * @return 节点数据所在的节点
         */
        private Node get(E data) {
            Node<E> result = null;
            Node<E> currentNode = this.head;
            while (currentNode != null) {
                if (data.equals(currentNode.data)) {
                    result = currentNode;
                    break;
                } else {
                    currentNode = currentNode.next;
                }
            }
            return result;
        }

        /**
         * 删除指定节点数据对应的节点
         *
         * 从头开始向后一直寻找
         * 找到链表中对应指定内容的节点（currentNode）
         * currentNode节点的上一个节点的next指向currentNode节点的next
         * currentNode节点的下一个节点的pre指向currentNode节点的pre
         *
         * @param data 节点内容
         * @return 当前链表
         */
        private DoubleLinkedListDemo<E> delete(E data) {
            Node<E> currentNode = this.head;
            while (currentNode != null) {
                if (data.equals(currentNode.data)) {
                    currentNode.pre.next = currentNode.next;
                    currentNode.next.pre = currentNode.pre;
                    break;
                } else {
                    currentNode = currentNode.next;
                }
            }
            return this;
        }

    }

    private DoubleLinkedListDemo<String> linkList;

    @Before
    public void before() {
        linkList = new DoubleLinkedListDemo<>("1111");
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
