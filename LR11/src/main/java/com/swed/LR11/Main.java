package com.swed.LR11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

// Основне завдання - варіант 5
class DateDifferenceCalculator {
    public static void calculateDifference(String inputDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        try {
            Date givenDate = sdf.parse(inputDate);
            Date currentDate = new Date();

            long diffMillis = Math.abs(currentDate.getTime() - givenDate.getTime());

            long days = diffMillis / (24 * 60 * 60 * 1000);
            long hours = (diffMillis % (24 * 60 * 60 * 1000)) / (60 * 60 * 1000);
            long minutes = (diffMillis % (60 * 60 * 1000)) / (60 * 1000);

            System.out.println("=== РОЗРАХУНОК РІЗНИЦІ МІЖ ДАТАМИ ===");
            System.out.println("Задана дата: " + sdf.format(givenDate));
            System.out.println("Поточна дата: " + sdf.format(currentDate));
            System.out.println("\nРізниця між датами:");
            System.out.println("Днів: " + days);
            System.out.println("Годин: " + hours);
            System.out.println("Хвилин: " + minutes);
            System.out.println("Загалом хвилин: " + (diffMillis / (60 * 1000)));
            System.out.println("=====================================\n");

        } catch (ParseException e) {
            System.out.println("Помилка парсингу дати. Використовуйте формат: dd.MM.yyyy HH:mm");
        }
    }
}

// Додаткове завдання - варіант 5 (таблиця 2.2)
class MixingEquipmentSimulator {
    private static final double TANK_VOLUME = 3.0; // м³
    private static final double MIX_TANK_VOLUME = 1.0; // м³
    private static final double COMPONENT1_RATIO = 0.45;
    private static final double COMPONENT2_RATIO = 0.33;
    private static final double COMPONENT3_RATIO = 0.22;
    private static final long MIX_TIME = 3 * 60 * 1000; // 3 хвилини в мілісекундах

    private double tank1Level = TANK_VOLUME;
    private double tank2Level = TANK_VOLUME;
    private double tank3Level = TANK_VOLUME;

    private List<LogEntry> journal = new ArrayList<>();
    private long totalDowntime = 0;
    private double totalMixture = 0.0;

    static class LogEntry {
        Date timestamp;
        String event;
        String details;

        LogEntry(Date timestamp, String event, String details) {
            this.timestamp = timestamp;
            this.event = event;
            this.details = details;
        }
    }

    private long getRefillTime() {
        Random rand = new Random();
        return 75000 + rand.nextInt(16000); // від 1:15 до 1:30 в мілісекундах
    }

    private void addLog(Date time, String event, String details) {
        journal.add(new LogEntry(time, event, details));
    }

    public void simulateDay() {
        System.out.println("=== ЖУРНАЛ РОБОТИ ОБЛАДНАННЯ ЗА ДОБУ ===\n");

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Date startTime = calendar.getTime();
        Date endTime = new Date(startTime.getTime() + 24 * 60 * 60 * 1000);
        Date currentTime = startTime;

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        int cycleNumber = 0;

        while (currentTime.before(endTime)) {
            cycleNumber++;

            double required1 = MIX_TANK_VOLUME * COMPONENT1_RATIO;
            double required2 = MIX_TANK_VOLUME * COMPONENT2_RATIO;
            double required3 = MIX_TANK_VOLUME * COMPONENT3_RATIO;

            boolean needsRefill = false;
            StringBuilder refillMsg = new StringBuilder();

            if (tank1Level < required1) {
                needsRefill = true;
                long refillTime = getRefillTime();
                addLog(currentTime, "ЗУПИНКА", "Недостатньо компонента 1");
                currentTime = new Date(currentTime.getTime() + refillTime);
                tank1Level = TANK_VOLUME;
                totalDowntime += refillTime;
                refillMsg.append("Компонент 1 поповнено. ");
            }

            if (tank2Level < required2) {
                needsRefill = true;
                long refillTime = getRefillTime();
                if (refillMsg.length() == 0) {
                    addLog(currentTime, "ЗУПИНКА", "Недостатньо компонента 2");
                }
                currentTime = new Date(currentTime.getTime() + refillTime);
                tank2Level = TANK_VOLUME;
                totalDowntime += refillTime;
                refillMsg.append("Компонент 2 поповнено. ");
            }

            if (tank3Level < required3) {
                needsRefill = true;
                long refillTime = getRefillTime();
                if (refillMsg.length() == 0) {
                    addLog(currentTime, "ЗУПИНКА", "Недостатньо компонента 3");
                }
                currentTime = new Date(currentTime.getTime() + refillTime);
                tank3Level = TANK_VOLUME;
                totalDowntime += refillTime;
                refillMsg.append("Компонент 3 поповнено.");
            }

            if (needsRefill) {
                addLog(currentTime, "ПОПОВНЕННЯ", refillMsg.toString());
            }

            tank1Level -= required1;
            tank2Level -= required2;
            tank3Level -= required3;

            addLog(currentTime, "ЗМІШУВАННЯ",
                    String.format("Цикл #%d. Залишки: К1=%.2fм³, К2=%.2fм³, К3=%.2fм³",
                            cycleNumber, tank1Level, tank2Level, tank3Level));

            currentTime = new Date(currentTime.getTime() + MIX_TIME);
            totalMixture += MIX_TANK_VOLUME;

            addLog(currentTime, "ЗАВЕРШЕНО",
                    String.format("Виготовлено %.2f м³ суміші", MIX_TANK_VOLUME));

            if (currentTime.after(endTime)) {
                break;
            }
        }

        printJournal();
        printStatistics(startTime, endTime);
    }

    private void printJournal() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        System.out.println("ХРОНОЛОГІЯ ПОДІЙ:");
        System.out.println("-".repeat(80));

        for (LogEntry entry : journal) {
            System.out.printf("[%s] %-15s | %s%n",
                    timeFormat.format(entry.timestamp),
                    entry.event,
                    entry.details);
        }
        System.out.println("-".repeat(80));
    }

    private void printStatistics(Date start, Date end) {
        System.out.println("\n=== СТАТИСТИКА РОБОТИ ===");
        System.out.println("Період роботи: 24 години");
        System.out.println(String.format("Загальна кількість виробленої суміші: %.2f м³", totalMixture));

        long downtimeMinutes = totalDowntime / (60 * 1000);
        long downtimeSeconds = (totalDowntime % (60 * 1000)) / 1000;

        System.out.println(String.format("Загальний час простою: %d хв %d сек",
                downtimeMinutes, downtimeSeconds));

        double efficiency = ((24.0 * 60 * 60 * 1000 - totalDowntime) /
                (24.0 * 60 * 60 * 1000)) * 100;
        System.out.println(String.format("Ефективність роботи: %.2f%%", efficiency));
        System.out.println("=========================\n");
    }

    public void calculateProductionForPeriod(String startDateStr, String endDateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        try {
            Date startDate = sdf.parse(startDateStr);
            Date endDate = sdf.parse(endDateStr);

            long periodMillis = endDate.getTime() - startDate.getTime();
            long periodHours = periodMillis / (60 * 60 * 1000);

            double cycleTime = (MIX_TIME + 90000) / (60.0 * 1000.0);
            double cyclesPerHour = 60.0 / cycleTime;
            double estimatedProduction = cyclesPerHour * periodHours * MIX_TANK_VOLUME;

            System.out.println("=== РОЗРАХУНОК ВИРОБНИЦТВА ЗА ПЕРІОД ===");
            System.out.println("Період: з " + sdf.format(startDate) + " по " + sdf.format(endDate));
            System.out.println("Тривалість періоду: " + periodHours + " годин");
            System.out.println(String.format("Орієнтовне виробництво: %.2f м³", estimatedProduction));
            System.out.println("==========================================\n");

        } catch (ParseException e) {
            System.out.println("Помилка парсингу дати. Використовуйте формат: dd.MM.yyyy HH:mm");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║  ЛАБОРАТОРНА РОБОТА №11 - РОБОТА З ДАТОЮ ТА ЧАСОМ      ║");
        System.out.println("║              Варіант 5 (основне + додаткове)           ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        while (true) {
            System.out.println("\n=== ГОЛОВНЕ МЕНЮ ===");
            System.out.println("1. Виконати основне завдання (різниця між датами)");
            System.out.println("2. Виконати додаткове завдання (симуляція обладнання)");
            System.out.println("3. Розрахунок виробництва за період");
            System.out.println("0. Вихід");
            System.out.print("\nВаш вибір: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n--- ОСНОВНЕ ЗАВДАННЯ ---");
                    System.out.print("Введіть дату у форматі dd.MM.yyyy HH:mm (наприклад, 15.01.2024 14:30): ");
                    String inputDate = scanner.nextLine();
                    DateDifferenceCalculator.calculateDifference(inputDate);
                    break;

                case 2:
                    System.out.println("\n--- ДОДАТКОВЕ ЗАВДАННЯ ---");
                    System.out.println("Запуск симуляції роботи обладнання на добу...\n");
                    MixingEquipmentSimulator simulator = new MixingEquipmentSimulator();
                    simulator.simulateDay();
                    break;

                case 3:
                    System.out.println("\n--- РОЗРАХУНОК ЗА ПЕРІОД ---");
                    System.out.print("Введіть початкову дату (dd.MM.yyyy HH:mm): ");
                    String start = scanner.nextLine();
                    System.out.print("Введіть кінцеву дату (dd.MM.yyyy HH:mm): ");
                    String end = scanner.nextLine();
                    MixingEquipmentSimulator sim = new MixingEquipmentSimulator();
                    sim.calculateProductionForPeriod(start, end);
                    break;

                case 0:
                    System.out.println("\nДякую за використання програми!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }
}