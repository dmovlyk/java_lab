package com.movlyk.LR4.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Faculty {
    private String name;
    private List<Group> groups = new ArrayList<>();

    public Faculty(String name) {
        this.name = name;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public String getName() {
        return name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Faculty faculty = (Faculty) obj;
        return Objects.equals(name, faculty.name) && Objects.equals(groups, faculty.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, groups);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", groups=" + groups +
                '}';
    }
}