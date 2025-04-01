package com.movlyk.LR2;

import java.util.Random;
import java.util.Scanner;

public class MatrixOperations {
    private static final int MAX_SIZE = 20;
    private static final int MIN_RANDOM = -100;
    private static final int MAX_RANDOM = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть висоту матриці (не більше " + MAX_SIZE + "): ");
        int rows = scanner.nextInt();
        System.out.print("Введіть ширину матриці (не більше " + MAX_SIZE + "): ");
        int cols = scanner.nextInt();

        if (rows <= 0 || rows > MAX_SIZE || cols <= 0 || cols > MAX_SIZE) {
            System.out.println("Невірний розмір матриці!");
            return;
        }

        int[][] matrix = new int[rows][cols];

        System.out.print("Оберіть спосіб заповнення (1 - вручну, 2 - випадково): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            fillMatrixManually(matrix, scanner);
        } else {
            fillMatrixRandomly(matrix);
        }

        printMatrix(matrix);
        System.out.println("Мінімальний елемент: " + findMin(matrix));
        System.out.println("Максимальний елемент: " + findMax(matrix));
        System.out.println("Середнє арифметичне: " + calculateAverage(matrix));
        System.out.println("Середнє геометричне: " + calculateGeometricMean(matrix));

        scanner.close();
    }

    private static void fillMatrixManually(int[][] matrix, Scanner scanner) {
        System.out.println("Введіть елементи матриці:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static void fillMatrixRandomly(int[][] matrix) {
        Random rand = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = rand.nextInt(MAX_RANDOM - MIN_RANDOM + 1) + MIN_RANDOM;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println("Матриця:");
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }

    private static int findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] row : matrix) {
            for (int num : row) {
                if (num < min) {
                    min = num;
                }
            }
        }
        return min;
    }

    private static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int num : row) {
                if (num > max) {
                    max = num;
                }
            }
        }
        return max;
    }

    private static double calculateAverage(int[][] matrix) {
        int sum = 0, count = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sum += num;
                count++;
            }
        }
        return (double) sum / count;
    }

    private static double calculateGeometricMean(int[][] matrix) {
        double product = 1.0;
        int count = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                if (num == 0) continue;  // Уникнення множення на 0
                product *= Math.abs(num);
                count++;
            }
        }
        return Math.pow(product, 1.0 / count);
    }
}