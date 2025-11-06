package com.swed.LR9;

import java.lang.reflect.Array;
import java.util.Objects;

/**
 * Узагальнений клас для роботи з матрицями посилальних типів.
 * Варіант 5: транспонування матриці.
 * @param <T> тип елементів матриці (тільки посилальні типи)
 */
public class GenericMatrix<T> {

    /**
     * Транспонує матрицю M розмірності m x n (m — рядки, n — стовпці)
     * Повертає нову матрицю n x m.
     */
    @SuppressWarnings("unchecked")
    public T[][] transpositionMatrix(T[][] M, int m, int n) {
        Objects.requireNonNull(M, "Матриця не може бути null");
        if (m <= 0 || n <= 0) {
            throw new IllegalArgumentException("Розмірності m і n повинні бути додатними");
        }
        if (M.length != m) {
            throw new IllegalArgumentException("Очікувана кількість рядків m=" + m + ", але M.length=" + M.length);
        }
        for (int i = 0; i < m; i++) {
            if (M[i] == null || M[i].length != n) {
                throw new IllegalArgumentException("Рядок " + i + " має довжину, відмінну від n=" + n);
            }
        }

        Class<?> componentType = M.getClass().getComponentType().getComponentType(); // T.class
        T[][] result = (T[][]) Array.newInstance(componentType, n, m);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = M[i][j];
            }
        }
        return result;
    }

    /**
     * Друкує матрицю узагальненого типу у зручному для читання вигляді.
     */
    public static <E> void print(E[][] M) {
        if (M == null) {
            System.out.println("null");
            return;
        }
        for (E[] row : M) {
            if (row == null) {
                System.out.println("null");
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int j = 0; j < row.length; j++) {
                sb.append(row[j]);
                if (j + 1 < row.length) sb.append(", ");
            }
            sb.append("]");
            System.out.println(sb);
        }
    }
}
