package com.whiteship.homework.linkedlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    ListNode head;

    @Test
    @DisplayName("리스트 맨 뒤에 노드를 생성한다.")
    void addTest() {
        LinkedList linkedList = new LinkedList();

        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);

        assertEquals(10, linkedList.head.getValue());
        assertEquals(20, linkedList.head.getNext().getValue());
        assertEquals(30, linkedList.head.getNext().getNext().getValue());
    }

    @Test
    @DisplayName("리스트 원하는 위치에 노드를 생성한다. 순서대로 넣지 않으면 null을 반환한다.")
    void idxAddTest() {
        LinkedList linkedList = new LinkedList();

        linkedList.add(10, 0);
        linkedList.add(20, 1);
        linkedList.add(30, 4);

        assertEquals(10, linkedList.head.getValue());
        assertEquals(20, linkedList.head.getNext().getValue());
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(3));
    }

    @Test
    @DisplayName("리스트 맨 뒤의 노드를 삭제한다.")
    void removeTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(50);

        assertEquals(50, linkedList.get(4));

        linkedList.remove();

        assertEquals(40, linkedList.get(4));

    }

    @Test
    @DisplayName("리스트의 원하는 위치의 노드를 삭제한다.")
    void idxRemoveTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(50);

        linkedList.remove(2);

        assertNotEquals(30, linkedList.get(2));
        assertEquals(40, linkedList.get(2));
    }

    @Test
    @DisplayName("리스트에 존재하는 값인지 검사한다.")
    void containsTest() {
        LinkedList linkedList = new LinkedList();

        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);

        assertTrue(linkedList.contains(linkedList.head, new ListNode(10)));
        assertFalse(linkedList.contains(linkedList.head, new ListNode(50)));
    }
}