package com.jaosn.datastructure.queue;

// 一般的陣列實現Queue
public class ArryaQueue<T> {
    private int maxSize;
    private int front;
    private int rear;
    private T[] queue;

    public ArryaQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
        this.queue = (T[]) new Object[maxSize];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public int size() {
        return rear - front;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return queue[front];
    }

    public void enqueue(T item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear++;
        queue[rear] = item;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        front++;
        return queue[front];
    }

    public void printQueue() {
        for (int i = 0; i < rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}
