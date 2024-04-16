import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseManager databaseManager = new DatabaseManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Виберіть опцію:");
            System.out.println("1. Отримати всіх студентів");
            System.out.println("2. Отримати студентів за місяцем народження");
            System.out.println("3. Вихід");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    List<Student> allStudents = databaseManager.getAllStudents();
                    printStudents(allStudents);
                    break;
                case 2:
                    System.out.println("Введіть місяць (від 1 до 12):");
                    int month = scanner.nextInt();
                    List<Student> studentsByMonth = databaseManager.getStudentsByBirthMonth(month);
                    printStudents(studentsByMonth);
                    break;
                case 3:
                    databaseManager.closeConnection();
                    scanner.close();
                    System.out.println("Програму завершено");
                    return;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }

    private static void printStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("Немає студентів для відображення.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}