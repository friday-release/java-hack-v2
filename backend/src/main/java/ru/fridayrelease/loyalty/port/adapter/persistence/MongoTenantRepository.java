package ru.fridayrelease.loyalty.port.adapter.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import ru.fridayrelease.loyalty.domain.tenant.Tenant;
import ru.fridayrelease.loyalty.domain.tenant.TenantRepository;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Optional;

/**
 * @author avbelyaev
 */
@Service
@RequiredArgsConstructor
public class MongoTenantRepository implements TenantRepository {

    @Nonnull
    private final MongoTemplate mongoTemplate;

    @Nonnull
    @Override
    public Optional<Tenant> findById(@Nonnull String id) {
        var tenant = this.mongoTemplate.findById(id, Tenant.class);
        return Optional.ofNullable(tenant);
    }

    @Override
    public void add(@Nonnull Tenant tenant) {
        this.mongoTemplate.save(tenant);
    }

    @Nonnull
    @Override
    public List<Tenant> findAll() {
        return this.mongoTemplate.findAll(Tenant.class);
    }
}
