package com.swed.LR7;

/**
 * "Домашня тварина" — узагальнювач для кота тощо.
 */
public abstract class PetAnimal extends Animal {
    private String ownerName;

    protected PetAnimal(String name, int age, double weight, String ownerName) {
        super(name, age, weight);
        this.ownerName = ownerName;
    }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
}
