package com.company;
import java.util.LinkedList;
import java.util.Queue;

/*Queue via Stacks: Implement a Stack class  using two queues. */


public class StackUsingQueue {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    void push(int x) {
        q1.add(x);
    }

    int pop() {

        int data =-1;
        if (q1.isEmpty()) {
            System.out.println("Stack is Empty");
            return data;
        }
        shiftData(q1,q2);
        data = q1.remove();
        swapQueueName(q1,q2);

        return data;

    }

     void shiftData(Queue<Integer> a, Queue<Integer> b){
         while (a.size() != 1) {
             b.add(a.remove());
         }
     }
     void swapQueueName(Queue<Integer> a, Queue<Integer> b){
         Queue<Integer> tmp = a;
         a = b;
         b = tmp;
     }

    public static void main(String[] args) {

        StackUsingQueue q = new StackUsingQueue();
        q.push(100);
        q.push(2);
        q.push(3);

        System.out.println(q.pop());
        q.push(23);
        q.push(53);
        q.push(63);

        System.out.println(q.pop());

    }

}
