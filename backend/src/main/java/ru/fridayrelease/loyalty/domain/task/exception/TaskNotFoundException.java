package ru.fridayrelease.loyalty.domain.task.exception;

/**
 * @author avbelyaev
 */
public class TaskNotFoundException extends IllegalStateException {

    // TODO add UUIDs

    public TaskNotFoundException() {
        super("Task not found");
    }
}
