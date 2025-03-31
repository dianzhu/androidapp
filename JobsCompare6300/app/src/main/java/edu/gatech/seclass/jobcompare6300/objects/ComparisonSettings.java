package edu.gatech.seclass.jobcompare6300.objects;

public class ComparisonSettings {
    private int yearlySalaryWeight;
    private int yearlyBonusWeight;
    private int retirementWeight;
    private int restrictedStockWeight;
    private int personalLearningAndDevelopmentWeight;
    private int familyPlanningAssistanceWeight;

    public ComparisonSettings(int yearlySalaryWeight,
                              int yearlyBonusWeight,
                              int retirementWeight,
                              int restrictedStockWeight,
                              int personalLearningAndDevelopmentWeight,
                              int familyPlanningAssistanceWeight) {
        this.yearlySalaryWeight = yearlySalaryWeight;
        this.yearlyBonusWeight = yearlyBonusWeight;
        this.retirementWeight = retirementWeight;
        this.restrictedStockWeight = restrictedStockWeight;
        this.personalLearningAndDevelopmentWeight = personalLearningAndDevelopmentWeight;
        this.familyPlanningAssistanceWeight = familyPlanningAssistanceWeight;
    }

    public int getYearlySalaryWeight() {
        return yearlySalaryWeight;
    }

    public int getYearlyBonusWeight() {
        return yearlyBonusWeight;
    }

    public int getRetirementWeight() {
        return retirementWeight;
    }

    public int getRestrictedStockWeight() {
        return restrictedStockWeight;
    }

    public int getPersonalLearningAndDevelopmentWeight() {
        return personalLearningAndDevelopmentWeight;
    }

    public int getFamilyPlanningAssistanceWeight() {
        return familyPlanningAssistanceWeight;
    }
}
