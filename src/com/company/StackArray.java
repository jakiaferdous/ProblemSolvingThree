package com.company;

/*Three in One: Describe how you could use a single array to implement three stacks. */

public class StackArray {

    int[] array; // 3 stack, 0,1,2
    int eachStackSize; // each stack size is 10
    int[] top = {-1, -1, -1};   // top element of each stack

    StackArray(int capacity) {
        eachStackSize = capacity;
        array = new int[eachStackSize * 3];
    }

    private boolean isEmpty(int stack) {
        return top[stack] <= -1;

    }

    private boolean isFull(int stack) {
        return top[stack] >= eachStackSize - 1;
    }


    private int indexOfArray(int stack) {
        int arrayStart = eachStackSize * stack;
        return arrayStart + top[stack];
    }

    public void push(int stack, int data) {
        if (isFull(stack)) {
            System.out.println("Stack is full.");
            return;
        }
        top[stack] += 1;
        int index = indexOfArray(stack);
        array[index] = data;
    }

    public void print() {
       for(int x : array){
           System.out.print(x + " ");
       }
    }

    public void pop(int stack){
        if(isEmpty(stack)){
            System.out.println("Stack is empty.");
            return;
        }
        array[indexOfArray(stack)] = 0;
        top[stack] -=1;

    }

    public static void main(String[] args) {
        StackArray sa = new StackArray(2);

        sa.push(0, 12);
        sa.push(0, 54);
        sa.push(1,77);
        sa.push(1, 5);
        sa.push(2, 25);
        sa.push(2, 45);
        sa.pop(2);
        sa.print();

    }
}