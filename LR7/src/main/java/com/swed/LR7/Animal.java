package com.swed.LR7;

/**
 * Абстрактний базовий клас "Тварина".
 * Містить спільні атрибути та абстрактні методи для демонстрації поліморфізму.
 */
public abstract class Animal {
    private String name;
    private int age;
    private double weight;

    protected Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    /** Типова поведінка: подати голос (конкретизується у підкласах). */
    public abstract void makeSound();

    /** Типова поведінка: прийом їжі (конкретизується у підкласах). */
    public abstract void feed(String food);

    @Override
    public String toString() {
        return "%s{ім'я='%s', вік=%d, вага=%.1f}".formatted(
                getClass().getSimpleName(), name, age, weight
        );
    }
}
