package com.swed.LR4;

public class Octagon {
    private double centerX;
    private double centerY;
    private double sideLength;

    private static int counter = 0;


    public Octagon() {
        this(0, 0, 1);
    }

    public Octagon(double centerX, double centerY, double sideLength) {
        setCenterX(centerX);
        setCenterY(centerY);
        setSideLength(sideLength);
        counter++;
    }

    public Octagon(Octagon other) {
        this(other.centerX, other.centerY, other.sideLength);
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public void setSideLength(double sideLength) {
        if (sideLength > 0) {
            this.sideLength = sideLength;
        } else {
            System.out.println("Довжина сторони має бути додатною!");
            this.sideLength = 1; // значення за замовчуванням
        }
    }

    public double getArea() {
        return 2 * (1 + Math.sqrt(2)) * sideLength * sideLength;
    }

    public double getPerimeter() {
        return 8 * sideLength;
    }

    public void move(double dx, double dy) {
        this.centerX += dx;
        this.centerY += dy;
    }

    public void moveTo(double newX, double newY) {
        this.centerX = newX;
        this.centerY = newY;
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return String.format("Восьмикутник: центр(%.2f, %.2f), сторона=%.2f, площа=%.2f, периметр=%.2f",
                centerX, centerY, sideLength, getArea(), getPerimeter());
    }

    public static String toString(Octagon octagon) {
        return octagon.toString();
    }
}