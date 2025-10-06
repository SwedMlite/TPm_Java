package com.swed.LR5;

class Flower extends Plant {
    private int numberOfPetals;
    private String aroma;
    private boolean isBlooming;


    public Flower() {
        super();
        this.numberOfPetals = 0;
        this.aroma = "";
        this.isBlooming = false;
    }


    public Flower(String species, double height, int age, String color,
                  int numberOfPetals, String aroma) {
        super(species, height, age, color);
        this.numberOfPetals = numberOfPetals;
        this.aroma = aroma;
        this.isBlooming = false;
    }


    public int getNumberOfPetals() {
        return numberOfPetals;
    }

    public String getAroma() {
        return aroma;
    }

    public boolean isBlooming() {
        return isBlooming;
    }


    public void setNumberOfPetals(int numberOfPetals) {
        this.numberOfPetals = numberOfPetals;
    }

    public void setAroma(String aroma) {
        this.aroma = aroma;
    }

    public void setBlooming(boolean blooming) {
        isBlooming = blooming;
    }


    @Override
    public void grow() {
        if (isAlive()) {
            setHeight(getHeight() + 2.0);
            setAge(getAge() + 1);
            System.out.println("Квітка '" + getSpecies() + "' виросла на 2 см. " +
                    "Поточна висота: " + getHeight() + " см, вік: " + getAge() + " років");

            if (getAge() >= 1 && !isBlooming) {
                isBlooming = true;
                System.out.println("   Квітка почала цвісти! Кількість пелюсток: " + numberOfPetals);
            }
        } else {
            System.out.println("Квітка не може рости, оскільки не є живою.");
        }
    }

    @Override
    public String toString() {
        return "Квітка [Вид: " + getSpecies() + ", Висота: " + getHeight() + " см, " +
                "Вік: " + getAge() + " років, Колір: " + getColor() +
                ", Пелюсток: " + numberOfPetals + ", Аромат: " + aroma +
                ", Цвіте: " + isBlooming + "]";
    }
}