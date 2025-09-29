package com.swed.LR4;

import java.util.Arrays;

public class BankClient {
    private String fullName;
    private String birthDate;
    private BankCard[] cards;
    private int currentCardCount;

    public BankClient() {
        this("Іваненко Іван Іванович", "01/01/2000", 3);
    }

    public BankClient(String fullName, String birthDate, int maxCards) {
        setFullName(fullName);
        setBirthDate(birthDate);
        if (maxCards > 0) {
            this.cards = new BankCard[maxCards];
        } else {
            this.cards = new BankCard[1];
        }
        this.currentCardCount = 0;
    }

    public BankClient(BankClient other) {
        this.fullName = other.fullName;
        this.birthDate = other.birthDate;
        this.cards = new BankCard[other.cards.length];
        this.currentCardCount = other.currentCardCount;

        for (int i = 0; i < currentCardCount; i++) {
            if (other.cards[i] != null) {
                this.cards[i] = new BankCard(
                    other.cards[i].getType(),
                    other.cards[i].getNumber(),
                    other.cards[i].getExpirationDate(),
                    other.cards[i].getCvv2(),
                    other.cards[i].getPin(),
                    other.cards[i].getBalance()
                );
            }
        }
    }

    public String getFullName() {
        return fullName;
    }
    
    public String getBirthDate() {
        return birthDate;
    }
    
    public BankCard[] getCards() {
        return Arrays.copyOf(cards, currentCardCount);
    }
    
    public int getCurrentCardCount() {
        return currentCardCount;
    }

    public void setFullName(String fullName) {
        if (fullName != null && !fullName.trim().isEmpty()) {
            this.fullName = fullName;
        } else {
            System.out.println("Невірне ім'я! Встановлено значення за замовчуванням.");
            this.fullName = "Іваненко Іван Іванович";
        }
    }
    
    public void setBirthDate(String birthDate) {
        if (birthDate != null && birthDate.matches("\\d{2}/\\d{2}/\\d{4}")) {
            this.birthDate = birthDate;
        } else {
            System.out.println("Невірний формат дати! Має бути DD/MM/YYYY.");
            this.birthDate = "01/01/2000";
        }
    }
    
    public void setCards(BankCard[] cards) {
        if (cards != null) {
            this.cards = Arrays.copyOf(cards, cards.length);
            this.currentCardCount = 0;
            for (BankCard card : cards) {
                if (card != null) {
                    currentCardCount++;
                }
            }
        }
    }

    public boolean addCard(BankCard card) {
        if (card == null) {
            System.out.println("Неможливо додати null-картку!");
            return false;
        }
        
        if (currentCardCount >= cards.length) {
            System.out.println("Досягнуто максимальну кількість карток!");
            return false;
        }
        
        cards[currentCardCount] = card;
        currentCardCount++;
        System.out.println("Картку успішно додано!");
        return true;
    }

    public boolean makePurchaseInStore(double amount, String pin) {
        if (amount <= 0) {
            System.out.println("Сума покупки має бути додатною!");
            return false;
        }
        
        System.out.println("\nСпроба здійснити покупку в магазині на суму: " + amount + " грн");

        for (int i = 0; i < currentCardCount; i++) {
            BankCard card = cards[i];
            if (card != null && card.getPin().equals(pin) && card.getBalance() >= amount) {
                if (card.makePayment(amount)) {
                    System.out.println("Покупку успішно здійснено!");
                    System.out.println("Використано картку: " + card.getType() + 
                                     " ****" + card.getNumber().substring(12));
                    System.out.println("Залишок на картці: " + card.getBalance() + " грн");
                    return true;
                }
            }
        }
        
        System.out.println("Не знайдено картки з достатнім балансом або невірний PIN-код!");
        return false;
    }

    public boolean makePurchaseOnline(double amount, String cvv2) {
        if (amount <= 0) {
            System.out.println("Сума покупки має бути додатною!");
            return false;
        }
        
        System.out.println("\nСпроба здійснити онлайн-покупку на суму: " + amount + " грн");

        for (int i = 0; i < currentCardCount; i++) {
            BankCard card = cards[i];
            if (card != null && card.getCvv2().equals(cvv2) && card.getBalance() >= amount) {
                if (card.makePayment(amount)) {
                    System.out.println("Онлайн-покупку успішно здійснено!");
                    System.out.println("Використано картку: " + card.getType() + 
                                     " ****" + card.getNumber().substring(12));
                    System.out.println("Залишок на картці: " + card.getBalance() + " грн");
                    return true;
                }
            }
        }
        
        System.out.println("Не знайдено картки з достатнім балансом або невірний CVV2-код!");
        return false;
    }

    public BankCard getCard(int index) {
        if (index >= 0 && index < currentCardCount) {
            return cards[index];
        }
        return null;
    }

    public boolean addFundsToCard(int cardIndex, double amount) {
        if (cardIndex >= 0 && cardIndex < currentCardCount && cards[cardIndex] != null) {
            cards[cardIndex].addFunds(amount);
            System.out.println("Баланс картки поповнено на " + amount + " грн");
            return true;
        }
        System.out.println("Картку не знайдено!");
        return false;
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Клієнт: ").append(fullName).append("\n");
        result.append("Дата народження: ").append(birthDate).append("\n");
        result.append("Картки:");
        
        if (currentCardCount == 0) {
            result.append(" немає карток");
        } else {
            for (int i = 0; i < currentCardCount; i++) {
                result.append("\nКартка ").append(i + 1).append("\n");
                result.append(cards[i].toString());
            }
        }
        
        return result.toString();
    }
}