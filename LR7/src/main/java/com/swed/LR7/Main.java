package com.swed.LR7;

import com.swed.LR7.printable.Book;
import com.swed.LR7.printable.Magazine;
import com.swed.LR7.printable.Printable;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{
                new Cat("Мурка", 3, 4.1, "Олександр"),
                new Lion("Сімба", 6, 190.0, "Савана", 8)
        };

        for (Animal a : animals) {
            System.out.println(a);
            a.makeSound();
            a.feed("їжа");
            if (a instanceof Carnivorous c) {
                c.eatMeat("м'ясо");
                System.out.println("Хижак? " + c.isCarnivorous());
            }
            if (a instanceof Growls g) {
                g.growl();
            }
            System.out.println();
        }

        Printable[] items = new Printable[] {
                new Book("Java. Базовий курс", "Іван Петренко"),
                new Magazine("Наука і Техніка", 10),
                new Book("Алгоритми на Java", "Наталія Коваленко"),
                new Magazine("Світ тварин", 5)
        };

        for (Printable p : items) {
            p.print();
        }
        System.out.println("-- Лише журнали --");
        Magazine.printMagazines(items);
        System.out.println("-- Лише книги --");
        Book.printBooks(items);
    }
}
