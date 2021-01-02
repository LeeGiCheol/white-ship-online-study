package com.whiteship.homework.queue;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    static Queue queue;

    @BeforeEach
    void setup() {
        queue = new Queue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
    }

    @Test
    @DisplayName("큐에 값이 없는지 확인한다.")
    void isEmptyTest() {
        queue.clear();
        assertTrue(queue.isEmpty());
    }

    @Test
    @DisplayName("큐에 값이 찼는지 확인한다.")
    void isFullTest() {
        assertTrue(queue.isFull());
    }

    @Test
    @DisplayName("큐에 값을 모두 삭제한다.")
    void clearTest() {
        queue.clear();
        assertEquals(0, queue.size());
    }

    @Test
    @DisplayName("큐에 값을 넣는다.")
    void enqueueTest() {
        queue.clear();

        queue.enqueue(30);
        queue.enqueue(40);

        assertEquals(30, queue.get(0));
        assertEquals(40, queue.get(1));

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> queue.get(2));
    }

    @Test
    @DisplayName("큐에서 값을 뺀다.")
    void dequeueTest() {
        assertEquals(5, queue.size());

        queue.dequeue();
        assertEquals(4, queue.size());
        assertEquals(20, queue.peek());

        queue.dequeue();
        assertEquals(30, queue.peek());

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        assertEquals(0, queue.size());
    }

}