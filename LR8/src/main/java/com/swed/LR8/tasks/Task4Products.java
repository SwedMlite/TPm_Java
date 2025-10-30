
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

public class Task4Products {
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public void process(String inputPath, String outputPath, LocalDate referenceDate) throws IOException {
        int damaged = 0;
        int expired = 0;
        int valid = 0;

        try (BufferedReader br = Files.newBufferedReader(Path.of(inputPath), StandardCharsets.UTF_8)) {
            String name = null;
            Double price = null;
            LocalDate exp = null;

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
                    case "назва":
                        name = value.isEmpty() ? null : value;
                        break;
                    case "вартість":
                        try {
                            price = Double.parseDouble(value.replace(",", "."));
                        } catch (Exception e) {
                            price = null;
                        }
                        break;
                    case "термін":
                        try {
                            exp = LocalDate.parse(value, FMT);
                        } catch (DateTimeParseException e) {
                            exp = null;
                        }
                        break;
                }

                if (name != null && price != null && exp != null) {
                    boolean ok = true;
                    if (name == null || price == null || exp == null) {
                        damaged++;
                        ok = false;
                    }
                    if (price != null && price <= 0) {
                        damaged++;
                        ok = false;
                    }
                    if (exp != null && (exp.isBefore(referenceDate) || exp.isEqual(referenceDate))) {
                        expired++;
                        ok = false;
                    }
                    if (ok) valid++;
                    name = null; price = null; exp = null;
                }
            }
        }

        try (BufferedWriter bw = Files.newBufferedWriter(Path.of(outputPath), StandardCharsets.UTF_8)) {
            bw.write("Пошкоджених записів: " + damaged);
            bw.newLine();
            bw.write("Прострочених продуктів: " + expired);
            bw.newLine();
            bw.write("Придатних продуктів: " + valid);
            bw.newLine();
            bw.write("Опорна дата: " + referenceDate.format(FMT));
            bw.newLine();
        }
    }
}
