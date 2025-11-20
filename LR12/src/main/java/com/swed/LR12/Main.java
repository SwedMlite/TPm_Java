package com.swed.LR12;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class Main {

    // Основне завдання (Варіант 5)
    public static void task1() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Завдання 1: Інформація про вміст директорії ===");
        System.out.print("Введіть шлях до директорії: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Помилка: шлях не існує!");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Помилка: вказаний шлях не є директорією!");
            return;
        }

        System.out.println("\nВміст директорії:");
        System.out.println("-".repeat(60));

        File[] files = directory.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("Директорія порожня");
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println(file.getAbsolutePath() + " - це директорія");
            } else if (file.isFile()) {
                System.out.println(file.getAbsolutePath() + " - це файл");
            }
        }

        System.out.println("-".repeat(60));
        System.out.println("Всього елементів: " + files.length);
    }

    // Додаткове завдання (Варіант 5, рівень 1)
    public static void task2() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Завдання 2: Видалення директорій найнижчого рівня ===");
        System.out.print("Введіть шлях до директорії: ");
        String directoryPath = scanner.nextLine();

        Path rootPath = Paths.get(directoryPath);

        if (!Files.exists(rootPath)) {
            System.out.println("Помилка: шлях не існує!");
            return;
        }

        if (!Files.isDirectory(rootPath)) {
            System.out.println("Помилка: вказаний шлях не є директорією!");
            return;
        }

        try {
            // Знаходимо всі директорії з їх рівнями вкладеності
            Map<Integer, List<Path>> directoriesByLevel = new TreeMap<>(Collections.reverseOrder());

            Files.walk(rootPath)
                    .filter(Files::isDirectory)
                    .filter(path -> !path.equals(rootPath))
                    .forEach(path -> {
                        int level = path.getNameCount() - rootPath.getNameCount();
                        directoriesByLevel.computeIfAbsent(level, k -> new ArrayList<>()).add(path);
                    });

            if (directoriesByLevel.isEmpty()) {
                System.out.println("У директорії немає піддиректорій");
                return;
            }

            // Отримуємо максимальний рівень вкладеності
            int maxLevel = directoriesByLevel.keySet().iterator().next();
            List<Path> lowestLevelDirs = directoriesByLevel.get(maxLevel);

            System.out.println("\nЗнайдено директорій найнижчого рівня (" + maxLevel + "): " + lowestLevelDirs.size());

            int movedFiles = 0;
            int deletedDirs = 0;

            for (Path dir : lowestLevelDirs) {
                System.out.println("\nОбробка директорії: " + dir);

                // Переміщуємо файли на рівень вище
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
                    for (Path file : stream) {
                        if (Files.isRegularFile(file)) {
                            Path parentDir = dir.getParent();
                            Path targetPath = parentDir.resolve(file.getFileName());

                            // Якщо файл з таким іменем вже існує, додаємо номер
                            int counter = 1;
                            while (Files.exists(targetPath)) {
                                String fileName = file.getFileName().toString();
                                int dotIndex = fileName.lastIndexOf('.');
                                String name = dotIndex > 0 ? fileName.substring(0, dotIndex) : fileName;
                                String ext = dotIndex > 0 ? fileName.substring(dotIndex) : "";
                                targetPath = parentDir.resolve(name + "_" + counter + ext);
                                counter++;
                            }

                            Files.move(file, targetPath);
                            System.out.println("  Переміщено: " + file.getFileName() + " -> " + targetPath);
                            movedFiles++;
                        }
                    }
                }

                // Видаляємо порожню директорію
                if (isDirectoryEmpty(dir)) {
                    Files.delete(dir);
                    System.out.println("  Видалено директорію: " + dir);
                    deletedDirs++;
                } else {
                    System.out.println("  Директорія не порожня, пропущено: " + dir);
                }
            }

            System.out.println("\n" + "=".repeat(60));
            System.out.println("Результати:");
            System.out.println("  Переміщено файлів: " + movedFiles);
            System.out.println("  Видалено директорій: " + deletedDirs);
            System.out.println("=".repeat(60));

        } catch (IOException e) {
            System.out.println("Помилка при обробці директорії: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Допоміжний метод для перевірки, чи директорія порожня
    private static boolean isDirectoryEmpty(Path directory) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            return !stream.iterator().hasNext();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n" + "=".repeat(60));
            System.out.println("Лабораторна робота №12 - Варіант 5");
            System.out.println("=".repeat(60));
            System.out.println("1. Основне завдання (Інформація про вміст директорії)");
            System.out.println("2. Додаткове завдання (Видалення директорій найнижчого рівня)");
            System.out.println("0. Вихід");
            System.out.println("=".repeat(60));
            System.out.print("Виберіть завдання: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 0:
                    System.out.println("Завершення програми...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Невірний вибір! Спробуйте ще раз.");
            }
        }
    }
}