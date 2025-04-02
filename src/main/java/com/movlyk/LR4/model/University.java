package com.movlyk.LR4.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        University that = (University) obj;
        return Objects.equals(name, that.name) &&
                Objects.equals(rector, that.rector) &&
                Objects.equals(faculties, that.faculties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rector, faculties);
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", rector=" + rector +
                ", faculties=" + faculties +
                '}';
    }
}