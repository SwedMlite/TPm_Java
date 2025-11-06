package com.swed.LR9;

/**
 * Common implementation of {@link Stuffing} that stores the preparation state.
 */
public abstract class AbstractStuffing extends Product implements Stuffing {
    private final boolean needsPreparation;
    private boolean prepared;

    protected AbstractStuffing(String name, boolean needsPreparation, boolean prepared) {
        super(name);
        this.needsPreparation = needsPreparation;
        this.prepared = needsPreparation ? prepared : true;
    }

    @Override
    public boolean needsPreparation() {
        return needsPreparation;
    }

    @Override
    public boolean isPrepared() {
        return prepared;
    }

    @Override
    public void prepare() {
        prepared = true;
    }

    protected void markPrepared(boolean prepared) {
        this.prepared = needsPreparation ? prepared : true;
    }
}
