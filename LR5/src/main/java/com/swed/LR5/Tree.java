package com.swed.LR5;

class Tree extends Plant {
    private double trunkDiameter;
    private String barkType;
    private int numberOfRings;
    private boolean hasLeaves;


    public Tree() {
        super();
        this.trunkDiameter = 0.0;
        this.barkType = "";
        this.numberOfRings = 0;
        this.hasLeaves = true;
    }


    public Tree(String species, double height, int age, String color,
                double trunkDiameter, String barkType) {
        super(species, height, age, color);
        this.trunkDiameter = trunkDiameter;
        this.barkType = barkType;
        this.numberOfRings = age;
        this.hasLeaves = true;
    }


    public double getTrunkDiameter() {
        return trunkDiameter;
    }

    public String getBarkType() {
        return barkType;
    }

    public int getNumberOfRings() {
        return numberOfRings;
    }

    public boolean hasLeaves() {
        return hasLeaves;
    }


    public void setTrunkDiameter(double trunkDiameter) {
        this.trunkDiameter = trunkDiameter;
    }

    public void setBarkType(String barkType) {
        this.barkType = barkType;
    }

    public void setNumberOfRings(int numberOfRings) {
        this.numberOfRings = numberOfRings;
    }

    public void setHasLeaves(boolean hasLeaves) {
        this.hasLeaves = hasLeaves;
    }


    @Override
    public void grow() {
        if (isAlive()) {
            setHeight(getHeight() + 15.0);
            setAge(getAge() + 1);
            trunkDiameter += 1.5;
            numberOfRings++;

            System.out.println("Дерево '" + getSpecies() + "' виросло на 15 см. " +
                    "Поточна висота: " + getHeight() + " см, вік: " + getAge() + " років");
            System.out.println("   Діаметр стовбура: " + trunkDiameter + " см, " +
                    "Річних кілець: " + numberOfRings);
            System.out.println("   Тип кори: " + barkType + ", Має листя: " + hasLeaves);
        } else {
            System.out.println("Дерево не може рости, оскільки не є живим.");
        }
    }

    @Override
    public String toString() {
        return "Дерево [Вид: " + getSpecies() + ", Висота: " + getHeight() + " см, " +
                "Вік: " + getAge() + " років, Колір: " + getColor() +
                ", Діаметр стовбура: " + trunkDiameter + " см, Тип кори: " + barkType +
                ", Річних кілець: " + numberOfRings + "]";
    }
}
