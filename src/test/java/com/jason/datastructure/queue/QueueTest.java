package com.jason.datastructure.queue;

import com.jaosn.datastructure.queue.ArryaQueue;
import org.junit.Test;

import java.util.Scanner;

public class QueueTest {

    @Test
    public void arrayQueueTest() {
        Scanner sc = new Scanner(System.in);
        ArryaQueue<Integer> queue = new ArryaQueue<>(3);
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
                    int a = sc.nextInt();
                    queue.enqueue(a);
                    break;
                case 'd':
                    int d = queue.dequeue();
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
