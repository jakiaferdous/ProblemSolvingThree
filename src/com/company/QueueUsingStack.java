package com.company;
import java.util.Stack;


/*Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks. */


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
        s1.push(data);
    }

    public int deQueue() {

        int data = 0;

        if (s1.isEmpty()) {
            System.out.println("Queue is Empty");
            return data;
        }
        while (!s1.isEmpty()) {
            shiftElement(s1, s2);
            data = s2.pop();
        }
        while (!s2.isEmpty()) {
            shiftElement(s2, s1);
        }
        return data;

    }

    void shiftElement(Stack<Integer> a, Stack<Integer> b) {
        while (!a.isEmpty()) {
            b.push(a.pop());
        }
    }

    public static void main(String[] args) {

        QueueUsingStack q = new QueueUsingStack();
        q.enQueue(100);
        q.enQueue(2);
        q.enQueue(3);

        System.out.println(q.deQueue());

    }
}
