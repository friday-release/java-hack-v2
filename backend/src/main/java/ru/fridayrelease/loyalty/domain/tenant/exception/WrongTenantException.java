package ru.fridayrelease.loyalty.domain.tenant.exception;

/**
 * @author avbelyaev
 */
public class WrongTenantException extends IllegalStateException {

    // TODO add UUIDs

    public WrongTenantException() {
        super("Tenant does not match provided in a task");
    }
}
