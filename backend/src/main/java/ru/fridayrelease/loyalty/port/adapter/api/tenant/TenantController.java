package ru.fridayrelease.loyalty.port.adapter.api.tenant;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.fridayrelease.loyalty.domain.tenant.TenantRepository;
import ru.fridayrelease.loyalty.domain.tenant.exception.TenantNotFoundException;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class TenantController {

    @Nonnull
    private final TenantRepository tenantRepository;

    @GetMapping("/api/tenants/{tenantId}")
    public ResponseEntity<TenantModel> getTenantById(@PathVariable("tenantId") String id) {
        var tenant = tenantRepository
                .findById(id)
                .map(TenantModel::new)
                .orElseThrow(TenantNotFoundException::new);
        return ResponseEntity.ok(tenant);
    }

    @GetMapping("/api/tenants")
    public ResponseEntity<List<TenantModel>> getAllTenants() {
        var tenants = tenantRepository
                .findAll().stream()
                .map(TenantModel::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(tenants);
    }
}
