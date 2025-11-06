package com.swed.LR9;

/**
 * Defines the catalogue of sweet fillings and whether they need preliminary cooking.
 */
public enum SweetStuffingType {
    JAM(false),
    CUSTARD(true),
    CHOCOLATE(false),
    CURD(true);

    private final boolean requiresPreparation;

    SweetStuffingType(boolean requiresPreparation) {
        this.requiresPreparation = requiresPreparation;
    }

    public boolean requiresPreparation() {
        return requiresPreparation;
    }
}
