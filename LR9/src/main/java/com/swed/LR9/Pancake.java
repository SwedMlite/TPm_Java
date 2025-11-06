package com.swed.LR9;

/**
 * Represents an individual pancake blank that can be fried.
 */
public class Pancake extends Product {
    private boolean fried;

    public Pancake(boolean fried) {
        super("млинець");
        this.fried = fried;
    }

    public boolean isFried() {
        return fried;
    }

    public void setFried(boolean fried) {
        this.fried = fried;
    }
}
