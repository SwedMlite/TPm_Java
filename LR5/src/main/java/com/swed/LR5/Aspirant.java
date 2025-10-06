package com.swed.LR5;

class Aspirant extends Student {
    private boolean hasScientificWork;
    private boolean hasBudgetPlace;

    public Aspirant(String lastName, String firstName, String group,
                    int yearOfStudy, double ratingScore,
                    boolean hasScientificWork, boolean hasBudgetPlace) {
        super(lastName, firstName, group, yearOfStudy, 2200.0, ratingScore);
        this.hasScientificWork = hasScientificWork;
        this.hasBudgetPlace = hasBudgetPlace;
    }

    public boolean hasScientificWork() {
        return hasScientificWork;
    }

    public void setHasScientificWork(boolean hasScientificWork) {
        this.hasScientificWork = hasScientificWork;
    }

    public boolean hasBudgetPlace() {
        return hasBudgetPlace;
    }

    public void setHasBudgetPlace(boolean hasBudgetPlace) {
        this.hasBudgetPlace = hasBudgetPlace;
    }

    @Override
    public double getRatingScore() {
        double score = ratingScore;
        if (hasScientificWork) {
            score *= 1.1;
        }
        return score;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format(", наукові роботи: %s, бюджет: %s",
                        hasScientificWork ? "так" : "ні",
                        hasBudgetPlace ? "так" : "ні");
    }
}