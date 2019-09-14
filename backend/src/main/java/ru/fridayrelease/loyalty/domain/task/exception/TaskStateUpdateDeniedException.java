package ru.fridayrelease.loyalty.domain.task.exception;

/**
 * @author avbelyaev
 */
public class TaskStateUpdateDeniedException extends IllegalStateException {

    public TaskStateUpdateDeniedException() {
        super("Task cannot be transitioned to provided state");
    }
}
