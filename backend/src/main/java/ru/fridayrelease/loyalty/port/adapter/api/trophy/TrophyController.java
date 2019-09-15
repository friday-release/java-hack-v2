package ru.fridayrelease.loyalty.port.adapter.api.trophy;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fridayrelease.loyalty.application.TrophyService;
import ru.fridayrelease.loyalty.domain.trophy.TrophyRepository;
import ru.fridayrelease.loyalty.domain.trophy.exception.InvalidTrophyException;
import ru.fridayrelease.loyalty.domain.trophy.exception.TrophyNotFoundException;

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

    @Nonnull
    private final TrophyService trophyService;

    @GetMapping("/api/tenants/{tenantId}/trophies")
    public ResponseEntity getAllTrophies(@PathVariable("tenantId") String tenantId) {
        var trophies = this.trophyRepository
                .findAll().stream()
                .filter(trophy -> trophy.getTenantId().equals(tenantId))
                .map(TrophyModel::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(trophies);
    }

    @PostMapping("/api/tenants/{tenantId}/trophies/{trophyId}")
    public ResponseEntity acceptTrophy(@PathVariable("tenantId") String tenantId,
                                       @PathVariable("trophyId") String trophyId) {
        trophyService.buyTrophy(tenantId, trophyId);
        return ResponseEntity.ok().build();
    }
}
