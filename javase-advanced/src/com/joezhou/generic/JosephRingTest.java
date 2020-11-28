package com.joezhou.generic;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class JosephRingTest {

    private static class JosephRingDemo<E> {
        private Node<E> head;

        private static class Node<E> {
            private E data;
            private Node<E> next;

            private Node(E data) {
                this.data = data;
            }
        }

        private JosephRingDemo(E headData) {
            this.head = new Node<>(headData);
            this.head.next = head;
        }

        public void append(E data) {
            Node<E> currentNode = this.head;
            while (currentNode.next != this.head) {
                currentNode = currentNode.next;
            }
            Node<E> newNode = new Node<>(data);
            currentNode.next = newNode;
            newNode.next = this.head;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            Node<E> current = head;
            do {
                result.append("[");
                result.append(current.data);
                result.append("] ");
                current = current.next;
            } while (current != head);
            return result.toString();
        }

        private void kill() {
            System.out.println(this.toString());
            while (this.head.next != this.head) {
                Node<E> left = this.head.next;
                Node<E> right = this.head.next.next.next;
                left.next = right;
                this.head = right;
                System.out.println(this.toString());
            }
        }
    }

    @Test
    public void josephRing() {
        JosephRingDemo<String> josephRingDemo = new JosephRingDemo<>("1");
        for (int i = 2; i < 11; i++) {
            josephRingDemo.append("" + i);
        }
        josephRingDemo.kill();
    }
}
