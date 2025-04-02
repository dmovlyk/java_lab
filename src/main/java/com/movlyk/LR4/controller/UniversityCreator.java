package com.movlyk.LR4.controller;

import com.movlyk.LR4.model.Faculty;
import com.movlyk.LR4.model.University;

public class UniversityCreator {
    public static void addFaculty(University university, Faculty faculty) {
        university.addFaculty(faculty);
    }
}