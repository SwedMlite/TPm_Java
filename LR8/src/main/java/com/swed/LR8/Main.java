
package com.swed.LR8;

import com.swed.LR8.tasks.Task1Animals;
import com.swed.LR8.tasks.Task2Basketball;
import com.swed.LR8.tasks.Task3Students;
import com.swed.LR8.tasks.Task4Products;

public class Main {
    public static void main(String[] args) {
        ExceptionsDemo.runAll();

        System.out.println();
        System.out.println("=== Обробка файлів (вихідні файли створюються у каталозі ./out) ===");
        
        String outDir = "./out";
        new java.io.File(outDir).mkdirs();

        try {
            new Task1Animals().process("task1.txt", outDir + "/out_task1.txt");
            System.out.println("Task1: готово -> " + outDir + "/out_task1.txt");
        } catch (Exception e) {
            System.err.println("Task1: помилка: " + e.getMessage());
            e.printStackTrace();
        }

        try {
            new Task2Basketball().process("task2.txt", outDir + "/out_task2.txt");
            System.out.println("Task2: готово -> " + outDir + "/out_task2.txt");
        } catch (Exception e) {
            System.err.println("Task2: помилка: " + e.getMessage());
            e.printStackTrace();
        }

        try {
            new Task3Students().process("task3.txt", outDir + "/out_task3.txt");
            System.out.println("Task3: готово -> " + outDir + "/out_task3.txt");
        } catch (Exception e) {
            System.err.println("Task3: помилка: " + e.getMessage());
            e.printStackTrace();
        }

        try {
            new Task4Products().process("task4.txt", outDir + "/out_task4.txt", java.time.LocalDate.now());
            System.out.println("Task4: готово -> " + outDir + "/out_task4.txt");
        } catch (Exception e) {
            System.err.println("Task4: помилка: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Готово.");
    }
}
