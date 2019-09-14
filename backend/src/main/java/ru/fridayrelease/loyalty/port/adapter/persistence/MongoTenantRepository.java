package ru.fridayrelease.loyalty.port.adapter.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import ru.fridayrelease.loyalty.domain.tenant.Tenant;
import ru.fridayrelease.loyalty.domain.tenant.TenantRepository;

import javax.annotation.Nonnull;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * @author avbelyaev
 */
@Service
@RequiredArgsConstructor
public class MongoTenantRepository implements TenantRepository {

    @Nonnull
    private final MongoTemplate mongoTemplate;

    @Override
    public Optional<Tenant> findByOgrn(@Nonnull String ogrn) {
        Criteria ogrnCriteria = where("ogrn").is(ogrn);
        var tenant = this.mongoTemplate
                .find(query(ogrnCriteria), Tenant.class)
                .stream()
                .findFirst();
        return tenant;
    }
}
