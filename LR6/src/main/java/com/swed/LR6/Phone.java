package com.swed.LR6;

class Phone {
    private String number;
    private String model;
    private double weight;

    public Phone() {
        this.number = "Не вказано";
        this.model = "Не вказано";
        this.weight = 0.0;
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
        this.weight = 0.0;
    }

    public Phone(String number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public void receiveCall(String name) {
        System.out.println("Телефонує " + name);
    }

    public void receiveCall(String name, String callerNumber) {
        System.out.println("Телефонує " + name + " з номера " + callerNumber);
    }

    public String getNumber() {
        return this.number;
    }

    public void sendMessage(String... numbers) {
        System.out.println("Повідомлення буде надіслано на номери:");
        for (String num : numbers) {
            System.out.println(num);
        }
    }

    public String getModel() {
        return this.model;
    }

    public double getWeight() {
        return this.weight;
    }

    public void displayInfo() {
        System.out.println("Модель: " + model + ", Номер: " + number + ", Вага: " + weight + " г");
    }
}