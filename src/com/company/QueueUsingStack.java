package com.company;
/*Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks. */

import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> s1 = new Stack();
    Stack<Integer> s2 = new Stack();

    public boolean isEmpty() {
        return s1.isEmpty();
    }

    public int size() {
        return s1.size() + s2.size();
    }

    public void enQueue(int data) {

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(data);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

    }

    public int deQueue() {

        if (s1.isEmpty()) {
            System.out.println("Queue is Empty");
            System.exit(0);
        }
        int data = s1.peek();
        s1.pop();
        return data;
    }

    public static void main(String[] args) {
        QueueUsingStack q = new QueueUsingStack();
        System.out.println(q.deQueue());
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);

        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
    }
}
