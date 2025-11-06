package com.swed.LR9;

/**
 * Base class for any product that participates in the robot workflow.
 */
public class Product {
    private final String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
