package com.example.fitnessprojectandroid;

public class Coach {
    String Age;
    String name;
    String image;
    String proficient;
    String emailID;

    public Coach() {
    }

    public Coach(String Age, String name, String image, String proficient, String emailID) {
        this.Age = Age;
        this.name = name;
        this.image = image;
        this.proficient = proficient;
        this.emailID = emailID;
    }

    public String getAge() {
        return "Age: " +Age;
    }

    public void setAge(String age) {
        this.Age = age;
    }

    public String getName() {
        return "Name: " + name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProficient() {
        return "Proficient: " + proficient;
    }

    public void setProficient(String proficient) {
        this.proficient = proficient;
    }

    public String getEmailID() {
        return "Email ID: "+ emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }
}
