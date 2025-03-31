package edu.gatech.seclass.jobcompare6300.objects;

public class JobOffer extends Job {
    public JobOffer(String title,
                    String company,
                    String city,
                    String state,
                    int costOfLiving,
                    double yearlySalary,
                    double yearlyBonus,
                    int retirement,
                    double restrictedStock,
                    double personalLearningAndDevelopment,
                    double familyPlanningAssistance) {
        super(
                title,
                company,
                city,
                state,
                costOfLiving,
                yearlySalary,
                yearlyBonus,
                retirement,
                restrictedStock,
                personalLearningAndDevelopment,
                familyPlanningAssistance,
                false
        );
    }
}
