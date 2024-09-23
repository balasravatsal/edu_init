package org.astronutRunner.factory;

import org.astronutRunner.exceptionHandler.InvalidTaskException;

import java.util.logging.Logger;

public class TaskFactory {
    private static final Logger logger = Logger.getLogger(TaskFactory.class.getName());

    public Task createTask(String description, String startTime, String endTime, String priority) throws InvalidTaskException {
        validateInputs(description, startTime, endTime, priority);

        // Check if the provided time format is valid
        if (!isValidTime(startTime) || !isValidTime(endTime)) {
            logger.warning("Invalid time format.");
            throw new InvalidTaskException("Invalid time format.");
        }
        return new Task(description, startTime, endTime, priority);
    }

    private void validateInputs(String description, String startTime, String endTime, String priority) throws InvalidTaskException {
        if (description == null || description.trim().isEmpty()) {
            logger.warning("Task description cannot be empty.");
            throw new InvalidTaskException("Task description cannot be empty.");
        }
        if (priority == null || priority.trim().isEmpty()) {
            logger.warning("Priority level cannot be null.");
            throw new InvalidTaskException("Priority level cannot be null.");
        }
    }

    private boolean isValidTime(String time) {
        return time.matches("([01]\\d|2[0-3]):[0-5]\\d");
    }
}
