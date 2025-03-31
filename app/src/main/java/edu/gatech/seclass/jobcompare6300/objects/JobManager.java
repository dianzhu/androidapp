package edu.gatech.seclass.jobcompare6300.objects;

import java.util.ArrayList;

public class JobManager {
    private CurrentJob currentJob;
    private ArrayList<JobOffer> jobOffers;
    private ComparisonSettings weights;

    public JobManager(CurrentJob currentJob, ArrayList<JobOffer> jobOffers, ComparisonSettings weights) {
        this.currentJob = currentJob;
        this.jobOffers = jobOffers;
        this.weights = weights;
    }

    public ArrayList<Job> rankJobs() {
        ArrayList<Job> jobs = new ArrayList<>(jobOffers);
        if (this.currentJob != null) {
            jobs.add(currentJob);
        }
        for (Job j : jobs) {
            setScore(j);
        }
        jobs.sort((job1, job2) -> -1 * Double.compare(job1.getScore(), job2.getScore()));
        return jobs;
    }

    private void setScore(Job job) {
        double score = 0;
        score += weights.getYearlySalaryWeight() / 9.0 * job.getAYS();
        score += weights.getYearlyBonusWeight() / 9.0 * job.getAYB();
        score += weights.getRetirementWeight() / 9.0 * job.getRetirement() * job.getAYS() / 100;
        score += weights.getRestrictedStockWeight() / 9.0 * job.getRestrictedStock() / 3;
        score += weights.getPersonalLearningAndDevelopmentWeight() / 9.0 * job.getPersonalLearningAndDevelopment();
        score += weights.getFamilyPlanningAssistanceWeight() / 9.0 * job.getFamilyPlanningAssistance();
        job.setScore(score);
    }
}
