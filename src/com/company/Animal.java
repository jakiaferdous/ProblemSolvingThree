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

    public void setOrder(int ord) {
        order = ord;
    }

    /* Compare orders of animals to return the older item. */
    public boolean isOlderThan(Animal a) {
        return this.getOrder() < a.getOrder();

    }

}

class Dog extends Animal {
    Dog(String dog) {
        super(dog);
    }
}

class Cat extends Animal {
    Cat(String cat) {
        super(cat);

    }

}

class AnimalQueue {

    Queue<Dog> dog = new LinkedList<>();
    Queue<Cat> cat = new LinkedList<>();
    private int order = 0;

    public void enqueue(Animal a) {
        a.setOrder(order);
        order++;
        if (a instanceof Dog) {
            dog.add((Dog) a);
        } else if (a instanceof Cat) {
            cat.add((Cat) a);
        }
    }

    public Animal dequeueAny() {

        if (dog.size() == 0) {
            return dequeueCat();
        } else if (cat.size() == 0) {
            return dequeueDog();
        }

        if (dog.peek().isOlderThan(cat.peek())) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }

    }

    public Animal dequeueDog() {
        return dog.poll();
    }

    public Animal dequeueCat() {
        return cat.poll();
    }

    public static void main(String[] args) {

        Dog dog1 = new Dog("Minie");
        Dog dog2 = new Dog("Rinie");
        Dog dog3 = new Dog("Linie");


        Cat cat1 = new Cat("Rina");
        Cat cat2 = new Cat("Mina");
        Cat cat3 = new Cat("Bina");



        AnimalQueue aq = new AnimalQueue();

        aq.enqueue(dog1);
        aq.enqueue(cat1);
        aq.enqueue(dog2);
        aq.enqueue(cat2);
        aq.enqueue(dog3);
        aq.enqueue(cat3);

        System.out.println(aq.dequeueAny().name);
        System.out.println(aq.dequeueAny().name);
        System.out.println(aq.dequeueDog().name);
        System.out.println(aq.dequeueCat().name);



    }

}