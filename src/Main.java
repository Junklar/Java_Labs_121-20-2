import java.util.Scanner;
import java.util.Random;

public class Main {

    private static final int MAX_SIZE = 20;
    private static final int MIN_VALUE = -100;
    private static final int MAX_VALUE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть ширину матриці (не більше " + MAX_SIZE + "):");
        int width = scanner.nextInt();

        System.out.println("Введіть висоту матриці (не більше " + MAX_SIZE + "):");
        int height = scanner.nextInt();

        if (width > MAX_SIZE || height > MAX_SIZE) {
            System.out.println("Розмір матриці не може бути більше " + MAX_SIZE);
            return;
        }

        System.out.println("Оберіть тип створення матриці (1 - ручне введення, або 2 - рандомне заповнення):");
        int choice = scanner.nextInt();

        int[][] matrix = new int[height][width];

        // Викликаємо відповідний метод для заповнення матриці залежно від вибору користувача
        boolean filledSuccessfully = false;
        switch (choice) {
            case 1:
                filledSuccessfully = fill_matrix_manually(matrix, scanner);
                break;
            case 2:
                fill_matrix_Rand(matrix);
                filledSuccessfully = true;
                break;
            default:
                System.out.println("Неправильний вибір типу створення матриці.");
                break;
        }

        if (!filledSuccessfully) {
            return;
        }

        System.out.println("Створена матриця:");
        vyvid_matrix(matrix);

        int minElement = find_min_element(matrix);
        int maxElement = find_max_element(matrix);
        double average = avg_calc(matrix);

        System.out.println("Мінімальний елемент: " + minElement);
        System.out.println("Максимальний елемент: " + maxElement);
        System.out.println("Середнє арифметичне: " + average);
    }

    private static boolean fill_matrix_manually(int[][] matrix, Scanner scanner) {
        System.out.println("Введіть елементи матриці:");

        try {
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[0].length; col++) {
                    System.out.print("Елемент [" + row + "][" + col + "]: ");
                    matrix[row][col] = scanner.nextInt();
                }
            }
            return true; // Повертаємо true, означаючи успішне заповнення матриці
        } catch (Exception e) {
            System.out.println("Помилка введення даних: " + e.getMessage());
            return false; // Повертаємо false у випадку помилки
        }
    }

    private static void fill_matrix_Rand(int[][] matrix) {
        Random random = new Random();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
            }
        }
    }

    private static void vyvid_matrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }

    private static int find_min_element(int[][] matrix) {
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

    private static int find_max_element(int[][] matrix) {
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

    private static double avg_calc(int[][] matrix) {
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
}