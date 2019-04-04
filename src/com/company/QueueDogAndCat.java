package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Animal{

    String name;
    String type;

    Animal(String n,String t){
        name = n;
        type = t;
    }

}

public class QueueDogAndCat {
    Queue<Animal> queue = new LinkedList<>();

    void enqueue(Animal a){
        queue.add(a);
    }

    Animal dequeueAny(){
        return queue.poll();
    }
    Animal dequeueDog(){
        for(Animal x : queue){

            if(x.type == "Dog"){
                return x;
            }

        }
        return null;
    }

    Animal dequeueCat(){
        for(Animal x : queue){

            if(x.type == "Cat"){
                return x;
            }

        }
        return null;
    }

    public static void main(String[] args) {

        Animal mini = new Animal("mimi","Dog");
        Animal rini = new Animal("rimi","Dog");
        Animal dini = new Animal("dini","Cat");

        QueueDogAndCat qa = new QueueDogAndCat();
        qa.enqueue(mini);
        qa.enqueue(rini);
        qa.enqueue(dini);


        System.out.println(qa.dequeueAny().name);


    }

}
