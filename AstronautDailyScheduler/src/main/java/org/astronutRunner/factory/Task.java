package org.astronutRunner.factory;

public class Task {
    private String description;
    private String startTime; // Start time in HH:MM format
    private String endTime; // End time in HH:MM format
    private String priority; // Task priority (Low, Medium, High)
    private boolean isCompleted; // Completion status of the task

    // Constructor to initialize a new task
    public Task(String description, String startTime, String endTime, String priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority.toLowerCase();
        this.isCompleted = false; // Default status
    }

    // Getters for task attributes
    public String getDescription() { return description; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
    public String getPriority() { return priority; }
    public boolean isCompleted() { return isCompleted; }

    // Mark the task as completed
    public void markCompleted() { this.isCompleted = true; }

    // Edit task details
    public void editTask(String newDescription, String newStartTime, String newEndTime, String newPriority) {
        this.description = newDescription;
        this.startTime = newStartTime;
        this.endTime = newEndTime;
        this.priority = newPriority.toLowerCase();
    }

    // String representation of the task
    @Override
    public String toString() {
        return String.format("%s - %s: %s [%s] %s",
                startTime, endTime, description,
                capitalizeFirstLetter(priority),
                isCompleted ? "(Completed)" : "(Pending)");
    }

    // Capitalize the first letter of a string
    private String capitalizeFirstLetter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
