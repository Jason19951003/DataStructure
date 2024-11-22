package com.jaosn.datastructure.queue;

import java.util.Scanner;

public class CircularQueue<T> {
    private int maxSize;
    private int front;
    private int rear;
    private T[] queue;
    
    // front和rear要從0開始
    public CircularQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.queue = (T[]) new Object[maxSize];
    }
    
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public int size() {
        return (rear - front + maxSize) % maxSize;
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
        // 因為索引從零開始，所以先取出再加一。
        queue[rear] = item;
        rear = (rear + 1 + maxSize) % maxSize;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        T item = queue[front];
        front = (front + 1 + maxSize) % maxSize;
        return item;
    }

    public void printQueue() {
        for (int i = front; i < front + size(); i++) {
            System.out.print(queue[(i + maxSize) % maxSize] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CircularQueue<Integer> queue = new CircularQueue<>(3);
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
