package com.swed.LR4;

public class OctagonTest {
    public static void test() {
        System.out.println("1. Тестування конструктора без параметрів:");
        Octagon octagon1 = new Octagon();
        System.out.println("Створено: " + octagon1);
        System.out.println("Кількість створених об'єктів: " + Octagon.getCounter());
        System.out.println();

        System.out.println("2. Тестування конструктора з параметрами:");
        Octagon octagon2 = new Octagon(5.0, 10.0, 3.0);
        System.out.println("Створено: " + octagon2);
        System.out.println("Кількість створених об'єктів: " + Octagon.getCounter());
        System.out.println();

        System.out.println("3. Тестування конструктора копіювання:");
        Octagon octagon3 = new Octagon(octagon2);
        System.out.println("Оригінал: " + octagon2);
        System.out.println("Копія: " + octagon3);
        System.out.println("Кількість створених об'єктів: " + Octagon.getCounter());
        System.out.println();

        System.out.println("4. Тестування get-методів:");
        System.out.println("Центр X: " + octagon2.getCenterX());
        System.out.println("Центр Y: " + octagon2.getCenterY());
        System.out.println("Довжина сторони: " + octagon2.getSideLength());
        System.out.println();

        System.out.println("5. Тестування set-методів:");
        System.out.println("До зміни: " + octagon1);
        octagon1.setCenterX(2.5);
        octagon1.setCenterY(3.5);
        octagon1.setSideLength(2.0);
        System.out.println("Після зміни: " + octagon1);
        System.out.println();

        System.out.println("6. Тестування методу обчислення площі:");
        System.out.printf("Площа восьмикутника зі стороною %.2f = %.4f\n",
                octagon1.getSideLength(), octagon1.getArea());
        System.out.printf("Площа восьмикутника зі стороною %.2f = %.4f\n",
                octagon2.getSideLength(), octagon2.getArea());
        System.out.println();

        System.out.println("7. Тестування методу обчислення периметру:");
        System.out.printf("Периметр восьмикутника зі стороною %.2f = %.2f\n",
                octagon1.getSideLength(), octagon1.getPerimeter());
        System.out.printf("Периметр восьмикутника зі стороною %.2f = %.2f\n",
                octagon2.getSideLength(), octagon2.getPerimeter());
        System.out.println();

        System.out.println("8. Тестування методу переміщення (move):");
        System.out.println("До переміщення: " + octagon1);
        octagon1.move(5.0, -2.0);
        System.out.println("Після переміщення на (5, -2): " + octagon1);
        System.out.println();

        System.out.println("9. Тестування методу переміщення в точку (moveTo):");
        System.out.println("До переміщення: " + octagon2);
        octagon2.moveTo(0.0, 0.0);
        System.out.println("Після переміщення в (0, 0): " + octagon2);
        System.out.println();

        System.out.println("10. Тестування статичного методу toString:");
        System.out.println(Octagon.toString(octagon3));
        System.out.println();

        System.out.println("11. Тестування встановлення некоректної довжини сторони:");
        Octagon octagon4 = new Octagon();
        octagon4.setSideLength(-5.0);  // спроба встановити від'ємну довжину
        System.out.println("Результат: " + octagon4);
        System.out.println();

        System.out.println("12. Тестування створення декількох восьмикутників:");
        Octagon[] octagons = new Octagon[3];
        for (int i = 0; i < octagons.length; i++) {
            octagons[i] = new Octagon(i * 2, i * 3, i + 1);
            System.out.println("Восьмикутник " + (i + 1) + ": " + octagons[i]);
        }
        System.out.println();

        System.out.println("Всього створено об'єктів класу Octagon: " + Octagon.getCounter());

        Octagon small = new Octagon(0, 0, 1);
        Octagon medium = new Octagon(0, 0, 5);
        Octagon large = new Octagon(0, 0, 10);

        System.out.println("Малий: " + small);
        System.out.println("Середній: " + medium);
        System.out.println("Великий: " + large);

        System.out.println("\nФінальна кількість створених об'єктів: " + Octagon.getCounter());
    }
}