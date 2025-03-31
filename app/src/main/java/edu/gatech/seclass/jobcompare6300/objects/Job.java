package edu.gatech.seclass.jobcompare6300.objects;

import java.io.Serializable;

public class Job implements Serializable {
    private String title;
    private String company;
    private String city;
    private String state;
    private int costOfLiving;
    private double yearlySalary;
    private double yearlyBonus;
    private int retirement;
    private double restrictedStock;
    private double personalLearningAndDevelopment;
    private double familyPlanningAssistance;
    private boolean isCurrent;
    private double score;

    public Job(String title,
               String company,
               String city,
               String state,
               int costOfLiving,
               double yearlySalary,
               double yearlyBonus,
               int retirement,
               double restrictedStock,
               double personalLearningAndDevelopment,
               double familyPlanningAssistance,
               boolean isCurrent) {
        this.title = title;
        this.company = company;
        this.city = city;
        this.state = state;
        this.costOfLiving = costOfLiving;
        this.yearlySalary = yearlySalary;
        this.yearlyBonus = yearlyBonus;
        this.retirement = retirement;
        this.restrictedStock = restrictedStock;
        this.personalLearningAndDevelopment = personalLearningAndDevelopment;
        this.familyPlanningAssistance = familyPlanningAssistance;
        this.isCurrent = isCurrent;
    }

    public double getAYS() {
        return this.yearlySalary * 100 / this.costOfLiving;
    }

    public double getAYB() {
        return this.yearlyBonus * 100 / this.costOfLiving;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getCostOfLiving() {
        return costOfLiving;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public double getYearlyBonus() {
        return yearlyBonus;
    }

    public int getRetirement() {
        return retirement;
    }

    public double getRestrictedStock() {
        return restrictedStock;
    }

    public double getPersonalLearningAndDevelopment() {
        return personalLearningAndDevelopment;
    }

    public double getFamilyPlanningAssistance() {
        return familyPlanningAssistance;
    }

    public boolean getIsCurrent() {
        return isCurrent;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
