package ru.fridayrelease.loyalty.domain.task.exception;

/**
 * @author avbelyaev
 */
public class TaskNotFoundException extends IllegalStateException {

    public TaskNotFoundException() {
        super("Task not found");
    }
}
