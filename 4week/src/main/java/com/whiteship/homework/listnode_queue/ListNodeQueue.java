package com.whiteship.homework.listnode_queue;

import com.whiteship.homework.linkedlist.LinkedList;
import com.whiteship.homework.linkedlist.ListNode;

public class ListNodeQueue {
    LinkedList linkedList = new LinkedList();
    ListNode head;

    public void enqueue(int value) {
        head = linkedList.add(head, value);
    }

    public void dequeue() {
        head = linkedList.remove(head, 0);
    }

    public int get(int index) {
        ListNode node = head;

        while (index-- > 0) {
            node = node.getNext();
        }
        return node.getValue();
    }

    public int peek() {
        ListNode node = head;

        while (node.getNext() != null) {
            node = node.getNext();
        }
        return node.getValue();
    }

    public int size() {
        ListNode node = head;

        int index = 0;
        while (node != null) {
            index++;
            node = node.getNext();
        }
        return index;
    }

    public void travel() {
        ListNode node = head;

        while (node != null) {
            System.out.print(node.getValue() + " ");
            node = node.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNodeQueue queue = new ListNodeQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        queue.enqueue(70);
        queue.enqueue(80);
        queue.enqueue(90);
        queue.enqueue(100);

        queue.travel();

        System.out.println(queue.get(0));
        System.out.println(queue.get(1));
        queue.travel();

    }
}
