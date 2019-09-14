package ru.fridayrelease.loyalty.service;

import ru.fridayrelease.loyalty.dao.Achievement;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * @author avbelyaev
 */
public interface AchievementService {

    @Nonnull
    public List<Achievement> getAllAchievements();
}
