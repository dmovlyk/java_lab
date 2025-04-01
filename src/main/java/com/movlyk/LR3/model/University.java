package com.movlyk.LR3.model;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private Human rector;
    private List<Faculty> faculties = new ArrayList<>();

    public University(String name, Human rector) {
        this.name = name;
        this.rector = rector;
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public String getName() {
        return name;
    }

    public Human getRector() {
        return rector;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }
}