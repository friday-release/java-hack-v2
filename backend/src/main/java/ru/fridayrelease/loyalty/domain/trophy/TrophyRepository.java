package ru.fridayrelease.loyalty.domain.trophy;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Optional;

/**
 * @author avbelyaev
 */
public interface TrophyRepository {

    @Nonnull
    List<Trophy> findAll();

    @Nonnull
    Optional<Trophy> findById(String id);

    void  add(Trophy trophy);
}
