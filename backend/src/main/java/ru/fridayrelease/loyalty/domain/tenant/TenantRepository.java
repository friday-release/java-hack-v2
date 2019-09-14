package ru.fridayrelease.loyalty.domain.tenant;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * @author avbelyaev
 */
public interface TenantRepository {

    Optional<Tenant> findByOgrn(@Nonnull String ogrn);

    Optional<Tenant> findById(@Nonnull String id);
}
