package ru.fridayrelease.loyalty.domain.trophy.exception;

public class TrophyNotFoundException extends IllegalStateException {
    public TrophyNotFoundException() {
        super("Trophy not found");
    }
}
