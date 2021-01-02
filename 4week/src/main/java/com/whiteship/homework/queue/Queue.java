package com.whiteship.homework.queue;

public class Queue {

    int size;
    int front;
    int rear;
    int num;
    int[] que;


    public Queue(int size) {
        front = rear = num = 0;
        this.size = size;
        que = new int[size];
    }


    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("큐가 가득 찼습니다.");
            return;
        }

        que[rear++] = value;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("큐가 비어있습니다.");
            return;
        }

        front++;
        rear--;
    }

    public int get(int index) {
        if (index > size || index >= rear) {
            throw new ArrayIndexOutOfBoundsException();
        }


        return que[index];
    }

    public int peek() {
        return que[front];
    }

    public boolean isEmpty() {
        return rear <= 0;
    }

    public boolean isFull() {
        return rear >= size;
    }

    public void travel() {
        if (rear <= 0) {
            return;
        }

        for (int i = front; i < rear; i++) {
            System.out.print(que[i] + " ");
        }
        System.out.println();
    }

    public int size() {
        return rear;
    }

    public void clear() {
        front = rear = 0;
    }

}
