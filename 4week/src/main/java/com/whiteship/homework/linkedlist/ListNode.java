package com.whiteship.homework.linkedlist;

import java.util.ArrayList;

public class ListNode {
    private ListNode next;
    private int value;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
