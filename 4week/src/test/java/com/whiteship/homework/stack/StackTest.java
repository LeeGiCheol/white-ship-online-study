package com.whiteship.homework.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    @DisplayName("스택에 값 추가")
    void pushTest() {
        Stack stack = new Stack(5);

        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.peek());
        assertEquals(10, stack.get(0));
    }

    @Test
    @DisplayName("스택의 맨 위의 값 제거")
    void popTest() {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.get(2));

        stack.pop();

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stack.get(2));
    }

}