package com.whiteship.homework.listnode_stack;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeStackTest {

    static ListNodeStack listNodeStack;

    @BeforeAll
    static void setup() {
        listNodeStack = new ListNodeStack();
        listNodeStack.push(10);
        listNodeStack.push(20);
        listNodeStack.push(30);
    }

    @Test
    @DisplayName("스택이 비었는지 점검")
    void isEmpty() {
        assertFalse(listNodeStack.isEmpty());
    }

    @Test
    @DisplayName("스택에 값 추가")
    void pushTest() {
        assertAll(
            () -> assertEquals(10, listNodeStack.get(0).getValue()),
            () -> assertEquals(20, listNodeStack.get(1).getValue())
        );
    }


    @Test
    @DisplayName("스택 마지막 값 삭제")
    void popTest() {
        assertEquals(30, listNodeStack.get(2).getValue());
        listNodeStack.pop();
        assertNull(listNodeStack.get(2));
    }
}