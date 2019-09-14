package ru.fridayrelease.loyalty.domain.tenant.exception;

/**
 * @author avbelyaev
 */
public class TenantMismatchException extends IllegalStateException {

    // TODO add UUIDs

    public TenantMismatchException() {
        super("Tenant does not match provided in a task");
    }
}
