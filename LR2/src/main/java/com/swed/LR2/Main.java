package com.swed.LR2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1.1
        // x^2-y^2 : -16 -4 , x+y : 4 + 7
        System.out.print("Введіть X: ");
        int X = scanner.nextInt();
        System.out.print("Введіть Y: ");
        int Y = scanner.nextInt();

        double result = (Y > 0 && 0 >= X) ? Math.pow(X, 2) - Math.pow(Y, 2) : X + Y;
        System.out.println("Результат: " + result);

        // 1.2
        scanner.nextLine(); // Очищаємо буфер після nextInt()
        System.out.print("Введіть арифметичний вираз: ");
        String expression = scanner.nextLine().trim();

        try {
            int num1, num2;
            String operator = "";
            int operatorIndex = -1;

            // Шукаємо оператор (починаємо з індексу 1, щоб врахувати від'ємні числа)
            for (int i = 1; i < expression.length(); i++) {
                char ch = expression.charAt(i);
                if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                    operator = String.valueOf(ch);
                    operatorIndex = i;
                    break;
                }
            }

            if (operatorIndex == -1) {
                System.out.println("Оператор не знайдено");
                return;
            }

            // Витягуємо числа
            String firstNum = expression.substring(0, operatorIndex).trim();
            String secondNum = expression.substring(operatorIndex + 1).trim();

            num1 = Integer.parseInt(firstNum);
            num2 = Integer.parseInt(secondNum);

            int expressionResult = 0;
            switch (operator) {
                case "+":
                    expressionResult = num1 + num2;
                    break;
                case "-":
                    expressionResult = num1 - num2;
                    break;
                case "*":
                    expressionResult = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("Ділення на нуль неможливе");
                        return;
                    }
                    expressionResult = num1 / num2;
                    break;
            }

            System.out.println("Результат виразу: " + expressionResult);
            System.out.println(expressionResult == 0 ? "ТАК" : "НІ");

        } catch (NumberFormatException e) {
            System.out.println("Помилка в форматі числа");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Неправильний формат виразу");
        }

        // 2.1.
        System.out.println("Введіть дійсні числа (0 для завершення):");

        double number;
        do {
            System.out.print("Введіть число: ");
            number = scanner.nextDouble();
            if (number != 0) {
                double rounded = Math.round(number * 1000.0) / 1000.0;
                System.out.printf("Округлене до 3 знаків: %.3f%n", rounded);
            }
        } while (number != 0);

        // 2.2.
        scanner.nextLine(); // Очищаємо буфер після nextDouble()

        String vowels = "аеиіоуюяєїАЕИІОУЮЯЄЇaeiouAEIOU"; // українські та англійські голосні
        int totalVowels = 0;

        System.out.println("Введіть 10 рядків:");
        for (int i = 1; i <= 10; i++) {
            System.out.print("Рядок " + i + ": ");
            String line = scanner.nextLine();

            int vowelCount = 0;
            for (int j = 0; j < line.length(); j++) {
                char ch = line.charAt(j);
                if (vowels.indexOf(ch) != -1) {
                    vowelCount++;
                }
            }

            System.out.println("Голосних у рядку " + i + ": " + vowelCount);
            totalVowels += vowelCount;
        }

        System.out.println("Загальна кількість голосних літер: " + totalVowels);

        scanner.close();
    }
}