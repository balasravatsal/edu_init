package org.astronutRunner;

import org.astronutRunner.services.ScheduleManager;
import org.astronutRunner.consoleUtils.ConsoleHelper;

import java.util.Scanner;
import java.util.regex.Pattern;

// Main client class for the Astronaut Schedule Manager application
public class Client {

    private final ScheduleManager manager; // Instance of the ScheduleManager
    private final ConsoleHelper console; // Utility for console interactions
    private final Scanner scanner; // Scanner for user input

    public Client() {
        this.manager = ScheduleManager.getInstance(); // Get the singleton ScheduleManager instance
        this.console = new ConsoleHelper(); // Initialize console helper
        this.scanner = new Scanner(System.in); // Initialize scanner
    }

    // Method to run the application
    public void run() {
        Menu menu = new Menu();

        while (menu.isRunning()) {
            menu.displayOptions();
            int option = getUserOption();
            // Execute the corresponding action based on user choice
            switch (option) {
                case 1 -> addTask();
                case 2 -> removeTask();
                case 3 -> editTask();
                case 4 -> markTaskAsCompleted();
                case 5 -> manager.viewTasks();
                case 6 -> viewTasksByPriority();
                case 7 -> {
                    console.printSuccess("Exiting application.");
                    menu.deactivate();
                }
                default -> console.printWarning("Invalid option. Please try again."); // Handle invalid input
            }
        }
        scanner.close(); // Close the scanner resource
    }

    // Helper method to get the user's option input
    private int getUserOption() {
        int option = -1;

        console.printInput("Choose an option: ");
        try {
            option = Integer.parseInt(scanner.nextLine()); // Parse user input to integer
        } catch (NumberFormatException e) {
            console.printError("Error: Invalid input format. Please enter a number."); // Handle invalid input
        }
        return option;
    }

    // Method to add a new task
    private void addTask() {
        console.printInput("Enter task description (or type 'back' to return): ");
        String description = scanner.nextLine();
        if (description.equalsIgnoreCase("back")) return; // Exit if 'back' is typed

        String startTime = getValidTimeInput("Enter start time (HH:MM): "); // Get valid start time
        String endTime = getValidTimeInput("Enter end time (HH:MM): "); // Get valid end time

        console.printInput("Enter priority (Low, Medium, High): ");
        String priority = scanner.nextLine();

        manager.addTask(description, startTime, endTime, priority); // Add the task using manager
    }

    // Method to remove a task by description
    private void removeTask() {
        console.printInput("Enter task description to remove (or type 'back' to return): ");
        String taskDescription = scanner.nextLine();
        if (taskDescription.equalsIgnoreCase("back")) return; // Exit if 'back' is typed

        manager.removeTask(taskDescription); // Remove the task using manager
    }

    // Method to edit an existing task
    private void editTask() {
        console.printInput("Enter the existing task description: ");
        String oldDescription = scanner.nextLine(); // Get the old task description

        console.printInput("Enter new task description (or type 'back' to cancel): ");
        String newDescription = scanner.nextLine();
        if (newDescription.equalsIgnoreCase("back")) return; // Cancel editing if 'back' is typed

        String newStartTime = getValidTimeInput("Enter new start time (HH:MM): ");
        String newEndTime = getValidTimeInput("Enter new end time (HH:MM): ");

        console.printInput("Enter new priority (Low, Medium, High): ");
        String newPriority = scanner.nextLine();

        manager.editTask(oldDescription, newDescription, newStartTime, newEndTime, newPriority); // Edit the task using manager
    }

    // Method to mark a task as completed
    private void markTaskAsCompleted() {
        console.printInput("Enter task description to mark as completed: ");
        String taskDescription = scanner.nextLine();
        manager.markTaskAsCompleted(taskDescription); // Mark the task using manager
    }

    // Helper method to get valid time input
    private String getValidTimeInput(String prompt) {
        boolean gettingTime = true; // Control flag for getting valid time input
        String time = "";

        while (gettingTime) {   // not hard coded, it will be checked by the regex in isValidTime method
            console.printInput(prompt);
            time = scanner.nextLine();
            if (isValidTime(time)) {
                gettingTime = false; // Exit loop if input is valid
            } else {
                console.printError("Invalid time format. Please enter time in HH:MM format."); // Handle invalid time format
            }
        }
        return time; // Return valid time
    }

    // Method to view tasks by priority level
    private void viewTasksByPriority() {
        console.printInput("Enter priority level (Low, Medium, High): ");
        String priority = scanner.nextLine();
        manager.viewTasksByPriority(priority); // View tasks using manager
        console.printInput("Press Enter to return to menu..."); // Prompt to return to menu
        scanner.nextLine(); // Wait for user input
    }

    // Helper method to validate time format
    private boolean isValidTime(String time) {
        String timePattern = "^([01]\\d|2[0-3]):([0-5]\\d)$"; // Regex for HH:MM format
        return Pattern.matches(timePattern, time); // Return true if time matches pattern
    }

    // Main method to start the application
    public static void main(String[] args) {
        new Client().run(); // Create Client instance and run the application
    }
}

// Simple Menu class to handle menu options
class Menu {
    private boolean running = true; // Control flag for the main loop

    public boolean isRunning() {
        return running;
    }

    public void deactivate() {
        this.running = false;
    }

    public void displayOptions() {
        System.out.println("\nAstronaut Schedule Manager"); // Title
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. Edit Task");
        System.out.println("4. Mark Task as Completed");
        System.out.println("5. View Tasks");
        System.out.println("6. View Tasks by Priority");
        System.out.println("7. Exit"); // Exit option
    }
}
