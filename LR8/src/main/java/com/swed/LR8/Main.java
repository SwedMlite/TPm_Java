package com.swed.LR8;

import com.swed.LR8.tasks.Task2Basketball;

public class Main {
    public static void main(String[] args) {
        ExceptionsDemo.runAll();

        System.out.println("=== Обробка файлів (вихідні файли створюються у каталозі ./out) ===");

        String outDir = "./out";
        new java.io.File(outDir).mkdirs();

        try {
            new Task2Basketball().process("task2.txt", outDir + "/out_task2.txt");
            System.out.println("Task2: готово -> " + outDir + "/out_task2.txt");
        } catch (java.io.IOException e) {
            System.err.println("Task2: помилка вводу/виводу: " + e.getMessage());
            e.printStackTrace();
        } catch (RuntimeException e) {
            System.err.println("Task2: неочікувана помилка під час запису: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
