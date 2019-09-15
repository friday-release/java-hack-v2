package ru.fridayrelease.loyalty.domain.trophy.exception;

public class NotEnoughPointsException extends IllegalStateException {
    public NotEnoughPointsException() {
        super("Tenant has not enough points.");
    }
}
