import java.util.ArrayList;
import java.util.Scanner;

class Task {
    int id;
    String title;
    String description;
    boolean completed;

    Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nTitle: " + title + "\nDescription: " + description + "\nCompleted: " + completed;
    }
}

public class TaskManager {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static int idCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Task Manager ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addTask(scanner);
                case 2 -> viewTasks();
                case 3 -> updateTask(scanner);
                case 4 -> deleteTask(scanner);
                case 5 -> System.out.println("Exiting Task Manager. Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        tasks.add(new Task(idCounter++, title, description));
        System.out.println("Task added successfully!");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\n--- Task List ---");
        for (Task task : tasks) {
            System.out.println(task);
            System.out.println("----------------");
        }
    }

    private static void updateTask(Scanner scanner) {
        System.out.print("Enter task ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Task task = findTaskById(id);
        if (task == null) {
            System.out.println("Task not found.");
            return;
        }

        System.out.print("Enter new title (leave blank to keep unchanged): ");
        String title = scanner.nextLine();
        if (!title.isEmpty()) {
            task.title = title;
        }

        System.out.print("Enter new description (leave blank to keep unchanged): ");
        String description = scanner.nextLine();
        if (!description.isEmpty()) {
            task.description = description;
        }

        System.out.print("Is the task completed? (true/false): ");
        task.completed = scanner.nextBoolean();

        System.out.println("Task updated successfully!");
    }

    private static void deleteTask(Scanner scanner) {
        System.out.print("Enter task ID to delete: ");
        int id = scanner.nextInt();

        Task task = findTaskById(id);
        if (task == null) {
            System.out.println("Task not found.");
            return;
        }

        tasks.remove(task);
        System.out.println("Task deleted successfully!");
    }

    private static Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.id == id) {
                return task;
            }
        }
        return null;
    }
}