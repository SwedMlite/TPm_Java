package com.swed.LR4;

public class BankCard {
    private String type;
    private String number;
    private String expirationDate;
    private String cvv2;
    private String pin;
    private double balance;

    private static int cardCounter = 0;

    public BankCard() {
        this("Visa", "0000000000000000", "01/25", "000", "0000", 0.0);
    }

    public BankCard(String type, String number, String expirationDate, 
                    String cvv2, String pin, double balance) {
        setType(type);
        setNumber(number);
        setExpirationDate(expirationDate);
        setCvv2(cvv2);
        setPin(pin);
        setBalance(balance);
        cardCounter++;
    }

    public String getType() {
        return type;
    }
    
    public String getNumber() {
        return number;
    }
    
    public String getExpirationDate() {
        return expirationDate;
    }
    
    public String getCvv2() {
        return cvv2;
    }
    
    public String getPin() {
        return pin;
    }
    
    public double getBalance() {
        return balance;
    }

    public void setType(String type) {
        if (type.equals("Visa") || type.equals("Mastercard")) {
            this.type = type;
        } else {
            System.out.println("Невірний тип картки! Встановлено Visa.");
            this.type = "Visa";
        }
    }
    
    public void setNumber(String number) {
        if (number != null && number.length() == 16 && number.matches("\\d+")) {
            this.number = number;
        } else {
            System.out.println("Невірний номер картки! Має бути 16 цифр.");
            this.number = "0000000000000000";
        }
    }
    
    public void setExpirationDate(String expirationDate) {
        if (expirationDate != null && expirationDate.matches("\\d{2}/\\d{2}")) {
            this.expirationDate = expirationDate;
        } else {
            System.out.println("Невірний формат дати! Має бути MM/YY.");
            this.expirationDate = "01/25";
        }
    }
    
    public void setCvv2(String cvv2) {
        if (cvv2 != null && cvv2.length() == 3 && cvv2.matches("\\d+")) {
            this.cvv2 = cvv2;
        } else {
            System.out.println("Невірний CVV2! Має бути 3 цифри.");
            this.cvv2 = "000";
        }
    }
    
    public void setPin(String pin) {
        if (pin != null && pin.length() == 4 && pin.matches("\\d+")) {
            this.pin = pin;
        } else {
            System.out.println("Невірний PIN! Має бути 4 цифри.");
            this.pin = "0000";
        }
    }
    
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Баланс не може бути від'ємним!");
            this.balance = 0.0;
        }
    }

    public static int getCardCounter() {
        return cardCounter;
    }

    private String formatCardNumber() {
        if (number.length() == 16) {
            return number.substring(0, 4) + " " + 
                   number.substring(4, 8) + " " + 
                   number.substring(8, 12) + " " + 
                   number.substring(12, 16);
        }
        return number;
    }

    public boolean makePayment(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void addFunds(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    
    @Override
    public String toString() {
        return String.format("Номер картки: %s\nПридатна до: %s\nТип картки: %s\nБаланс: %.2f грн",
                formatCardNumber(), expirationDate, type, balance);
    }
}