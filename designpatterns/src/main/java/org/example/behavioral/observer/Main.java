package org.example.behavioral.observer;

public class Main {
    public static void main(String[] args) {
        JobSeeker johnDoe = new JobSeeker("John Doe");
        JobSeeker janeDoe = new JobSeeker("Jane Doe");

        JobCategory jobPostings = new JobCategory();
        jobPostings.attach(janeDoe);
        jobPostings.attach(johnDoe);

        jobPostings.addJob(new JobPost("Software Engineer at IBM"));
// Hi Jane Doe! New job posted: Software Engineer at IBM
// Hi John Doe! New job posted: Software Engineer at IBM
    }
}
