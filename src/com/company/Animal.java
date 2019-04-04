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
    String name;
    int order;

    Animal(String n) {
        name = n;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }


    boolean olderThan(Animal a) {
        return this.getOrder() < a.getOrder();

    }

}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }
}

class QueueAnimal {
    Queue<Dog> dog = new LinkedList<>();
    Queue<Cat> cat = new LinkedList<>();
    int order = 0;

    void enQueue(Animal animal) {

        animal.setOrder(order);
        order++;

        if (animal instanceof Dog) {
            dog.add((Dog) animal);

        } else if (animal instanceof Cat) {
            cat.add((Cat) animal);
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

        Dog dog1 = new Dog("Mini");
        Dog dog2 = new Dog("Rini");
        Dog dog3 = new Dog("Lini");

        Cat cat1 = new Cat("Ale");
        Cat cat2 = new Cat("Kyle");

        QueueAnimal qa = new QueueAnimal();

        qa.enQueue(dog1);
        qa.enQueue(dog2);
        qa.enQueue(dog3);
        qa.enQueue(cat1);
        qa.enQueue(cat2);

        System.out.println(qa.dequeueDog().name);
        System.out.println(qa.dequeueCat().name);
        System.out.println(qa.dequeueAny().name);


    }


}

