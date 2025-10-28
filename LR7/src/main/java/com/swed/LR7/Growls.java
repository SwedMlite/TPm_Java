package com.swed.LR7;

/**
 * Профіль: "Може гарчати".
 * Містить реалізацію за замовчуванням, яку класи можуть перевизначити.
 */
public interface Growls {

    default void growl() {
        System.out.println("Тварина гарчить: «ррр…»");
    }
}
