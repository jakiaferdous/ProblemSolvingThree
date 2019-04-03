package com.company;

import java.util.Stack;

public class SortStack {

    Stack<Integer> sortStack(Stack<Integer> s) {
        Stack<Integer> tmpStack = new Stack();

        while (!s.isEmpty()) {
            int tmp = s.pop();
            while (!tmpStack.isEmpty() && (tmpStack.peek() > tmp)) {
                s.push(tmpStack.pop());
            }
            tmpStack.push(tmp);
        }
        return tmpStack;

    }



    public static void main(String args[]) {
        Stack<Integer> input = new Stack<Integer>();
        input.add(34);
        input.add(3);
        input.add(31);
        input.add(98);
        input.add(9);
        input.add(23);

        SortStack ss = new SortStack();

        // This is the temporary stack
        Stack<Integer> tmpStack= ss.sortStack(input);
        System.out.println("Sorted numbers are:");

        while (!tmpStack.empty())
        {
            System.out.print(tmpStack.pop()+" ");
        }
    }


}
