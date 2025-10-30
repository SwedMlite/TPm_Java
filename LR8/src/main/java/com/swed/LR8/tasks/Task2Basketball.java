
package com.swed.LR8.tasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Task2Basketball {
    public void process(String inputPath, String outputPath) throws IOException {
        Map<String, Integer> scores = new HashMap<>();
        int badLines = 0;

        try (BufferedReader br = Files.newBufferedReader(Path.of(inputPath), StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                try {
                    String[] parts = line.split(":");
                    if (parts.length != 4) throw new IllegalArgumentException("Очікувалося 4 частини");
                    String a = parts[0].trim();
                    String b = parts[1].trim();
                    String sa = parts[2].trim();
                    String sb = parts[3].trim();
                    if (a.isEmpty() || b.isEmpty() || sa.isEmpty() || sb.isEmpty())
                        throw new IllegalArgumentException("Порожні поля");
                    if (a.equals(b)) throw new IllegalArgumentException("Команда не може грати сама із собою");
                    int pa = Integer.parseInt(sa);
                    int pb = Integer.parseInt(sb);
                    if (pa < 0 || pb < 0) throw new IllegalArgumentException("Негативний рахунок");

                    scores.put(a, scores.getOrDefault(a, 0) + pa);
                    scores.put(b, scores.getOrDefault(b, 0) + pb);
                } catch (Exception e) {
                    badLines++;
                }
            }
        }

        try (BufferedWriter bw = Files.newBufferedWriter(Path.of(outputPath), StandardCharsets.UTF_8)) {
            bw.write("Сумарні бали по командах:");
            bw.newLine();
            for (var e : scores.entrySet()) {
                bw.write(e.getKey() + ": " + e.getValue());
                bw.newLine();
            }
            bw.write("Пошкоджених/некоректних рядків: " + badLines);
            bw.newLine();
        }
    }
}
