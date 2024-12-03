package com.jap.task;

import java.util.Scanner;

public class TaskManager {
    // Attributes for category and task operations
    private CategoryOperations categoryOperations;
    private TaskOperations taskOperations;

    /**
     * Constructs a new TaskManager object.
     * Initializes category and task operation objects.
     */
    public TaskManager() {
        // Initialize category and task operation objects
        categoryOperations = new CategoryOperations();
        taskOperations = new TaskOperations();
    }

    /**
     * Allows the authenticated user to interact with the task manager by providing menu choices.
     *
     * @param authenticatedUser The authenticated user accessing the task manager.
     */
    public void takeChoices(User authenticatedUser) {
        Scanner scanner = new Scanner(System.in);
        String categoryName;
        Category selectedCategory;
        int choice;

        // Display the menu options and handle user choices until the user chooses to exit
        do {
            System.out.println("\nTask Manager Menu");
            System.out.println("1. Add a Task");
            System.out.println("2. List all Tasks");
            System.out.println("3. Mark a Task as Completed");
            System.out.println("4. Remove a Task");
            System.out.println("5. Add a Category");
            System.out.println("6. List all Categories");
            System.out.println("7. Search for a Task by Name");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add a new task
                    System.out.print("Enter Category Name: ");
                    categoryName = scanner.next();
                    selectedCategory = categoryOperations.findCategory(categoryName);
                    if (selectedCategory != null) {
                        System.out.print("Enter Task Name: ");
                        String taskName = scanner.next();
                        System.out.print("Enter Task Priority: ");
                        int priority = scanner.nextInt();
                        System.out.print("Enter Task Description: ");
                        String description = scanner.next();
                        Task newTask = new Task(taskName, priority, description, false, selectedCategory);
                        if (taskOperations.addTask(selectedCategory, newTask, authenticatedUser)) {
                            System.out.println("Task added successfully.");
                        } else {
                            System.out.println("Task already exists.");
                        }
                    } else {
                        System.out.println("Category not found. Please create the category first.");
                    }
                    break;
                case 2:
                    // List all tasks
                    System.out.print("Enter Category Name: ");
                    categoryName = scanner.next();
                    for (String task : taskOperations.listAllTasks(categoryName)) {
                        System.out.println(task);
                    }
                    break;
                case 3:
                    // Mark a task as completed
                    System.out.print("Enter Task Name: ");
                    String taskName = scanner.next();
                    System.out.print("Enter Task Status (completed/pending): ");
                    String statusInput = scanner.next();
                    if (taskOperations.markTaskAsCompleted(taskName, statusInput)) {
                        System.out.println("Task status updated successfully.");
                    } else {
                        System.out.println("Invalid status input or task not found.");
                    }
                    break;
                case 4:
                    // Remove a task
                    System.out.print("Enter Task Name: ");
                    taskName = scanner.next();
                    try {
                        if (taskOperations.removeTask(taskName)) {
                            System.out.println("Task removed successfully.");
                        }
                    } catch (TaskNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    // Add a new category
                    System.out.print("Enter Category Name: ");
                    categoryName = scanner.next();
                    if (categoryOperations.addCategory(categoryName)) {
                        System.out.println("Category added successfully.");
                    } else {
                        System.out.println("Category already exists.");
                    }
                    break;
                case 6:
                    // List all categories
                    for (Category category : categoryOperations.listAllCategories()) {
                        System.out.println(category.getCategoryName());
                    }
                    break;
                case 7:
                    // Search for a task by name
                    System.out.print("Enter Task Name: ");
                    taskName = scanner.next();
                    Task task = taskOperations.searchTasksByName(taskName);
                    if (task != null) {
                        System.out.println(task);
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case 8:
                    // Exit the program
                    System.out.println("Exiting Task Manager...");
                    break;
                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
                    break;
            }
        } while (choice != 8);

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
