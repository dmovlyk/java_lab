package com.movlyk.LR5.view;

import com.movlyk.LR5.controller.StudentDAO;
import com.movlyk.LR5.model.Student;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nПункти меню БД!");
            System.out.println("1. Показати всіх студентів");
            System.out.println("2. Показати всіх студентів за місяцем народження");
            System.out.println("3. Exit");
            System.out.print("Enter option: ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Неправильний ввід! Будь ласка, введіть число.");
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1:
                    List<Student> allStudents = StudentDAO.getAllStudents();
                    if (allStudents.isEmpty()) {
                        System.out.println("У базі даних не знайдено жодного студента.");
                    } else {
                        allStudents.forEach(System.out::println);
                    }
                    break;

                case 2:
                    int month = 0;
                    while (true) {
                        try {
                            System.out.print("Введіть місяць народження (1-12): ");
                            month = scanner.nextInt();
                            if (month < 1 || month > 12) {
                                System.out.println("Неправильний місяць! Введіть число від 1 до 12.");
                                continue;
                            }
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Помилка: введіть правильний номер!");
                            scanner.next();
                        }
                    }

                    List<Student> studentsByMonth = StudentDAO.getStudentsByMonth(month);
                    if (studentsByMonth.isEmpty()) {
                        System.out.println("Студентів, народжених у цьому місяці, не знайдено.");
                    } else {
                        studentsByMonth.forEach(System.out::println);
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Неправильна опція! Будь ласка, виберіть правильний пункт меню.");
            }
        }
    }
}