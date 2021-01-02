package com.whiteship.homework.listnode_queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeQueueTest {

    ListNodeQueue queue = new ListNodeQueue();

    @Test
    @DisplayName("큐에 값을 넣는다.")
    void enqueueTest() {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        assertEquals(30, queue.peek());

        assertEquals(10, queue.get(0));
        assertEquals(20, queue.get(1));
        assertEquals(30, queue.get(2));
    }

    @Test
    @DisplayName("큐에서 값을 뺀다.")
    void dequeueTest() {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        assertEquals(10, queue.get(0));
        queue.dequeue();
        assertEquals(20, queue.get(0));
        queue.dequeue();
        assertEquals(30, queue.get(0));

    }

    @Test
    @DisplayName("큐의 사이즈를 확인한다.")
    void sizeTest() {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        assertEquals(5, queue.size());
    }
}