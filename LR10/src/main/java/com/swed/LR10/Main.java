package com.swed.LR10;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ОСНОВНЕ ЗАВДАННЯ (Варіант 5) ===\n");
        basicTask();

        System.out.println("\n\n=== ДОДАТКОВЕ ЗАВДАННЯ (Таблиця 2.2, Варіант 1) ===\n");
        additionalTask();
    }

    /**
     * Основне завдання - Варіант 5
     * Створити колекцію Vector з початковою ємністю.
     * Заповнити випадковими числами від -150 до 150.
     * Інверсія знаку додатніх елементів, інші замінити на 0.
     */
    public static void basicTask() {
        // Початкова ємність вектора
        int initialCapacity = 10;
        Vector<Integer> vector = new Vector<>(initialCapacity);

        // Генератор випадкових чисел
        Random random = new Random();

        // Заповнюємо вектор так, щоб кінцевий розмір перевищував початкову ємність
        int finalSize = initialCapacity + 5; // 15 елементів
        System.out.println("Початкова ємність вектора: " + initialCapacity);
        System.out.println("Кінцевий розмір вектора: " + finalSize);

        for (int i = 0; i < finalSize; i++) {
            // Генеруємо випадкове число від -150 до 150
            int value = random.nextInt(301) - 150;
            vector.add(value);
        }

        // Виводимо початковий вектор
        System.out.println("\nПочатковий вектор:");
        System.out.println(vector);

        // Обходимо колекцію за допомогою ітератора
        System.out.println("\nОбробка елементів:");
        for (int i = 0; i < vector.size(); i++) {
            int element = vector.get(i);

            if (element > 0) {
                // Інверсія знаку додатніх елементів
                vector.set(i, -element);
                System.out.println("Елемент [" + i + "]: " + element + " -> " + (-element) + " (інверсія знаку)");
            } else {
                // Заміна від'ємних та нульових елементів на 0
                vector.set(i, 0);
                System.out.println("Елемент [" + i + "]: " + element + " -> 0 (заміна на нуль)");
            }
        }

        // Виводимо змінений вектор
        System.out.println("\nЗмінений вектор:");
        System.out.println(vector);

        // Додаткова інформація
        System.out.println("\nПоточна ємність вектора: " + vector.capacity());
        System.out.println("Поточний розмір вектора: " + vector.size());
    }

    /**
     * Додаткове завдання - Таблиця 2.2, Варіант 1
     * Створити множину з чисел, введених користувачем.
     * Видалити дублікати і вивести результат.
     */
    public static void additionalTask() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть числа через кому (наприклад: 1, 2, 3, 4, 4, 5, 7, 7, 7, 10, 11, 11):");
        String input = scanner.nextLine();

        // Створюємо список для збереження початкових даних
        List<Integer> originalList = new ArrayList<>();

        // Розбиваємо рядок і додаємо числа до списку
        String[] numbers = input.split(",");
        System.out.println("\nПочатковий рядок: " + input);
        System.out.println("Початковий список:");

        for (String numStr : numbers) {
            try {
                int num = Integer.parseInt(numStr.trim());
                originalList.add(num);
                System.out.print(num + " ");
            } catch (NumberFormatException e) {
                System.out.println("\nПомилка: '" + numStr.trim() + "' не є числом");
            }
        }

        // Створюємо множину Set (автоматично видаляє дублікати)
        Set<Integer> uniqueSet = new LinkedHashSet<>(originalList);

        System.out.println("\n\nОбробка за допомогою Iterator:");

        // Підрахунок дублікатів
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Integer num : originalList) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Виводимо інформацію про дублікати
        System.out.println("\nЗнайдені дублікати:");
        boolean hasDuplicates = false;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Число " + entry.getKey() + " зустрічається " + entry.getValue() + " разів");
                hasDuplicates = true;
            }
        }

        if (!hasDuplicates) {
            System.out.println("Дублікати не знайдені");
        }

        // Виводимо множину без дублікатів за допомогою ітератора
        System.out.println("\nМножина без дублікатів (через Iterator):");
        Iterator<Integer> iterator = uniqueSet.iterator();
        StringBuilder result = new StringBuilder();

        while (iterator.hasNext()) {
            Integer num = iterator.next();
            result.append(num);
            if (iterator.hasNext()) {
                result.append(", ");
            }
        }

        System.out.println(result.toString());

        // Статистика
        System.out.println("\nСтатистика:");
        System.out.println("Кількість елементів у початковому списку: " + originalList.size());
        System.out.println("Кількість унікальних елементів: " + uniqueSet.size());
        System.out.println("Видалено дублікатів: " + (originalList.size() - uniqueSet.size()));
    }
}