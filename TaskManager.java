import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {

    // List to store tasks
    private static ArrayList<String> tasks = new ArrayList<>();
    // List to store completed tasks
    private static ArrayList<String> completedTasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Task Manager!");

        // Loop for the main menu
        while (true) {
            // Show the user options
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a new task");
            System.out.println("2. View tasks");
            System.out.println("3. Mark a task as completed");
            System.out.println("4. View completed tasks");
            System.out.println("5. Exit");

            // Get the user's choice
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1: // Add a new task
                    addTask(scanner);
                    break;
                case 2: // View all tasks
                    viewTasks();
                    break;
                case 3: // Mark a task as completed
                    markAsCompleted(scanner);
                    break;
                case 4: // View completed tasks
                    viewCompletedTasks();
                    break;
                case 5: // Exit
                    System.out.println("Goodbye!");
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to add a task
    public static void addTask(Scanner scanner) {
        System.out.print("Enter the task description: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    // Method to view all tasks
    public static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\nYour tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    // Method to mark a task as completed
    public static void markAsCompleted(Scanner scanner) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available to mark as completed.");
            return;
        }

        System.out.print("Enter the task number to mark as completed: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            String completedTask = tasks.remove(taskNumber - 1);
            completedTasks.add(completedTask);
            System.out.println("Task completed: " + completedTask);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    // Method to view completed tasks
    public static void viewCompletedTasks() {
        if (completedTasks.isEmpty()) {
            System.out.println("No tasks have been completed yet.");
        } else {
            System.out.println("\nCompleted tasks:");
            for (String task : completedTasks) {
                System.out.println(task);
            }
        }
    }
}
