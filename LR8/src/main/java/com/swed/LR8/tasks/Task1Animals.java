
package com.swed.LR8.tasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Task1Animals {
    private static final Map<String, Integer> EXPECTED_LEGS = Map.of(
            "Кінь", 4,
            "Змія", 0,
            "Страус", 2
    );

    public void process(String inputPath, String outputPath) throws IOException {
        int damaged = 0;
        int wrongAge = 0;
        int wrongLegs = 0;
        long totalLegsInValid = 0;

        try (BufferedReader br = Files.newBufferedReader(Path.of(inputPath), StandardCharsets.UTF_8)) {
            String name = null;
            Integer age = null;
            Integer legs = null;

            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\s+", 2);
                if (parts.length < 2) { // поламаний рядок
                    damaged++;
                    continue;
                }
                String key = parts[0];
                String value = parts[1].trim();

                switch (key) {
                    case "назва":
                        name = value.isEmpty() ? null : value;
                        break;
                    case "вік":
                        try {
                            age = Integer.parseInt(value);
                        } catch (Exception e) {
                            age = null;
                        }
                        break;
                    case "ніг":
                        try {
                            legs = Integer.parseInt(value);
                        } catch (Exception e) {
                            legs = null;
                        }
                        break;
                    default:
                        // невідомий ключ — ігноруємо, але це нетипово
                        break;
                }

                // коли накопичили трійку полів — перевіряємо
                if (name != null && age != null && legs != null) {
                    boolean valid = true;
                    if (!EXPECTED_LEGS.containsKey(name)) {
                        damaged++;
                        valid = false;
                    }
                    if (age == null || age <= 0) {
                        wrongAge++;
                        valid = false;
                    }
                    if (name != null && legs != null && EXPECTED_LEGS.containsKey(name)) {
                        int exp = EXPECTED_LEGS.get(name);
                        if (legs != exp) {
                            wrongLegs++;
                            valid = false;
                        }
                    } else {
                        damaged++;
                        valid = false;
                    }

                    if (valid) {
                        totalLegsInValid += legs;
                    }
                    // скидаємо для наступного запису
                    name = null;
                    age = null;
                    legs = null;
                }
            }
        }

        try (BufferedWriter bw = Files.newBufferedWriter(Path.of(outputPath), StandardCharsets.UTF_8)) {
            bw.write("Пошкоджених записів: " + damaged);
            bw.newLine();
            bw.write("Записів з невірним віком: " + wrongAge);
            bw.newLine();
            bw.write("Записів з невірною кількістю ніг: " + wrongLegs);
            bw.newLine();
            bw.write("Сумарна кількість ніг у правильних записах: " + totalLegsInValid);
            bw.newLine();
        }
    }
}
