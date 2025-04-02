package com.movlyk.LR4.controller;

import com.movlyk.LR4.model.Group;
import com.movlyk.LR4.model.Student;

public class StudentCreator {
    public static void addStudent(Group group, Student student) {
        group.addStudent(student);
    }
}