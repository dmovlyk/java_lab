package com.movlyk.LR3.view;

import com.movlyk.LR3.model.*;
import com.movlyk.LR3.controller.*;

public class Run {
    public static void main(String[] args) {
        Human rector = new Human("Іван", "Петров", "Михайлович", Sex.MALE);
        University university = new University("Київський університет", rector);

        Faculty faculty = new Faculty("Факультет інформатики");
        UniversityCreator.addFaculty(university, faculty); // Використовуємо UniversityCreator

        Group group = new Group("ІТ-21");
        GroupCreator.addGroup(faculty, group); // Використовуємо GroupCreator

        Student student1 = new Student("Олександр", "Іванов", "Сергійович", Sex.MALE, "ІТ-21");
        Student student2 = new Student("Марина", "Петренко", "Олексіївна", Sex.FEMALE, "ІТ-21");

        StudentCreator.addStudent(group, student1);
        StudentCreator.addStudent(group, student2);

        System.out.println("Університет: " + university.getName());
        System.out.println("Ректор: " + university.getRector().getFullName());

        for (Faculty f : university.getFaculties()) {
            System.out.println("Факультет: " + f.getName());
            for (Group g : f.getGroups()) {
                System.out.println("  Група: " + g.getName());
                for (Student s : g.getStudents()) {
                    System.out.println("    Студент: " + s.getFullName() + ", Група: " + s.getGroup());
                }
            }
        }
    }
}