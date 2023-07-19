package org.example.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class JobCategory {
    private List<JobSeeker> observers = new ArrayList<>();

    public void notify(JobPost jobPosting) {
        for (JobSeeker observer : this.observers) {
            observer.onJobPosted(jobPosting);
        }
    }

    public void attach(JobSeeker observer) {
        this.observers.add(observer);
    }

    public void addJob(JobPost jobPosting) {
        this.notify(jobPosting);
    }
}
