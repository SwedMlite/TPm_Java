package com.swed.LR5;

public class Main {
    public static void main(String[] args) {
        // 1.1
        Flower rose = new Flower("Троянда", 10.0, 0, "Червоний", 20, "Сильний");
        System.out.println(rose);
        rose.grow();
        rose.grow();
        System.out.println(rose);
        System.out.println();

        Bush raspberry = new Bush("Малина", 30.0, 0, "Зелений", 5, 25.0);
        System.out.println(raspberry);
        raspberry.grow();
        raspberry.grow();
        raspberry.grow();
        System.out.println(raspberry);
        System.out.println();

        Tree oak = new Tree("Дуб", 100.0, 5, "Зелений", 15.0, "Груба");
        System.out.println(oak);
        oak.grow();
        oak.grow();
        System.out.println(oak);
        System.out.println();

        Plant[] garden = {rose, raspberry, oak};
        for (Plant plant : garden) {
            System.out.println("\n" + plant.getClass().getSimpleName() + ":");
            plant.grow();
        }

        // 2.1, 2.2
        Student[] students = new Student[6];

        students[0] = new Bachelor("Іванов", "Іван", "ПЗ-22-1/9", 2, 85.0);
        students[1] = new Bachelor("Петренко", "Петро", "ПЗ-22-1/9", 3, 72.0);
        students[2] = new Master("Сидоренко", "Олена", "ПЗ-22-1/9", 1, 88.0, true, true);
        students[3] = new Master("Коваленко", "Марія", "ПЗ-22-1/9", 2, 65.0, false, true);
        students[4] = new Aspirant("Шевченко", "Андрій", "ПЗ-22-1/9", 1, 92.0, true, true);
        students[5] = new Aspirant("Мельник", "Ольга", "ПЗ-22-1/9", 3, 78.0, false, false);

        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            String type = "";

            if (student instanceof Aspirant) {
                type = "Аспірант";
            } else if (student instanceof Master) {
                type = "Магістр";
            } else if (student instanceof Bachelor) {
                type = "Бакалавр";
            }

            System.out.println(type + ": " + student.toString());
            System.out.printf("Мінімальна стипендія: %.2f грн\n", student.getMinScholarship());
            System.out.printf("Ефективний рейтинг: %.2f\n", student.getRatingScore());
            System.out.printf("Стипендія: %.2f грн\n", student.getScholarship());
        }


        double totalScholarship = 0;
        for (Student student : students) {
            totalScholarship += student.getScholarship();
        }

        System.out.printf("\nЗагальна сума стипендій: %.2f грн\n", totalScholarship);
    }
}