
package com.swed.LR8;

import java.lang.reflect.Field;

public class ExceptionsDemo {

    // 1) NullPointerException — спроба дізнатись довжину масиву, який == null
    private static void demoNullPointer() {
        System.out.println("— NullPointerException (length масиву=null):");
        int[] arr = null;
        try {
            int len = arr.length; // призведе до NPE
            System.out.println("Довжина: " + len);
        } catch (NullPointerException e) {
            System.out.println("Перехоплено: " + e);
        }
    }

    // 2) IllegalAccessException — доступ до приватного поля без дозволу (через Reflection)
    private static void demoIllegalAccess() {
        System.out.println("— IllegalAccessException (рефлексія до приватного поля):");
        SecretTop s = new SecretTop();
        try {
            java.lang.reflect.Field f = SecretTop.class.getDeclaredField("hidden");
// f.setAccessible(false); // і так false за замовчуванням
            Object v = f.get(s); // тут кинеться IllegalAccessException
            System.out.println("Значення: " + v);
        } catch (NoSuchFieldException e) {
            System.out.println("Поле не знайдено: " + e);
        } catch (IllegalAccessException e) {
            System.out.println("Перехоплено: " + e);
        }
    }

    // 3) CloneNotSupportedException — виклик super.clone() без реалізації Cloneable
    private static void demoCloneNotSupported() {
        System.out.println("— CloneNotSupportedException (клон без Cloneable):");
        class NotCloneable {
            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone(); // кине CloneNotSupportedException
            }
        }
        try {
            NotCloneable a = new NotCloneable();
            a.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Перехоплено: " + e);
        }
    }

    public static void runAll() {
        demoNullPointer();
        demoIllegalAccess();
        demoCloneNotSupported();
    }
}
