package com.movlyk.LR5.controller;

import com.movlyk.LR5.model.DatabaseConnection;
import com.movlyk.LR5.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("last_name"),
                        rs.getString("first_name"),
                        rs.getString("middle_name"),
                        rs.getDate("birth_date").toLocalDate(),
                        rs.getString("record_book_number")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public static List<Student> getStudentsByMonth(int month) {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students WHERE MONTH(birth_date) = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, month);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("last_name"),
                        rs.getString("first_name"),
                        rs.getString("middle_name"),
                        rs.getDate("birth_date").toLocalDate(),
                        rs.getString("record_book_number")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }
}