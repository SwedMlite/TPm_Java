package com.swed.LR7;

/**
 * "Дика тварина" — узагальнювач для лева тощо.
 */
public abstract class WildAnimal extends Animal {
    private String habitat; // середовище існування

    protected WildAnimal(String name, int age, double weight, String habitat) {
        super(name, age, weight);
        this.habitat = habitat;
    }

    public String getHabitat() { return habitat; }
    public void setHabitat(String habitat) { this.habitat = habitat; }
}
