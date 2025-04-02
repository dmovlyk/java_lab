package com.movlyk.LR4.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.movlyk.LR4.model.University;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonManager {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void writeUniversityToJson(University university, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(university, writer);
            System.out.println("Університет записано у JSON: " + filename);
        } catch (IOException e) {
            System.err.println("Помилка запису JSON: " + e.getMessage());
        }
    }

    public static University readUniversityFromJson(String filename) {
        try (FileReader reader = new FileReader(filename)) {
            University university = gson.fromJson(reader, University.class);
            System.out.println("Університет успішно зчитано з JSON.");
            return university;
        } catch (IOException e) {
            System.err.println("Помилка читання JSON: " + e.getMessage());
            return null;
        }
    }
}