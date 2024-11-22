package com.jaosn.datastructure.queue;

import java.util.Scanner;

// 一般的陣列實現Queue
public class ArrayQueue<T> {
    private int maxSize;
    private int front;
    private int rear;
    private T[] queue;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
        this.queue = (T[]) new Object[maxSize];
    }

    public boolean isEmpty() {
        return rear == front;
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
        T item = queue[front];
        return item;
    }

    public void printQueue() {
        for (int i = 0; i < queue.length; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayQueue<Integer> queue = new ArrayQueue<>(3);
        boolean flag = true;

        while(flag) {
            System.out.println("(s)輸出當前的Queue");
            System.out.println("(a)增加元素至Queue");
            System.out.println("(d)取出Queue的元素");
            System.out.println("(e)離開");

            char input = sc.nextLine().charAt(0);

            switch (input) {
                case 's':
                    queue.printQueue();
                    break;
                case 'a':
                    System.out.println("請輸入一個數字");
                    int a = Integer.parseInt(sc.nextLine());
                    queue.enqueue(a);
                    break;
                case 'd':
                    Integer d = queue.dequeue();
                    System.out.println("取出的元素是:" + d);
                    break;
                case 'e':
                    flag = false;
                    break;
            }
        }

        System.out.println("結束程式!");
    }
}
