package com.movlyk.LR3.model;

public class Student extends Human {
    private String group;

    public Student(String firstName, String lastName, String middleName, Sex gender, String group) {
        super(firstName, lastName, middleName, gender);
        this.group = group;
    }

    public String getGroup() {
        return group;
    }
}