package com.whiteship.homework.listnode_stack;

import com.whiteship.homework.linkedlist.ListNode;

public class ListNodeStack {
    ListNode head;

    public void push(int value) {
        ListNode node = new ListNode(value);

        if (head == null) {
            head = node;
            return;
        }

        ListNode crnt = head;

        while (crnt.getNext() != null) {
            crnt = crnt.getNext();
        }

        crnt.setNext(node);
    }

    public void pop() {
        if (head == null) {
            return;
        }

        ListNode node = head;
        ListNode prev = node;

        while (node.getNext() != null) {
            prev = node;
            node = node.getNext();
        }

        prev.setNext(null);
    }

    public ListNode get(int index) {
        ListNode node = head;

        while (index-- > 0) {
            if (node.getNext() == null && index > 0) {
                throw new IndexOutOfBoundsException();
            }
            node = node.getNext();
        }

        return node;
    }

    public boolean isEmpty() {
        return head == null;
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
        ListNodeStack listNodeStack = new ListNodeStack();
        listNodeStack.push(10);
        listNodeStack.push(20);
        listNodeStack.push(30);

        listNodeStack.pop();

        listNodeStack.travel();

    }
}
