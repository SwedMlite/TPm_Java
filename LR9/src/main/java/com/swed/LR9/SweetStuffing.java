package com.swed.LR9;

/**
 * Sweet stuffing may or may not require preparation depending on its type.
 */
public final class SweetStuffing extends AbstractStuffing {
    private final SweetStuffingType type;

    public SweetStuffing(String name, SweetStuffingType type, boolean prepared) {
        super(name, type.requiresPreparation(), prepared);
        this.type = type;
    }

    public SweetStuffingType getType() {
        return type;
    }

    @Override
    public void prepare() {
        if (!needsPreparation()) {
            // Some sweet fillings (e.g. jam) can be wrapped immediately.
            markPrepared(true);
            return;
        }
        super.prepare();
    }
}
