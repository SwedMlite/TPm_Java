package com.swed.LR4;

public class BankTest {
    public static void test() {
        System.out.println("1. Тестування конструктора без параметрів:");
        BankCard card1 = new BankCard();
        System.out.println(card1);
        System.out.println("Кількість створених карток: " + BankCard.getCardCounter());
        System.out.println();

        System.out.println("2. Тестування конструктора з параметрами:");
        BankCard card2 = new BankCard("Visa", "1234567890123456", "12/26", "123", "1234", 5000.00);
        System.out.println(card2);
        System.out.println("Кількість створених карток: " + BankCard.getCardCounter());
        System.out.println();

        System.out.println("3. Тестування валідації даних:");
        BankCard card3 = new BankCard();
        card3.setType("Invalid"); // Спроба встановити невірний тип
        card3.setNumber("123"); // Спроба встановити невірний номер
        card3.setCvv2("12345"); // Спроба встановити невірний CVV2
        card3.setPin("abc"); // Спроба встановити невірний PIN
        card3.setBalance(-100); // Спроба встановити від'ємний баланс
        System.out.println(card3);
        System.out.println();

        System.out.println("4. Тестування Mastercard:");
        BankCard card4 = new BankCard("Mastercard", "9876543210987654", "06/27", "456", "5678", 10000.00);
        System.out.println(card4);
        System.out.println("Кількість створених карток: " + BankCard.getCardCounter());
        System.out.println();

        System.out.println("5. Тестування створення клієнта:");
        BankClient client1 = new BankClient("Петренко Петро Петрович", "15/03/1985", 5);
        System.out.println(client1);
        System.out.println();

        System.out.println("6. Тестування додавання карток:");
        client1.addCard(card2); // Додаємо картку з балансом 5000
        client1.addCard(card4); // Додаємо картку з балансом 10000
        
        BankCard card5 = new BankCard("Visa", "1111222233334444", "03/28", "789", "9999", 2500.00);
        client1.addCard(card5);
        System.out.println(client1);
        System.out.println();

        System.out.println("7. Тестування покупки в магазині:");
        System.out.println("Спроба покупки на 3000 грн з невірним PIN:");
        client1.makePurchaseInStore(3000, "0000");
        
        System.out.println("\nСпроба покупки на 3000 грн з правильним PIN:");
        client1.makePurchaseInStore(3000, "1234");
        System.out.println();

        System.out.println("8. Тестування онлайн покупки:");
        System.out.println("Спроба покупки на 7000 грн з невірним CVV2:");
        client1.makePurchaseOnline(7000, "000");
        
        System.out.println("\nСпроба покупки на 7000 грн з правильним CVV2:");
        client1.makePurchaseOnline(7000, "456");
        System.out.println();

        System.out.println("9. Тестування конструктора копіювання:");
        BankClient client2 = new BankClient(client1);
        System.out.println("Оригінальний клієнт:");
        System.out.println(client1);
        System.out.println("\nКопія клієнта:");
        System.out.println(client2);
        System.out.println();

        System.out.println("10. Тестування поповнення балансу:");
        client1.addFundsToCard(0, 5000);
        System.out.println("Після поповнення першої картки на 5000 грн:");
        System.out.println(client1.getCard(0));
        System.out.println();

        System.out.println("11. Тестування покупки на суму більшу за баланс:");
        client1.makePurchaseInStore(20000, "1234");
        System.out.println();

        System.out.println("12. Тестування клієнта без карток:");
        BankClient client3 = new BankClient();
        System.out.println(client3);
        client3.makePurchaseInStore(100, "0000");
        System.out.println();

        System.out.println("13. Тестування обмеження на кількість карток:");
        BankClient client4 = new BankClient("Іванов Іван Іванович", "01/01/1990", 2);
        client4.addCard(new BankCard());
        client4.addCard(new BankCard());
        client4.addCard(new BankCard()); // Третя картка не повинна додатися
        System.out.println("Кількість карток у клієнта: " + client4.getCurrentCardCount());
        System.out.println();

        System.out.println("Всього створено банківських карток: " + BankCard.getCardCounter());
    }
}