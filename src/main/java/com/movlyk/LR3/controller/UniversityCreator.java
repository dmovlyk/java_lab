package com.movlyk.LR3.controller;

import com.movlyk.LR3.model.Faculty;
import com.movlyk.LR3.model.University;

public class UniversityCreator {
    public static void addFaculty(University university, Faculty faculty) {
        university.addFaculty(faculty);
    }
}