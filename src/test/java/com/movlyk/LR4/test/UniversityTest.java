package com.movlyk.LR4.test;

import com.movlyk.LR4.controller.JsonManager;
import com.movlyk.LR4.model.*;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniversityTest {

    @Test
    void testWriteAndReadUniversityFromJson() {
        Human rector = new Human("Іван", "Петров", "Михайлович", Sex.MALE);
        University oldUniversity = new University("Київський університет", rector);

        Faculty faculty = new Faculty("Факультет Комп'ютерних Наук");
        Group group = new Group("Група 101");
        Student student1 = new Student("Олег", "Іванов", "Степанович", Sex.MALE, "Група 101");
        Student student2 = new Student("Марія", "Петренко", "Олександрівна", Sex.FEMALE, "Група 101");

        group.addStudent(student1);
        group.addStudent(student2);
        faculty.addGroup(group);
        oldUniversity.addFaculty(faculty);

        String filename = "university_test.json";
        JsonManager.writeUniversityToJson(oldUniversity, filename);
        University newUniversity = JsonManager.readUniversityFromJson(filename);

        assertNotNull(newUniversity, "Файл JSON не зчитався, об'єкт newUniversity == null");

        assertEquals(oldUniversity.getName(), newUniversity.getName(), "Назва університетів не співпадають");
        assertEquals(oldUniversity.getRector(), newUniversity.getRector(), "Ректори не співпадають");
        assertEquals(oldUniversity.getFaculties().size(), newUniversity.getFaculties().size(), "Кількість факультетів не співпадає");

        for (int i = 0; i < oldUniversity.getFaculties().size(); i++) {
            assertEquals(oldUniversity.getFaculties().get(i).getName(), newUniversity.getFaculties().get(i).getName(), "Факультети не співпадають");
        }
    }
}