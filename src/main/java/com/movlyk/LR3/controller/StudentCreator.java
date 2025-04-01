package com.movlyk.LR3.controller;

import com.movlyk.LR3.model.Group;
import com.movlyk.LR3.model.Student;

public class StudentCreator {
    public static void addStudent(Group group, Student student) {
        group.addStudent(student);
    }
}