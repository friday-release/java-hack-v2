package ru.fridayrelease.loyalty.domain.trophy.exception;

public class InvalidTrophyException extends IllegalArgumentException {
    public InvalidTrophyException() {
        super("Trophy is invalid.");
    }
}
