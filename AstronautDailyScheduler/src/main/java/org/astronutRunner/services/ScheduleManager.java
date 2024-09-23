package org.astronutRunner.services;

import org.astronutRunner.factory.Task;
import org.astronutRunner.consoleUtils.ConsoleHelper;
import org.astronutRunner.exceptionHandler.InvalidTaskException;
import org.astronutRunner.factory.TaskFactory;

import java.util.*;
import java.util.logging.Logger;

public class ScheduleManager {
    private static ScheduleManager instance; // Singleton instance
    private List<Task> tasks; // List to store tasks
    private ConflictNotifier conflictNotifier; // Handles task conflict checking
    private TaskFactory taskFactory; // Factory to create new tasks
    private ConsoleHelper console; // Utility for console interactions
    private static final Logger logger = Logger.getLogger(ScheduleManager.class.getName()); // Logger for tracking actions

    // Private constructor for singleton pattern
    private ScheduleManager() {
        tasks = new ArrayList<>(); // Initialize task list
        conflictNotifier = new ConflictNotifier(); // Initialize conflict notifier
        taskFactory = new TaskFactory(); // Initialize task factory
        console = new ConsoleHelper(); // Initialize console helper
    }

    // Singleton access method
    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager(); // Create instance if it doesn't exist
        }
        return instance; // Return existing instance
    }

    // Method to add a new task
    public void addTask(String description, String startTime, String endTime, String priority) {
        try {
            Task newTask = taskFactory.createTask(description, startTime, endTime, priority); // Create task
            // Check for conflicts before adding
            if (!conflictNotifier.checkForConflicts(newTask, tasks)) {
                tasks.add(newTask); // Add task if no conflicts
                console.printSuccess("Task added successfully. No conflicts.");
            } else {
                console.printError("Task could not be added due to a conflict.");
            }
        } catch (InvalidTaskException e) {
            console.printError("Failed to add task: " + e.getMessage()); // Handle exception
        }
    }

    // Method to remove a task by description
    public void removeTask(String description) {
        Task taskToRemove = tasks.stream()
                .filter(task -> task.getDescription().equals(description))
                .findFirst()
                .orElse(null);
        if (taskToRemove != null) {
            tasks.remove(taskToRemove); // Remove the task
            console.printSuccess("Task removed successfully.");
        } else {
            console.printError("Error: Task not found."); // Handle not found
        }
    }

    // Method to edit an existing task
    public void editTask(String oldDescription, String newDescription, String newStartTime, String newEndTime, String newPriority) {
        Task taskToEdit = tasks.stream()
                .filter(task -> task.getDescription().equals(oldDescription))
                .findFirst()
                .orElse(null);
        if (taskToEdit != null) {
            try {
                taskToEdit.editTask(newDescription, newStartTime, newEndTime, newPriority); // Edit task details
                console.printSuccess("Task edited successfully.");
            } catch (Exception e) {
                console.printError("Error editing task: " + e.getMessage()); // Handle edit errors
            }
        } else {
            console.printError("Error: Task not found."); // Handle not found
        }
    }

    // Method to mark a task as completed
    public void markTaskAsCompleted(String description) {
        Task taskToMark = tasks.stream()
                .filter(task -> task.getDescription().equals(description))
                .findFirst()
                .orElse(null);
        if (taskToMark != null) {
            taskToMark.markCompleted(); // Mark the task as completed
            console.printSuccess("Task marked as completed.");
        } else {
            console.printError("Error: Task not found."); // Handle not found
        }
    }

    // Method to view all tasks
    public void viewTasks() {
        if (tasks.isEmpty()) {
            console.printWarning("No tasks scheduled for the day."); // Handle empty task list
        } else {
            tasks.stream()
                    .sorted(Comparator.comparing(Task::getStartTime)) // Sort by start time
                    .forEach(task -> console.printMenu(task.toString())); // Print each task
        }
    }

    // Method to view tasks by priority level
    public void viewTasksByPriority(String priority) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getPriority().equals(priority.toLowerCase())) {
                filteredTasks.add(task); // Filter tasks by priority
            }
        }
        if (filteredTasks.isEmpty()) {
            console.printWarning("No tasks found for priority level: " + priority); // Handle no tasks found
        } else {
            filteredTasks.stream()
                    .sorted(Comparator.comparing(Task::getStartTime)) // Sort by start time
                    .forEach(task -> console.printMenu(task.toString())); // Print each task
        }
    }
}
