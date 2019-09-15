package ru.fridayrelease.loyalty.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fridayrelease.loyalty.domain.tenant.TenantRepository;
import ru.fridayrelease.loyalty.domain.tenant.exception.TenantNotFoundException;
import ru.fridayrelease.loyalty.domain.trophy.TrophyRepository;
import ru.fridayrelease.loyalty.domain.trophy.TrophyState;
import ru.fridayrelease.loyalty.domain.trophy.exception.InvalidTrophyException;
import ru.fridayrelease.loyalty.domain.trophy.exception.NotEnoughPointsException;
import ru.fridayrelease.loyalty.domain.trophy.exception.TrophyNotFoundException;

import javax.annotation.Nonnull;

/**
 * @author avbelyaev
 */
@Service
@RequiredArgsConstructor
public class TrophyService {

    @Nonnull
    private final TenantRepository tenantRepository;

    @Nonnull
    private final TrophyRepository trophyRepository;

    @Transactional
    public void buyTrophy(@Nonnull String tenantId, @Nonnull String trophyId) {
        var trophy = trophyRepository.findById(trophyId).orElseThrow(TrophyNotFoundException::new);
        if(!trophy.getTenantId().equals(tenantId)) {
            throw new InvalidTrophyException();
        }
        var tenant = tenantRepository.findById(tenantId).orElseThrow(TenantNotFoundException::new);

        if(trophy.getPointsCost() > tenant.getPoints()) {
            throw new NotEnoughPointsException();
        }

        trophy.setState(TrophyState.COMPLETED);
        trophyRepository.add(trophy);

        tenant.setPoints(tenant.getPoints() - trophy.getPointsCost());
        tenantRepository.add(tenant);
    }
}
