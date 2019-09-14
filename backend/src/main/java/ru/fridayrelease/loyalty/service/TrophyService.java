package ru.fridayrelease.loyalty.service;

import ru.fridayrelease.loyalty.dao.trophy.Trophy;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * @author avbelyaev
 */
public interface TrophyService {

    @Nonnull
    public List<Trophy> getAllTrophies();
}
