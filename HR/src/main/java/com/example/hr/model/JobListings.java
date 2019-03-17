package com.example.hr.model;



import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "JobListings")
public class JobListings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String jobTitle;

    private String jobDescription;

    private int numberOfPeopleToHire;


    private Date lastApplicationDate;

    public JobListings() {
        super();
    }

    public JobListings(int id, String jobTitle, String jobDescription, int numberOfPeopleToHire, Date lastApplicationDate) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.numberOfPeopleToHire = numberOfPeopleToHire;
        this.lastApplicationDate = lastApplicationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public int getNumberOfPeopleToHire() {
        return numberOfPeopleToHire;
    }

    public void setNumberOfPeopleToHire(int numberOfPeopleToHire) {
        this.numberOfPeopleToHire = numberOfPeopleToHire;
    }

    public Date getLastApplicationDate() {
        return lastApplicationDate;
    }

    public void setLastApplicationDate(Date lastApplicationDate) {
        this.lastApplicationDate = lastApplicationDate;
    }

    @Override
    public String toString() {
        return "JobListings{" +
                "jobTitle='" + jobTitle + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", numberOfPeopleToHire=" + numberOfPeopleToHire +
                ", lastApplicationDate=" + lastApplicationDate +
                '}';
    }
}
