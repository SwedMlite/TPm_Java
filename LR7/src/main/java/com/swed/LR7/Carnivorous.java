package com.swed.LR7;

/**
 * Профіль: "Харчується тваринною їжею".
 * Демонструє наявність методу за замовчуванням.
 */
public interface Carnivorous {

    /** З'їсти порцію мʼяса. */
    void eatMeat(String meat);

    /** Чи є тварина хижаком. */
    default boolean isCarnivorous() {
        return true;
    }
}
