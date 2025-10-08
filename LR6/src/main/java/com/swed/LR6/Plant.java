package com.swed.LR6;

abstract class Plant {
    private String species;
    private double height;
    private int age;
    private String color;
    private boolean isAlive;

    public Plant() {
        this.species = "";
        this.height = 0.0;
        this.age = 0;
        this.color = "";
        this.isAlive = true;
    }

    public Plant(String species, double height, int age, String color) {
        this.species = species;
        this.height = height;
        this.age = age;
        this.color = color;
        this.isAlive = true;
    }

    public String getSpecies() {
        return species;
    }

    public double getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    abstract public void grow();

    @Override
    public String toString() {
        return "Рослина [Вид: " + species + ", Висота: " + height + " см, " +
                "Вік: " + age + " років, Колір: " + color + ", Жива: " + isAlive + "]";
    }
}