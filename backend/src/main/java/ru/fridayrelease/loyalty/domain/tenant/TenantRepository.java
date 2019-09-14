package ru.fridayrelease.loyalty.domain.tenant;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Optional;

/**
 * @author avbelyaev
 */
public interface TenantRepository {

    @Nonnull
    Optional<Tenant> findById(@Nonnull String id);

    void add(@Nonnull Tenant tenant);

    @Nonnull
    List<Tenant> findAll();
}
