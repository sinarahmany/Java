package com.company;

public class Dog implements Animal,Pet {
    public void wash() {
        System.out.println("wash the dog every week");
    }
    public void feed() {
        System.out.println("put some food to dogs cup");
    }
    public void cuddle() {
        System.out.println("i am cuddling a dog");
    }

    public void makeSound(){
        System.out.println("HAP HAp");
    }
    public void eat(){
        System.out.println("i am eatng some bones");
    }
    public void move(){
        System.out.println("i move like a dog, i usually run");
    }
}
