package com.company;

import java.util.LinkedList;
import java.util.Queue;

/* Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first
out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
that type). They cannot select which specific animal they would like. Create the data structures to
maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
and dequeueCat. You may use the built-in LinkedList data structure. */


public class Animal {

    public static enum Type {
        Dog,
        Cat
    }

    private final int order;

    Animal(int order) {
        this.order = order;
    }

    boolean olderThan(Animal a) {
        return this.order < a.order;
    }

    @Override
    public String toString() {
        return this.getClass().getCanonicalName() + " - " + order;
    }
}

class Dog extends Animal {
    Dog(int order) {
        super(order);
    }
}

class Cat extends Animal {
    Cat(int order) {
        super(order);
    }
}

class QueueAnimal {
    Queue<Dog> dog = new LinkedList<>();
    Queue<Cat> cat = new LinkedList<>();
    int order = 0;

    void enQueue(Animal.Type type) {
        if (type == Animal.Type.Dog) {
            dog.add(new Dog(++order));
        } else {
            cat.add(new Cat(++order));
        }
    }

    Animal dequeueAny() {
        if (dog.peek().olderThan(cat.peek())) {
            return dequeueDog();
        }
        return dequeueCat();
    }

    Animal dequeueDog() {
        return dog.poll();
    }

    Animal dequeueCat() {
        return cat.poll();
    }

    public static void main(String[] args) {

        QueueAnimal qa = new QueueAnimal();

        qa.enQueue(Animal.Type.Dog);
        qa.enQueue(Animal.Type.Dog);
        qa.enQueue(Animal.Type.Cat);
        qa.enQueue(Animal.Type.Dog);
        qa.enQueue(Animal.Type.Cat);

        System.out.println(qa.dequeueDog());
        System.out.println(qa.dequeueCat());
        System.out.println(qa.dequeueAny());
    }


}

