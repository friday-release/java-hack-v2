package ru.fridayrelease.loyalty.domain.tenant.exception;

/**
 * @author avbelyaev
 */
public class TenantNotFoundException extends IllegalStateException {

    // TODO add UUIDs

    public TenantNotFoundException() {
        super("Tenant not found");
    }
}
