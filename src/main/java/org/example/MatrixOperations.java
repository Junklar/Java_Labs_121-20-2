package org.example;

import java.util.Scanner;

public class MatrixOperations {
    private static final int MAX_SIZE = 20;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows (not more than 20):");
        int rows = scanner.nextInt();
        if (rows <= 0 || rows > MAX_SIZE) {
            System.out.println("Invalid input for rows. Exiting program.");
            return;
        }

        System.out.println("Enter the number of columns (not more than 20):");
        int columns = scanner.nextInt();
        if (columns <= 0 || columns > MAX_SIZE) {
            System.out.println("Invalid input for columns. Exiting program.");
            return;
        }

        int[][] matrix;
        System.out.println("Choose how to create the matrix:");
        System.out.println("1. Manual input");
        System.out.println("2. Random generation");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                matrix = createMatrixManual(rows, columns, scanner);
                break;
            case 2:
                matrix = createMatrixRandom(rows, columns);
                break;
            default:
                System.out.println("Invalid choice. Exiting program.");
                return;
        }

        System.out.println("Matrix:");
        printMatrix(matrix);

        int minElement = findMinElement(matrix);
        int maxElement = findMaxElement(matrix);
        double average = calculateAverage(matrix);
        double geometricMean = calculateGeometricMean(matrix);

        System.out.println("Minimum element: " + minElement);
        System.out.println("Maximum element: " + maxElement);
        System.out.println("Average: " + average);
        System.out.println("Geometric mean: " + geometricMean);

        scanner.close();
    }

    private static int[][] createMatrixManual(int rows, int columns, Scanner scanner) {
        int[][] matrix = new int[rows][columns];
        System.out.println("Enter elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static int[][] createMatrixRandom(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = (int) (Math.random() * (MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE);
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int findMinElement(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] row : matrix) {
            for (int element : row) {
                if (element < min) {
                    min = element;
                }
            }
        }
        return min;
    }

    private static int findMaxElement(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int element : row) {
                if (element > max) {
                    max = element;
                }
            }
        }
        return max;
    }

    private static double calculateAverage(int[][] matrix) {
        int sum = 0;
        int count = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
                count++;
            }
        }
        return (double) sum / count;
    }

    private static double calculateGeometricMean(int[][] matrix) {
        int product = 1;
        int count = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                product *= element;
                count++;
            }
        }
        return Math.pow(product, 1.0 / count);
    }
}
