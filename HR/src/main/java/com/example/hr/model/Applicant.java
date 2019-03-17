package com.example.hr.model;


import javax.persistence.*;

@Entity
@Table(name = "applicant")
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String phone;

    private String adress;

    private String thoughtsOnJob;

    public Applicant() {
    }

    public Applicant(String name, String phone, String adress, String thoughtsOnJob) {
        this.name = name;
        this.phone = phone;
        this.adress = adress;
        this.thoughtsOnJob = thoughtsOnJob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getThoughtsOnJob() {
        return thoughtsOnJob;
    }

    public void setThoughtsOnJob(String thoughtsOnJob) {
        this.thoughtsOnJob = thoughtsOnJob;
    }


    @Override
    public String toString() {
        return "Applicant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", adress='" + adress + '\'' +
                ", thoughtsOnJob='" + thoughtsOnJob + '\'' +
                '}';
    }
}
