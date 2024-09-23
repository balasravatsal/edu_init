
package org.astronutRunner.services;

import java.util.List;

import org.astronutRunner.factory.Task;

import java.util.logging.*;


public class ConflictNotifier {
    private static final Logger logger = Logger.getLogger(ConflictNotifier.class.getName());

    static {
        // Custom logger format to suppress timestamp and class information
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter() {
            @Override
            public synchronized String format(LogRecord lr) {
                return String.format("WARNING: %s%n", lr.getMessage());
            }
        });
        logger.setUseParentHandlers(false);
        logger.addHandler(handler);
    }

    public boolean checkForConflicts(Task newTask, List<Task> existingTasks) {
        // Check if end time is greater than start time
        if (newTask.getEndTime().compareTo(newTask.getStartTime()) <= 0) {
            logger.warning("End time must be greater than start time for task: " + newTask.getDescription());
            return true;
        }

        for (Task task : existingTasks) {
            if (timeOverlap(newTask, task)) {
                logger.warning("Task conflict detected with existing task: " + task.getDescription());
                return true;
            }
        }
        return false;
    }

    private boolean timeOverlap(Task newTask, Task existingTask) {
        return (newTask.getStartTime().compareTo(existingTask.getEndTime()) < 0 &&
                newTask.getEndTime().compareTo(existingTask.getStartTime()) > 0);
    }
}
