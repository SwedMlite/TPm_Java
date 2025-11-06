package com.swed.LR8.tasks;

import com.swed.LR8.tasks.exceptions.MatchParseException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

public class Task2Basketball {

    private final MatchParser parser = new MatchParser();

    public void process(String inputPath, String outputPath) throws IOException {
        Map<String, Integer> scores = new LinkedHashMap<>();
        int badLines = 0;

        try (BufferedReader br = Files.newBufferedReader(Path.of(inputPath), StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                try {
                    Match m = parser.parse(line);
                    scores.put(m.a, scores.getOrDefault(m.a, 0) + m.pa);
                    scores.put(m.b, scores.getOrDefault(m.b, 0) + m.pb);
                } catch (MatchParseException ex) {
                    badLines++;
                }
            }
        }

        try (BufferedWriter bw = Files.newBufferedWriter(Path.of(outputPath), StandardCharsets.UTF_8)) {
            bw.write("Сумарні бали по командах:");
            bw.newLine();
            scores.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(e -> {
                        try {
                            bw.write(e.getKey() + ": " + e.getValue());
                            bw.newLine();
                        } catch (IOException ioException) {
                            throw new RuntimeException(ioException);
                        }
                    });
            bw.write("Пошкоджених/некоректних рядків: " + badLines);
            bw.newLine();
        }
    }
}
