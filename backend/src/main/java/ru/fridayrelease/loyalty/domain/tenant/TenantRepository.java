package ru.fridayrelease.loyalty.domain.tenant;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * @author avbelyaev
 */
public interface TenantRepository {

    @Nonnull
    Optional<Tenant> findByOgrn(@Nonnull String ogrn);

    @Nonnull
    Optional<Tenant> findById(@Nonnull String id);
}
