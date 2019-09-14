package ru.fridayrelease.loyalty.domain.task.exception;

/**
 * @author avbelyaev
 */
public class InvalidTaskStateException extends IllegalStateException {

    // TODO add UUIDs

    public InvalidTaskStateException() {
        super("Task cannot be transitioned to provided state");
    }
}
