package ru.fridayrelease.loyalty.domain.trophy;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * @author avbelyaev
 */
public interface TrophyRepository {

    @Nonnull
    List<Trophy> findAll();
}
