package com.swed.LR9;

/**
 * Salty stuffing always requires pre-cooking before wrapping.
 */
public final class SaltyStuffing extends AbstractStuffing {

    public SaltyStuffing(String name, boolean prepared) {
        super(name, true, prepared);
    }

    @Override
    public void prepare() {
        // Salt-based fillings need mandatory preparation (e.g., frying vegetables).
        super.prepare();
    }
}
