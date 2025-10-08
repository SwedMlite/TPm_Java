package com.swed.LR6;

public class Bush extends Plant {
    private int numberOfBranches;
    private boolean hasBerriesOrFruits;
    private double crownDiameter;


    public Bush() {
        super();
        this.numberOfBranches = 0;
        this.hasBerriesOrFruits = false;
        this.crownDiameter = 0.0;
    }


    public Bush(String species, double height, int age, String color,
                int numberOfBranches, double crownDiameter) {
        super(species, height, age, color);
        this.numberOfBranches = numberOfBranches;
        this.hasBerriesOrFruits = false;
        this.crownDiameter = crownDiameter;
    }


    public int getNumberOfBranches() {
        return numberOfBranches;
    }

    public boolean hasBerriesOrFruits() {
        return hasBerriesOrFruits;
    }

    public double getCrownDiameter() {
        return crownDiameter;
    }


    public void setNumberOfBranches(int numberOfBranches) {
        this.numberOfBranches = numberOfBranches;
    }

    public void setHasBerriesOrFruits(boolean hasBerriesOrFruits) {
        this.hasBerriesOrFruits = hasBerriesOrFruits;
    }

    public void setCrownDiameter(double crownDiameter) {
        this.crownDiameter = crownDiameter;
    }


    @Override
    public void grow() {
        if (isAlive()) {
            setHeight(getHeight() + 8.0);
            setAge(getAge() + 1);
            crownDiameter += 5.0;
            numberOfBranches += 2;

            System.out.println("Кущ '" + getSpecies() + "' виріс на 8 см. " +
                    "Поточна висота: " + getHeight() + " см, вік: " + getAge() + " років");
            System.out.println("   Діаметр крони: " + crownDiameter + " см, " +
                    "Кількість гілок: " + numberOfBranches);

            if (getAge() >= 2) {
                hasBerriesOrFruits = true;
                System.out.println("   Кущ почав плодоносити!");
            }
        } else {
            System.out.println("Кущ не може рости, оскільки не є живим.");
        }
    }

    @Override
    public String toString() {
        return "Кущ [Вид: " + getSpecies() + ", Висота: " + getHeight() + " см, " +
                "Вік: " + getAge() + " років, Колір: " + getColor() +
                ", Гілок: " + numberOfBranches + ", Діаметр крони: " + crownDiameter + " см" +
                ", Плодоносить: " + hasBerriesOrFruits + "]";
    }
}

