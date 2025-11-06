package com.swed.LR9;

/**
 * Represents a finished pancake that contains a prepared stuffing.
 */
public final class ReadyPancake<T extends Pancake, S extends Stuffing> {
    private final T pancake;
    private final S stuffing;

    public ReadyPancake(T pancake, S stuffing) {
        this.pancake = pancake;
        this.stuffing = stuffing;
    }

    public T getPancake() {
        return pancake;
    }

    public S getStuffing() {
        return stuffing;
    }

    @Override
    public String toString() {
        return "Це " + pancake + " з начинкою \"" + stuffing + "\"";
    }
}
