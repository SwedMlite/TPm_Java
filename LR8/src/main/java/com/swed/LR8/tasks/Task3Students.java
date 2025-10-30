
package com.swed.LR8.tasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Task3Students {
    private static final LocalDate LIMIT = LocalDate.of(2007, 1, 1);
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public void process(String inputPath, String outputPath) throws IOException {
        int damaged = 0;
        int wrongDate = 0;
        int ok = 0;

        try (BufferedReader br = Files.newBufferedReader(Path.of(inputPath), StandardCharsets.UTF_8)) {
            String name = null;
            String surname = null;
            LocalDate dob = null;

            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\s+", 2);
                if (parts.length < 2) {
                    damaged++;
                    continue;
                }
                String key = parts[0];
                String value = parts[1].trim();

                switch (key) {
                    case "ім'я":
                        name = value.isEmpty() ? null : value;
                        break;
                    case "прізвище":
                        surname = value.isEmpty() ? null : value;
                        break;
                    case "дата":
                        try {
                            dob = LocalDate.parse(value, FMT);
                        } catch (DateTimeParseException ex) {
                            dob = null;
                        }
                        break;
                }

                if (name != null && surname != null && dob != null) {
                    boolean valid = true;
                    if (name == null || surname == null) {
                        damaged++;
                        valid = false;
                    }
                    if (dob == null || !dob.isBefore(LIMIT)) {
                        wrongDate++;
                        valid = false;
                    }
                    if (valid) ok++;
                    name = null; surname = null; dob = null;
                }
            }
        }

        try (BufferedWriter bw = Files.newBufferedWriter(Path.of(outputPath), StandardCharsets.UTF_8)) {
            bw.write("Пошкоджених записів: " + damaged);
            bw.newLine();
            bw.write("Помилкова дата народження: " + wrongDate);
            bw.newLine();
            bw.write("Правильних записів: " + ok);
            bw.newLine();
        }
    }
}
