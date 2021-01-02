package com.whiteship.homework.stack;

import java.util.EmptyStackException;

public class Stack {

    int[] stk;
    int size;
    int ptr;

    public Stack(int size) {
        this.size = size;
        ptr = 0;
        stk = new int[this.size];
    }

    public void push(int value) {
        if (ptr >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        stk[ptr++] = value;
    }

    public void pop() {
        if (ptr <= 0) {
            throw new EmptyStackException();
        }

        --ptr;
    }

    public int peek() {
        if (ptr <= 0) {
            throw new EmptyStackException();
        }

        return stk[ptr - 1];
    }

    public int get(int index) {
        if (index >= ptr) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return stk[index];
    }

    public int indexOf(int value) {
        for (int i = 0; i < ptr; i++) {
            if (stk[i] == value) {
                return i;
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void clear() {
        ptr = 0;
    }

    public boolean empty() {
        return ptr <= 0;
    }

    public boolean isFull() {
        return ptr >= size;
    }

    public int size() {
        return ptr;
    }

    public void dump() {
        for(int i = 0; i < ptr; i++) {
            System.out.print(stk[i] + " ");
        }
        System.out.println();
    }

}
