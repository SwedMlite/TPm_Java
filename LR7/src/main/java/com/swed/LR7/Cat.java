package com.swed.LR7;

/**
 * Кішка — домашня тварина, хижа, здатна гарчати.
 */
public class Cat extends PetAnimal implements Carnivorous, Growls {

    public Cat(String name, int age, double weight, String ownerName) {
        super(name, age, weight, ownerName);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " каже: «мяу!»");
    }

    @Override
    public void feed(String food) {
        System.out.println(getName() + " їсть: " + food);
    }

    @Override
    public void eatMeat(String meat) {
        System.out.println(getName() + " із задоволенням їсть м'ясо: " + meat);
    }

    @Override
    public void growl() {
        System.out.println(getName() + " тихо гарчить: «рррр…»");
    }
}
