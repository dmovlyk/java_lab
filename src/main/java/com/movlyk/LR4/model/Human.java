package com.movlyk.LR4.model;

import java.util.Objects;

public class Human {
    private String firstName;
    private String lastName;
    private String middleName;
    private Sex gender;

    public Human(String firstName, String lastName, String middleName, Sex gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.gender = gender;
    }

    public String getFullName() {
        return lastName + " " + firstName + " " + middleName;
    }

    public Sex getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Human human = (Human) obj;
        return Objects.equals(firstName, human.firstName) &&
                Objects.equals(lastName, human.lastName) &&
                Objects.equals(middleName, human.middleName) &&
                gender == human.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleName, gender);
    }

    @Override
    public String toString() {
        return "Human{" +
                "fullName='" + getFullName() + '\'' +
                ", gender=" + gender +
                '}';
    }
}