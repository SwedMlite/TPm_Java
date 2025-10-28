package com.swed.LR7;

/**
 * Лев — дика тварина, хижа, здатна гарчати.
 */
public class Lion extends WildAnimal implements Carnivorous, Growls {

    private int prideSize; // розмір прайду (соціальна структура левів)

    public Lion(String name, int age, double weight, String habitat, int prideSize) {
        super(name, age, weight, habitat);
        this.prideSize = prideSize;
    }

    public int getPrideSize() { return prideSize; }
    public void setPrideSize(int prideSize) { this.prideSize = prideSize; }

    @Override
    public void makeSound() {
        System.out.println(getName() + " ричить могутньо: «RROOAARR!»");
    }

    @Override
    public void feed(String food) {
        System.out.println(getName() + " поїдає: " + food);
    }

    @Override
    public void eatMeat(String meat) {
        System.out.println(getName() + " жадібно їсть м'ясо: " + meat);
    }

    @Override
    public void growl() {
        System.out.println(getName() + " грізно гарчить: «GRRR…»");
    }
}
