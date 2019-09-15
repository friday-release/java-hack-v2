package ru.fridayrelease.loyalty.port.adapter.api.trophy;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.fridayrelease.loyalty.domain.trophy.TrophyRepository;

import javax.annotation.Nonnull;
import java.util.stream.Collectors;

/**
 * @author avbelyaev
 */
@RestController
@RequiredArgsConstructor
public class TrophyController {

    @Nonnull
    private final TrophyRepository trophyRepository;

    @GetMapping("/api/tenants/{tenantId}/trophies")
    public ResponseEntity getAllTrophies(@PathVariable("tenantId") String tenantId) {
        var trophies = this.trophyRepository
                .findAll().stream()
                .filter(trophy -> trophy.getTenantId().equals(tenantId))
                .map(TrophyModel::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(trophies);
    }
}
