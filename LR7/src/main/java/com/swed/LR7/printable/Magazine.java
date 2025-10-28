package com.swed.LR7.printable;

public class Magazine implements Printable {
    private String name;
    private int issueNumber;

    public Magazine(String name, int issueNumber) {
        this.name = name;
        this.issueNumber = issueNumber;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getIssueNumber() { return issueNumber; }
    public void setIssueNumber(int issueNumber) { this.issueNumber = issueNumber; }

    @Override
    public void print() {
        System.out.println("Журнал: " + name + ", випуск №" + issueNumber);
    }

    public static void printMagazines(Printable[] printable) {
        for (Printable p : printable) {
            if (p instanceof Magazine m) {
                System.out.println("Журнал: " + m.getName());
            }
        }
    }
}
