package com.movlyk.LR4.view;

import com.movlyk.LR4.controller.JsonManager;
import com.movlyk.LR4.model.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Run {
    public static void main(String[] args) {
        // Створення ректора
        Human rector = new Human("Іван", "Петров", "Михайлович", Sex.MALE);
        University university = new University("Київський університет", rector);

        // Створення факультетів
        Faculty faculty1 = new Faculty("Факультет Комп'ютерних Наук");
        Faculty faculty2 = new Faculty("Факультет Математики");

        // Створення груп
        Group group1 = new Group("Група 101");
        Group group2 = new Group("Група 102");
        Group group3 = new Group("Група 201");
        Group group4 = new Group("Група 202");

        // Створення студентів
        Student student1 = new Student("Олег", "Іванов", "Степанович", Sex.MALE, "Група 101");
        Student student2 = new Student("Марія", "Петренко", "Олександрівна", Sex.FEMALE, "Група 101");
        Student student3 = new Student("Андрій", "Сидоренко", "Ігорович", Sex.MALE, "Група 102");
        Student student4 = new Student("Олена", "Ковальчук", "Василівна", Sex.FEMALE, "Група 102");

        Student student5 = new Student("Володимир", "Шевченко", "Анатолійович", Sex.MALE, "Група 201");
        Student student6 = new Student("Наталія", "Федоренко", "Петрівна", Sex.FEMALE, "Група 201");
        Student student7 = new Student("Максим", "Дорошенко", "Сергійович", Sex.MALE, "Група 202");
        Student student8 = new Student("Ірина", "Бондаренко", "Миколаївна", Sex.FEMALE, "Група 202");

        // Додавання студентів у групи
        group1.addStudent(student1);
        group1.addStudent(student2);
        group2.addStudent(student3);
        group2.addStudent(student4);

        group3.addStudent(student5);
        group3.addStudent(student6);
        group4.addStudent(student7);
        group4.addStudent(student8);

        // Додавання груп у факультети
        faculty1.addGroup(group1);
        faculty1.addGroup(group2);
        faculty2.addGroup(group3);
        faculty2.addGroup(group4);

        // Додавання факультетів в університет
        university.addFaculty(faculty1);
        university.addFaculty(faculty2);

        // Записуємо університет у JSON
        JsonManager.writeUniversityToJson(university, "university.json");

        // Читаємо університет із JSON
        University newUniversity = JsonManager.readUniversityFromJson("university.json");

        // Логічний вивід інформації
        System.out.println("=== ОРИГІНАЛЬНИЙ УНІВЕРСИТЕТ ===");
        printUniversity(university);

        System.out.println("\n=== ВІДНОВЛЕНИЙ УНІВЕРСИТЕТ ===");
        printUniversity(newUniversity);

        // Перевірка еквівалентності
        System.out.println("\nЧи рівні оригінальний та відновлений університети? " + university.equals(newUniversity));
    }

    private static void printUniversity(University university) {
        System.out.println("Назва університету: " + university.getName());
        System.out.println("Ректор: " + university.getRector().getFullName());

        for (Faculty faculty : university.getFaculties()) {
            System.out.println("\n  Факультет: " + faculty.getName());

            for (Group group : faculty.getGroups()) {
                System.out.println("    Група: " + group.getName());

                for (Student student : group.getStudents()) {
                    System.out.println("      Студент: " + student.getFullName() + " (" + student.getGender() + ")");
                }
            }
        }
    }
}