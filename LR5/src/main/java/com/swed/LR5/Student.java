package com.swed.LR5;

class Student {
    protected String lastName;
    protected String firstName;
    protected String group;
    protected int yearOfStudy;
    protected double minScholarship;
    protected double ratingScore;

    public Student(String lastName, String firstName, String group,
                   int yearOfStudy, double minScholarship, double ratingScore) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.group = group;
        this.yearOfStudy = yearOfStudy;
        this.minScholarship = minScholarship;
        this.ratingScore = ratingScore;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getGroup() {
        return group;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public double getMinScholarship() {
        return minScholarship;
    }

    public double getRatingScore() {
        return ratingScore;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public void setMinScholarship(double minScholarship) {
        this.minScholarship = minScholarship;
    }

    public void setRatingScore(double ratingScore) {
        this.ratingScore = ratingScore;
    }

    public double getScholarship() {
        double score = getRatingScore();

        if (score >= 0 && score <= 60) {
            return minScholarship;
        } else if (score >= 61 && score <= 74) {
            return minScholarship * 1.2;
        } else if (score >= 75 && score <= 89) {
            return minScholarship * 1.35;
        } else if (score >= 90 && score <= 100) {
            return minScholarship * 1.5;
        }

        return minScholarship;
    }

    @Override
    public String toString() {
        return String.format("%s %s, група %s, %d курс, рейтинг: %.2f",
                firstName, lastName, group, yearOfStudy, ratingScore);
    }
}