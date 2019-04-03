package com.company;


/* Stack Min: How would you design a stack which, in addition to push and pop, has a function min
which returns the minimum element? Push, pop and min should all operate in 0(1) time. */

import java.util.Stack;

public class StackMin {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> auxilary = new Stack<>();


    int getMin(){
        if(auxilary.isEmpty()){
            System.out.println("Stack is empty");
            return Integer.parseInt(null);
        }
        return auxilary.peek();

    }

    public void push(int x){

        if(auxilary.isEmpty()){
            auxilary.push(x);
        }else {
            auxilary.push(Math.min(x,auxilary.peek()));
        }
        stack.push(x);
    }
    public int pop(){
        if(!(stack.peek() > auxilary.peek())){
             auxilary.pop();
        }
        return stack.pop();
    }
    public static void main(String[] args)
    {
        StackMin s = new StackMin();
        s.push(3);
        s.push(5);
        System.out.println(s.getMin());
        s.push(2);
        s.push(1);
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.pop();

    }

}
