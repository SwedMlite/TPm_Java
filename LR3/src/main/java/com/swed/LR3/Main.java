package com.swed.LR3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1.1
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть кількість елементів масиву: ");
        int n = sc.nextInt();

        double[] arr = new double[n];
        Random rand = new Random();

        // Заповнення масиву та обробка в одному циклі
        double sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = -50 + rand.nextDouble() * 70; // від -50 до 20
            if (arr[i] > 0) {
                arr[i] = 0; // заміна додатніх
            }
            sum += arr[i];
        }

        System.out.println("Масив після заміни:");
        System.out.println(Arrays.toString(arr));
        System.out.println("Сума всіх елементів = " + sum);

        // 1.2
        double x = 3.0;
        while (x <= 4.0 + 1e-9) {
            double y = 1 / (x * x);
            System.out.printf("x = %.1f, y = %.4f%n", x, y);
            x += 0.1;
        }

        // 2.1
        System.out.print("Введіть кількість точок: ");
        int nextInt = sc.nextInt();

        double[][] points = new double[nextInt][2]; // масив координат

        for (int i = 0; i < nextInt; i++) {
            System.out.print("Введіть x та y для точки " + (i+1) + ": ");
            points[i][0] = sc.nextDouble();
            points[i][1] = sc.nextDouble();
        }

        double maxDist = -1;
        int p1 = 0, p2 = 0;

        // пошук пари точок
        for (int i = 0; i < nextInt; i++) {
            for (int j = i+1; j < nextInt; j++) {
                double dx = points[i][0] - points[j][0];
                double dy = points[i][1] - points[j][1];
                double dist = Math.sqrt(dx*dx + dy*dy);
                if (dist > maxDist) {
                    maxDist = dist;
                    p1 = i;
                    p2 = j;
                }
            }
        }

        System.out.printf("Найбільша відстань = %.3f між точками (%.2f, %.2f) і (%.2f, %.2f)%n",
                maxDist, points[p1][0], points[p1][1], points[p2][0], points[p2][1]);
    }
}