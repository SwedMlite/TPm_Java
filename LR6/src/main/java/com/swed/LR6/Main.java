package com.swed.LR6;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1.1
        Scanner sc = new Scanner(System.in);

        Plant[] garden = new Plant[6];
        Random random = new Random();

        /* {"Троянда", "Тюльпан", "Соняшник"};
        {"Дуб", "Сосна", "Береза"};
        {"Малина", "Смородина", "Калина"};
        {"червоний", "жовтий", "зелений", "білий", "рожевий"};
        {"солодкий", "свіжий", "пряний"};
        {"гладка", "шорстка", "лущена"};
        */

        String[] flowerSpecies = new String[3];
        String[] treeSpecies   = new String[3];
        String[] bushSpecies   = new String[3];
        String[] colors        = new String[5];
        String[] aromas        = new String[3];
        String[] barkTypes     = new String[3];

        for (int i = 0; i < 20; i++) {
            if (i < 3) {
                System.out.print("Введіть різновид квітів №" + (i + 1) + ": ");
                flowerSpecies[i] = sc.next();
            } else if (i < 6) {
                System.out.print("Введіть вид дерева №" + (i - 2) + ": ");
                treeSpecies[i - 3] = sc.next();
            } else if (i < 9) {
                System.out.print("Введіть різновид куща №" + (i - 5) + ": ");
                bushSpecies[i - 6] = sc.next();
            } else if (i < 14) {
                System.out.print("Введіть колір №" + (i - 8) + ": ");
                colors[i - 9] = sc.next();
            } else if (i < 17) {
                System.out.print("Введіть аромат №" + (i - 13) + ": ");
                aromas[i - 14] = sc.next();
            } else {
                System.out.print("Введіть тип кори №" + (i - 16) + ": ");
                barkTypes[i - 17] = sc.next();
            }
        }

        sc.close();

        for (int i = 0; i < garden.length; i++) {
            int type = random.nextInt(3);

            switch (type) {
                case 0:
                    garden[i] = new Flower(
                            flowerSpecies[random.nextInt(flowerSpecies.length)],
                            random.nextDouble() * 20 + 10,
                            random.nextInt(3),
                            colors[random.nextInt(colors.length)],
                            random.nextInt(10) + 5,
                            aromas[random.nextInt(aromas.length)]
                    );
                    break;
                case 1:
                    garden[i] = new Tree(
                            treeSpecies[random.nextInt(treeSpecies.length)],
                            random.nextDouble() * 100 + 50,
                            random.nextInt(10) + 1,
                            colors[random.nextInt(colors.length)],
                            random.nextDouble() * 30 + 10,
                            barkTypes[random.nextInt(barkTypes.length)]
                    );
                    break;
                case 2:
                    garden[i] = new Bush(
                            bushSpecies[random.nextInt(bushSpecies.length)],
                            random.nextDouble() * 50 + 20,
                            random.nextInt(5),
                            colors[random.nextInt(colors.length)],
                            random.nextInt(20) + 5,
                            random.nextDouble() * 40 + 20
                    );
                    break;
            }
        }

        System.out.println("Початковий стан саду");
        for (int i = 0; i < garden.length; i++) {
            System.out.println((i + 1) + ". " + garden[i]);
        }

        System.out.println("\nПроцес росту (поліморфізм)");
        for (int i = 0; i < garden.length; i++) {
            System.out.println("\nРослина №" + (i + 1));
            garden[i].grow();
        }

        System.out.println("\n\nСтан саду після росту");
        for (int i = 0; i < garden.length; i++) {
            System.out.println((i + 1) + ". " + garden[i]);
        }

        System.out.println("\nСтатистика саду");
        int flowerCount = 0, treeCount = 0, bushCount = 0;
        double totalHeight = 0;

        for (Plant plant : garden) {
            totalHeight += plant.getHeight();
            if (plant instanceof Flower) flowerCount++;
            else if (plant instanceof Tree) treeCount++;
            else if (plant instanceof Bush) bushCount++;
        }

        System.out.println("Квітів: " + flowerCount);
        System.out.println("Дерев: " + treeCount);
        System.out.println("Кущів: " + bushCount);
        System.out.println("Середня висота рослин: " + String.format("%.2f", totalHeight / garden.length) + " см");

        // 2.1
        // Створення об'єктів з різними конструкторами
        Phone phone1 = new Phone();
        Phone phone2 = new Phone("+380501234567", "iPhone 17");
        Phone phone3 = new Phone("+380679876543", "Samsung Galaxy S25", 168.0);

        System.out.println("Інформація про телефони");
        phone1.displayInfo();
        phone2.displayInfo();
        phone3.displayInfo();

        System.out.println("\nВиклик методу receiveCall (один параметр)");
        phone2.receiveCall("Олександр");
        phone3.receiveCall("Марія");

        System.out.println("\nВиклик методу receiveCall (два параметри)");
        phone2.receiveCall("Іван", "+380631112233");
        phone3.receiveCall("Катерина", "+380955556677");

        System.out.println("\nВиклик методу getNumber");
        System.out.println("Номер телефону 2: " + phone2.getNumber());
        System.out.println("Номер телефону 3: " + phone3.getNumber());

        System.out.println("\nВідправка повідомлень");
        phone2.sendMessage("+380671234567", "+380502345678", "+380933456789");

        System.out.println();
        phone3.sendMessage("+380635556677", "+380997778899");
    }
}