package com.movlyk.LR4.model;

import java.util.Objects;

public class Student extends Human {
    private String group;

    public Student(String firstName, String lastName, String middleName, Sex gender, String group) {
        super(firstName, lastName, middleName, gender);
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Student student = (Student) obj;
        return Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), group);
    }

    @Override
    public String toString() {
        return "Student{" +
                "group='" + group + '\'' +
                ", fullName=" + getFullName() +
                '}';
    }
}